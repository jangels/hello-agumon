/*
 * 文件名：Decrypt.java
 * 版权： Copyright 2014-2017 .
 * 描述：〈描述〉
 * 修改人：137127
 * 修改时间：2017年1月17日
 * 修改单号：2017年1月17日
 * 修改内容：〈修改内容〉
 */
package org.smallfire.java.cipher;

/**
 * 解密工具方法定义
 * @author 137127
 * @version [1.0.0, 2017年1月17日]
 */
public interface Decrypt {
	
	/**
	 * 数据类型 hex
	 */
	public static final Integer HEX = 1;
	/**
	 * 数据类型 base64
	 */
	public static final Integer BASE64 = 2;

	/**
	 * 对密文Hex字符串进行解密，返回字节数组
	 * @author 137127
	 * @param hexEncodedInfo 密文字符串
	 * @return byte[] 解密的字节数组
	 * @exception/throws BusinessException 解密失败
	 */
	byte[] decrypt(final String hexEncodedInfo);
	
	/**
	 * 对密文Hex字符串进行解密，返回字节数组
	 * @author 137127
	 * @param encodedInfo 密文字符串
	 * @param encodedType 字节数组转换类型  1Hex 2Base64
	 * @return byte[] 解密的字节数组
	 * @exception/throws BusinessException 解密失败
	 */
	byte[] decrypt(final String encodedInfo, int encodedType);

	/**
	 * 
	 * 对密文字节数组进行解密，返回字节数组
	 * @author 137127
	 * @param bytes 密文字节数组
	 * @return byte[] 解密的字节数组
	 * @exception/throws BusinessException 解密失败
	 */
	byte[] decrypt(final byte[] bytes);

	/**
	 * 对密文字符串进行解密，返回UTF-8字符串
	 * @author 137127
	 * @param hexEncodedInfo 密文字符串
	 * @return String 解密后的UTF-8字符串
	 * @exception/throws BusinessException 解密失败
	 */
	String decrypt2UTF8(final String hexEncodedInfo);
	/**
	 * 对密文字符串进行解密，返回UTF-8字符串
	 * @author 137127
	 * @param encodedInfo 密文字符串
	 * @param encodedType 字节数组转换类型  1Hex 2Base64
	 * @return String 解密后的UTF-8字符串
	 * @exception/throws BusinessException 解密失败
	 */
	String decrypt2UTF8(final String encodedInfo, int encodedType);
	/**
	 * 对密文字节数组进行解密，返回UTF-8字符串
	 * @author 137127
	 * @param bytes 密文字节数组
	 * @return String 解密后的UTF-8字符串
	 * @exception/throws BusinessException 解密失败
	 */
	String decrypt2UTF8(final byte[] bytes);
	

}
