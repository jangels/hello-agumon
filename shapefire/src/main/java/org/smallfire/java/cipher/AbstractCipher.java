/*
 * 文件名：AbstractCipher.java
 * 版权： Copyright 2014-2017 北京思源政务通科技有限公司.
 * 描述：〈描述〉
 * 修改人：137127
 * 修改时间：2017年1月19日
 * 修改单号：2017年1月19日
 * 修改内容：〈修改内容〉
 */
package org.smallfire.java.cipher;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;

import java.nio.charset.StandardCharsets;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author    137127
 * @version   [1.0.0, 2017年1月19日]
 */
public abstract class AbstractCipher extends AbstractEncrypt implements Encrypt, Decrypt{

	@Override
	public byte[] decrypt(String hexEncodedInfo) {
		byte[] decrypted = decrypt(hexEncodedInfo, Decrypt.HEX);
		return decrypted;
	}

	@Override
	public byte[] decrypt(String encodedInfo, int encodedType) {
		byte[] decode = null;
		if (encodedType == Decrypt.BASE64) {
			byte[] bytes = encodedInfo.getBytes(StandardCharsets.UTF_8);
			decode = Base64.decode(bytes);
		} else {
			decode = Hex.decode(encodedInfo);
		}
		byte[] decrypted = decrypt(decode);
		return decrypted;
	}

	@Override
	public String decrypt2UTF8(String hexEncodeInfo) {
		byte[] decrypted = decrypt(hexEncodeInfo);
		String decryptedInfo = new String(decrypted, StandardCharsets.UTF_8);
		return decryptedInfo;
	}

	@Override
	public String decrypt2UTF8(String encodeInfo, int encodedType) {
		byte[] decrypted = decrypt(encodeInfo, encodedType);
		String decryptedInfo = new String(decrypted, StandardCharsets.UTF_8);
		return decryptedInfo;
	}

	@Override
	public String decrypt2UTF8(byte[] bytes) {
		byte[] decrypted = decrypt(bytes);
		String decryptedInfo = new String(decrypted, StandardCharsets.UTF_8);
		return decryptedInfo;
	}

}
