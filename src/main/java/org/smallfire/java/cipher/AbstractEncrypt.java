/*
 * 文件名：AbstractEncrypt.java
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
public abstract class AbstractEncrypt implements Encrypt{

	@Override
	public byte[] encrypt(String info) {
		byte[] bytes = info.getBytes(StandardCharsets.UTF_8);
		byte[] encrypt = encrypt(bytes);
		return encrypt;

	}

	@Override
	public String encrypt2Hex(String info) {
		byte[] encrypted = encrypt(info);
		String encoded = Hex.encodeToString(encrypted);
		return encoded;
	}

	@Override
	public String encrypt2Hex(byte[] bytes) {
		byte[] encrypted = encrypt(bytes);
		String encoded = Hex.encodeToString(encrypted);
		return encoded;
	}

	@Override
	public String encrypt2B64(String info) {
		byte[] encrypted = encrypt(info);
		String encoded = Base64.encodeToString(encrypted);
		return encoded;
	}

	@Override
	public String encrypt2B64(byte[] bytes) {
		byte[] encrypted = encrypt(bytes);
		String encoded = Base64.encodeToString(encrypted);
		return encoded;
	}

}
