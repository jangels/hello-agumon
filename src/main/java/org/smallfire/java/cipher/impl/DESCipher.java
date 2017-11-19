/*
 * 文件名：DESCipher.java
 * 版权： Copyright 2014-2017 北京思源政务通科技有限公司.
 * 描述：〈描述〉
 * 修改人：137127
 * 修改时间：2017年1月19日
 * 修改单号：2017年1月19日
 * 修改内容：〈修改内容〉
 */
package org.smallfire.java.cipher.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smallfire.java.cipher.AbstractCipher;
import org.smallfire.java.cipher.CipherAlgorithms;
import org.smallfire.java.cipher.Decrypt;
import org.smallfire.java.cipher.Encrypt;
import org.smallfire.java.exception.BusinessException;
import org.smallfire.java.exception.SdkExceptionCode;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * DES 加密和解密方法
 * 
 * @author 137127
 * @version [1.0.0, 2017年1月19日]
 */
public class DESCipher extends AbstractCipher implements Encrypt, Decrypt {

	private static Logger logger = LoggerFactory.getLogger(DESCipher.class);

	public static final Integer KEY_LENGTH = 56;

	private Key secretKey;

	/**
	 * 构造DES的加密
	 * 
	 * @param secretKey 加密后的秘钥
	 */
	public DESCipher(String secretKey) {
		toKey(secretKey.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * 
	 * 把字符数组转为des的Key
	 * @author 137127
	 * @param key
	 * @exception/throws BusinessException DES_UTIS_KEY_GEN_ERROR
	 */
	public void toKey(byte[] key) {
		try {
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(key);
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(CipherAlgorithms.DES_ALGORITHM);
            // 将DESKeySpec对象转换成SecretKey对象
            this.secretKey = keyFactory.generateSecret(desKey);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BusinessException(SdkExceptionCode.DES_UTIS_KEY_GEN_ERROR);
		}
	}


	@Override
	public byte[] decrypt(byte[] bytes) {
		try {
			Cipher cipher = getCipher( Cipher.DECRYPT_MODE);
			byte[] data = cipher.doFinal(bytes);
			return data;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BusinessException(SdkExceptionCode.DECRYPT_DES_FAIL);
		}
	}

	@Override
	public byte[] encrypt(byte[] bytes) {
		try {
			Cipher cipher = getCipher( Cipher.ENCRYPT_MODE);
			byte[] encrypted = cipher.doFinal(bytes);
			return encrypted;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BusinessException(SdkExceptionCode.ENCRYPT_DES_FAIL);
		}
	}

	/**
	 * 
	 * 获取密码对象（用于加密解密）
	 * @param modeType 加密或者解密类型 Cipher.ENCRYPT_MODE or Cipher.DECRYPT_MODE
	 * @author 137127
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 */
	private Cipher getCipher(int modeType) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		SecureRandom random = new SecureRandom();
		Cipher cipher = Cipher.getInstance(CipherAlgorithms.DES_PK5_PADDING);
		cipher.init(modeType, this.secretKey,random);
		return cipher;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		DESCipher des = new DESCipher("qGSIGhsxhiQKBgQCTPx3DQEBAQUAA4GNADCBzGhd2CxnK+BOIbu90cIocbTWWulz");
		String str1 = "加密串";
		//str1 = URLEncoder.encode(str1, "UTF-8");
		// DES 加密字符串
		String str2 = des.encrypt2Hex(str1);
		// DES 解密字符串
		byte[] decrypt = des.decrypt(str2);
		System.out.println(" 加密前： " + str1);
		System.out.println(" 加密后： " + str2);
		System.out.println(new String(decrypt));
		String deStr = URLDecoder.decode(new String(decrypt), "UTF-8");
		System.out.println(" 解密后： " + deStr);
	}
}
