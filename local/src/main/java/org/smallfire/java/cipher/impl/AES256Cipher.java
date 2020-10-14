/*
 * 文件名：AES256Cipher.java
 * 版权： Copyright 2014-2017 北京思源政务通科技有限公司.
 * 描述：〈描述〉
 * 修改人：137127
 * 修改时间：2017年1月18日
 * 修改单号：2017年1月18日
 * 修改内容：〈修改内容〉
 */
package org.smallfire.java.cipher.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smallfire.java.cipher.AbstractCipher;
import org.smallfire.java.cipher.CipherAlgorithms;
import org.smallfire.java.cipher.Decrypt;
import org.smallfire.java.cipher.Encrypt;
import org.smallfire.java.exception.BusinessException;
import org.smallfire.java.exception.SdkExceptionCode;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.*;

/**
 * AES 对称加密和解密工作
 * 
 * @author 137127
 * @version [1.0.0, 2017年1月18日]
 */
public class AES256Cipher extends AbstractCipher implements Encrypt, Decrypt {

	private static Logger logger = LoggerFactory.getLogger(AES256Cipher.class);

	/**
	 * 生成秘钥的长度为256位
	 */
	public static final Integer KEY_LENGTH = 128;

	/**
	 * 秘钥
	 */
	private Key secretKey;

	/**
	 * 
	 * 生成一个秘钥字节数组
	 * 
	 * @author 137127
	 * @return
	 * @exception/throws BusinessException ALGORITHM_IS_ILLEGAL
	 *                   BusinessException BOUNCY_CASTLE_PROVIDER_NO_EXIS
	 */
	public static byte[] generateKey() {
		// 实例化密钥生成器
		try {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

			KeyGenerator kg = KeyGenerator.getInstance(CipherAlgorithms.AES_ALGORITHM, CipherAlgorithms.BC_PROVIDER);
			// 初始化密钥生成器长度为256，AES要求密钥长度为128位、192位、256位
			kg.init(KEY_LENGTH);
			// 生成密钥
			SecretKey secretKey = kg.generateKey();
			// 获取二进制密钥编码形式
			byte[] encoded = secretKey.getEncoded();

			return encoded;
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
			throw new BusinessException(SdkExceptionCode.ALGORITHM_IS_ILLEGAL);
		} catch (NoSuchProviderException e) {
			logger.error(e.getMessage());
			throw new BusinessException(SdkExceptionCode.BOUNCY_CASTLE_PROVIDER_NO_EXIS);
		}
	}

	/**
	 * 生成一个hex字符串秘钥
	 * 
	 * @author 137127
	 * @return
	 * @exception/throws BusinessException ALGORITHM_IS_ILLEGAL
	 *                   BusinessException BOUNCY_CASTLE_PROVIDER_NO_EXIS
	 */
	public static String generateKey2Hex() {
		byte[] initkey = generateKey();
		String key = Hex.encodeToString(initkey);
		return key;
	}

	/**
	 * 生成一个Base64字符串秘钥
	 * 
	 * @author 137127
	 * @return
	 * @exception/throws BusinessException ALGORITHM_IS_ILLEGAL
	 *                   BusinessException BOUNCY_CASTLE_PROVIDER_NO_EXIS
	 */
	public static String generateKey2B64() {
		byte[] initkey = generateKey();
		String key = Base64.encodeToString(initkey);
		return key;
	}

	private Key toKey(byte[] key) {
		// 实例化key
		SecretKey secretKey = new SecretKeySpec(key, CipherAlgorithms.AES_ALGORITHM);
		return secretKey;
	}

	/**
	 * 构造AES256的加密
	 * 
	 * @param encodedSecretKey
	 *            加密后得秘钥
	 * @param encodedType
	 *            加密方式 1Hex 2Base64
	 */
	public AES256Cipher(String encodedSecretKey, int encodedType) {

		if (StringUtils.isEmpty(encodedSecretKey)) {
			logger.error("AES256Cipher初始化失败，hexSecretKey为空");
			throw new BusinessException(SdkExceptionCode.PARAM_IS_NULL);
		}
		byte[] bytes = null;
		if (encodedType == Decrypt.BASE64) {
			bytes = Base64.decode(encodedSecretKey);
		} else {
			bytes = Hex.decode(encodedSecretKey);
		}
		this.secretKey = toKey(bytes);
	}

	@Override
	public byte[] decrypt(byte[] bytes) {
		try {
			// 调用bouncycastle组件实现
			Cipher cipher = getEncryptCipher(Cipher.DECRYPT_MODE);
			// 执行操作
			byte[] decrypted = cipher.doFinal(bytes);
			return decrypted;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BusinessException(SdkExceptionCode.DECRYPT_FAIL);
		}
	}



	@Override
	public byte[] encrypt(byte[] bytes) {
		try {
			Cipher cipher = getEncryptCipher(Cipher.ENCRYPT_MODE);
			
			// 执行操作
			byte[] result = cipher.doFinal(bytes);
			return result;

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BusinessException(SdkExceptionCode.ENCRYPT_FAIL);
		}

	}

	private Cipher getEncryptCipher(int type)
			throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance(CipherAlgorithms.AES_PK5_PADDING, CipherAlgorithms.BC_PROVIDER);
		// 初始化，设置为解密模式
		cipher.init(type, this.secretKey);
		return cipher;
	}

	public static void main(String[] args) throws IOException {
		String key = AES256Cipher.generateKey2Hex();
		System.out.println("key:"+key);
		/*AES256Cipher cipher = new AES256Cipher(key, Decrypt.HEX);
		String info = "加密信息";

		String encrypt2Hex = cipher.encrypt2Hex(info);

		System.out.println(encrypt2Hex);

		String decrypt2utf8 = cipher.decrypt2UTF8(encrypt2Hex);

		System.out.println(decrypt2utf8);
		System.out.println(decrypt2utf8.equals(info));

		System.out.println("==============");

		String b64key = AES256Cipher.generateKey2B64();
		AES256Cipher cipherb64 = new AES256Cipher(b64key, Decrypt.BASE64);
		String infob64 = "加密信息";

		String encrypt2b64 = cipherb64.encrypt2B64(infob64);

		System.out.println(encrypt2b64);

		String decrypt2utf8b64 = cipherb64.decrypt2UTF8(encrypt2b64, Decrypt.BASE64);

		System.out.println(decrypt2utf8b64);
		System.out.println(decrypt2utf8b64.equals(infob64));

		System.out.println("==============");*/

	}

}
