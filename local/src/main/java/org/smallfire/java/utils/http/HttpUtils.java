package org.smallfire.java.utils.http;

import okhttp3.*;
import okhttp3.FormBody.Builder;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smallfire.java.exception.BusinessException;
import org.smallfire.java.exception.SdkExceptionCode;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

/**
 * Http/Https 调用工具类
 * <p>
 * SPDY 调用需要添加jvm参数
 * -Xbootclasspath/p:npn-boot-1.1.7.v20140316.jar
 * -Xbootclasspath/p:alpn-boot-7.1.2.v20141202.jar
 */

/**
 * 
 * Http/Https 调用工具类 实现同步/异步获取数据
 * 
 * @version [1.0.0, 2017年1月11日]
 *
 */
public class HttpUtils {
	
	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	
	private static OkHttpClient mOkHttpClient = null;

	/**
	 * 超时时间
	 */
	public static final Long TIME_OUT_SECONDS = 30L;

	public static final String MEDIA_TYPE_JSON = "application/json; charset=utf-8";

	public static final String CHARSET_UTF8 = "UTF-8";

	
	/**
	 * 
	 * 请求超时的设置
	 * @author 137127
	 * @param timeOutSeconds  超时时间
	 * @param readTimeOut 读超时
	 * @param writeTimeOut  写超时
	 */
	public static void init(Long timeOutSeconds,Long readTimeOut,Long writeTimeOut ){
		OkHttpClient.Builder builder = new OkHttpClient.Builder();

		if(null != timeOutSeconds && 0L <= timeOutSeconds){
			builder.connectTimeout(timeOutSeconds, TimeUnit.SECONDS);
		}else{
			builder.connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS);
		}
		
		if(null != readTimeOut && 0L <= readTimeOut){
			builder.readTimeout(readTimeOut, TimeUnit.SECONDS);
		}
		
		if(null != writeTimeOut && 0L <= writeTimeOut){
			builder.writeTimeout(writeTimeOut, TimeUnit.SECONDS);
		}
		mOkHttpClient = builder.build();
	}

	/**
	 * 
	 * 初始化httpclient链接
	 * 
	 * @author 137127
	 * @param request
	 * @return
	 */
	private static OkHttpClient getHttpClient(Request request) {
		if(null == mOkHttpClient){
			init(TIME_OUT_SECONDS, null, null);
		}
		OkHttpClient.Builder builder = mOkHttpClient.newBuilder();

		if (!request.isHttps())
			return builder.build();

		SSLBuilder sslBuilder = SSLBuilder.builder();
		return builder.sslSocketFactory(sslBuilder.getSSLSocketFactory(), sslBuilder.getX509TrustManager())
				.hostnameVerifier(sslBuilder.getNotVerifyHostnameVerifier()).build();
	}

	private static Request getRequest(String url, Headers headers, Map<String, String> paramsMap, String body) {
		Request.Builder builder = new Request.Builder().url(attachParam(url, paramsMap));
		if (headers != null) {
			builder.headers(headers);
		}
		if (StringUtils.isNotBlank(body)) {
			builder.post(RequestBody.create(MediaType.parse(MEDIA_TYPE_JSON), body));
		}
		return builder.build();
	}

	private static Request getFormRequest(String url, Headers headers, Map<String, String> paramsMap,
			Map<String, String> body) {
		Request.Builder builder = new Request.Builder().url(attachParam(url, paramsMap));
		if (headers != null) {
			builder.headers(headers);
		}
		if (null != body && !body.isEmpty()) {
			Builder formBuilder = new Builder();
			Set<Entry<String, String>> entrySet = body.entrySet();
			for (Entry<String, String> entry : entrySet) {
				formBuilder.add(entry.getKey(), entry.getValue());
			}
			builder.post(formBuilder.build());
		}
		return builder.build();
	}

	/**
	 * 
	 * 拼接参数
	 * 
	 * @author 137127
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	private static String attachParam(String url, Map<String, String> paramsMap) {
		if (MapUtils.isEmpty(paramsMap))
			return url;
		List<BasicNameValuePair> params = new ArrayList<>();
		for (String key : paramsMap.keySet()) {
			params.add(new BasicNameValuePair(key, paramsMap.get(key)));
		}
		if (url.endsWith("?")) {
			return url + URLEncodedUtils.format(params, CHARSET_UTF8);
		}
		return url + "?" + URLEncodedUtils.format(params, CHARSET_UTF8);
	}

	/**
	 * 同步请求
	 *
	 * @param request
	 * @return
	 */
	public static Response execute(Request request) {
		try {
			return getHttpClient(request).newCall(request).execute();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 异步请求
	 *
	 * @param request
	 * @param callback
	 */
	public static void enqueue(Request request, Callback callback) {
		getHttpClient(request).newCall(request).enqueue(callback);
	}

	/**
	 * 
	 * 异步请求Get
	 * 
	 * @author 137127
	 * @param url
	 * @param callback
	 */
	public static void asyncGet(String url, Callback callback) {
		asyncGet(url, null, callback);
	}

	public static void asyncGet(String url, Headers headers, Callback callback) {
		asyncGet(url, headers, null, callback);
	}

	public static void asyncGet(String url, Headers headers, Map<String, String> paramsMap, Callback callback) {
		enqueue(getRequest(url, headers, paramsMap, null), callback);
	}

	/**
	 * 异步Post
	 *
	 * @param url
	 * @param callback
	 */
	public static void asyncPost(String url, Callback callback) {
		asyncPost(url, null, callback);
	}

	public static void asyncPost(String url, Headers headers, Callback callback) {
		asyncPost(url, headers, null, callback);
	}

	public static void asyncPost(String url, Headers headers, String body, Callback callback) {
		enqueue(getRequest(url, headers, null, body), callback);
	}

	/**
	 * 同步Get请求
	 * 
	 * @author 137127
	 * @param url
	 * @return
	 */
	public static Response syncGet(String url) {
		return syncGet(url, null);
	}

	public static Response syncGet(String url, Headers headers) {
		return syncGet(url, headers, null);
	}

	public static Response syncGet(String url, Headers headers, Map<String, String> paramsMap) {
		return execute(getRequest(url, headers, paramsMap, null));
	}

	public static String syncGetString(String url) {
		return syncGetString(url, null);
	}

	public static String syncGetString(String url, Headers headers) {
		return syncGetString(url, headers, null);
	}

	public static String syncGetString(String url, Headers headers, Map<String, String> paramsMap) {
		try (Response response = syncGet(url, headers, paramsMap)) {
//			if (!response.isSuccessful())
//				throw new IOException("Unexpected code " + response);
			verifySuccess(response.code());
			return response.body().string();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *
	 * 同步Post请求
	 * 
	 * @author 137127
	 * @param url
	 * @return
	 */
	public static Response syncPost(String url) {
		return syncPost(url, null);
	}

	public static Response syncPost(String url, Headers headers) {
		return syncPost(url, headers, null);
	}

	public static Response syncPost(String url, Headers headers, String body) {
		return execute(getRequest(url, headers, null, body));
	}

	public static Response syncPostForm(String url, Headers headers, Map<String, String> body) {
		return execute(getFormRequest(url, headers, null, body));
	}

	public static String syncPostString(String url) {
		return syncPostString(url, null);
	}

	public static String syncPostString(String url, Headers headers) {
		return syncPostString(url, null, null);
	}

	public static String syncPostString(String url, Headers headers, String body) {
		try (Response response = syncPost(url, headers, body)) {
//			if (!response.isSuccessful())
//				throw new IOException("Unexpected code " + response);
			verifySuccess(response.code());
			return response.body().string();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String syncFormPostString(String url, Headers headers, Map<String, String> body) {
		try (Response response = syncPostForm(url, headers, body)) {
			//此处由于toon返回错误码的同时请求状态码返回302,导致此处直接抛出IOException,调用方无法获得错误码
			//同时联系toon方面,他们会调整此处代码
//			if (!response.isSuccessful())
//				throw new IOException("Unexpected code " + response);
			//针对上面的问题重新定义了对response code的判断
			verifySuccess(response.code());
			return response.body().string();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void verifySuccess(int code){
		if(code < 200 && code > 302){
			logger.error("Unexpected code " + code);
			throw new BusinessException(SdkExceptionCode.HTTP_CODE_WRONG);
		}
	}

	/**
	 * SSL/TLS处理类
	 */
	private static class SSLBuilder {
		private String certFileLocation;

		public static SSLBuilder builder() {
			return new SSLBuilder();
		}

		public static SSLBuilder builder(String certFileLocation) {
			SSLBuilder builder = new SSLBuilder();
			builder.certFileLocation = certFileLocation;
			return builder;
		}

		public HostnameVerifier getNotVerifyHostnameVerifier() {
			return new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};
		}

		public X509TrustManager getX509TrustManager() {
			try {
				if (StringUtils.isNotBlank(certFileLocation)) {
					return trustManagerForCertificates(getClass().getResourceAsStream(certFileLocation));
				} else {
					return trustManagerForCertificates();
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		public SSLSocketFactory getSSLSocketFactory() {
			try {
				SSLContext sslContext = SSLContext.getInstance("TLS");
				sslContext.init(null, new TrustManager[] { getX509TrustManager() }, new SecureRandom());
				return sslContext.getSocketFactory();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		private X509TrustManager trustManagerForCertificates() {
			return new X509TrustManager() {
				@Override
				public void checkClientTrusted(X509Certificate[] x509Certificates, String s)
						throws CertificateException {

				}

				@Override
				public void checkServerTrusted(X509Certificate[] x509Certificates, String s)
						throws CertificateException {

				}

				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}
			};
		}

		private X509TrustManager trustManagerForCertificates(InputStream in) throws GeneralSecurityException {
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
			Collection<? extends Certificate> certificates = certificateFactory.generateCertificates(in);
			if (certificates.isEmpty()) {
				throw new IllegalArgumentException("expected non-empty set of trusted certificates");
			}

			// Put the certificates a key store.
			char[] password = "password".toCharArray(); // Any password will
														// work.
			KeyStore keyStore = newEmptyKeyStore(password);
			int index = 0;
			for (Certificate certificate : certificates) {
				String certificateAlias = Integer.toString(index++);
				keyStore.setCertificateEntry(certificateAlias, certificate);
			}

			// Use it to build an X509 trust manager.
			KeyManagerFactory keyManagerFactory = KeyManagerFactory
					.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			keyManagerFactory.init(keyStore, password);
			TrustManagerFactory trustManagerFactory = TrustManagerFactory
					.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			trustManagerFactory.init(keyStore);
			TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
			if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
				throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
			}
			return (X509TrustManager) trustManagers[0];
		}

		private KeyStore newEmptyKeyStore(char[] password) throws GeneralSecurityException {
			try {
				KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
				InputStream in = null; // By convention, 'null' creates an empty
										// key store.
				keyStore.load(in, password);
				return keyStore;
			} catch (IOException e) {
				throw new AssertionError(e);
			}
		}
	}
}