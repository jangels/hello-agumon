/*
 * 文件名：Encrypt.java
 * 版权： Copyright 2014-2017 北京思源政务通科技有限公司.
 * 描述：〈描述〉
 * 修改人：137127
 * 修改时间：2017年1月17日
 * 修改单号：2017年1月17日
 * 修改内容：〈修改内容〉
 */
package org.smallfire.java.cipher;

/**
 * 加密工具方法定义
 * @author    137127
 * @version   [1.0.0, 2017年1月17日]
 */
public interface Encrypt {

	/**
	 * 对UTF-8字符串进行加密
	 * @author 137127
	 * @param info 需要加密的UTF-8字符串 
	 * @return byte[] 加密后的字节数组
	 * @exception/throws BusinessException 加密失败
	 */
	byte[] encrypt(final String info);
	
	/**
	 * 
	 * 对字节数据进行加密
	 * @author 137127
	 * @param bytes 需要加密的字节数据
	 * @return byte[] 加密后的字节数组
	 * @exception/throws BusinessException 加密失败
	 */
	byte[] encrypt(final byte[] bytes);
	
	/**
	 * 对UTF-8字符串进行加密，返回Hex字符串
	 * @author 137127
	 * @param info 需要加密的UTF-8字符串 
	 * @return String 加密后的Hex字符串
	 * @exception/throws BusinessException 加密失败
	 */
	public String encrypt2Hex(final String info);
	
	/**
	 * 对字节数据进行加密，返回Hex字符串
	 * @author 137127
	 * @param  bytes 需要加密的字节数据
	 * @return String 加密后的Hex字符串
	 * @exception/throws BusinessException 加密失败
	 */
	String encrypt2Hex(final byte[] bytes);
	
	/**
	 * 对UTF-8字符串进行加密，返回Base64字符串
	 * @author 137127
	 * @param info 需要加密的UTF-8字符串 
	 * @return String 加密后的Base64字符串
	 * @exception/throws BusinessException 加密失败
	 */
	String encrypt2B64(final String info);
	
	/**
	 * 对字节数据进行加密，返回Base64字符串
	 * @author 137127
	 * @param  bytes 需要加密的字节数据
	 * @return String 加密后的Base64字符串
	 * @exception/throws BusinessException 加密失败
	 */
	String encrypt2B64(final byte[] bytes);
	
}
