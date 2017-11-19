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


import org.apache.shiro.codec.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smallfire.java.cipher.AbstractCipher;
import org.smallfire.java.cipher.CipherAlgorithms;
import org.smallfire.java.cipher.Decrypt;
import org.smallfire.java.cipher.Encrypt;
import org.smallfire.java.exception.BusinessException;
import org.smallfire.java.exception.SdkExceptionCode;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA2048 加密和解密方法
 * 
 * @author 137127
 * @version [1.0.0, 2017年1月19日]
 */
public class RSA2048Cipher extends AbstractCipher implements Encrypt, Decrypt {

    private static Logger logger = LoggerFactory.getLogger(RSA2048Cipher.class);
    //1024   117 128
    //2048  245 256
    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 245;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 256;
    

    private KeyPair rsaKeys;

    private Cipher cipher;

    /**
     * 构造RSA的加密
     * 
     * @param priKey
     *            加密后的私钥
     */
    public RSA2048Cipher(String pubKey,String priKey) {
        byte[] pubKeyBytes = Base64.decode(pubKey.getBytes());
        byte[] priKeyBytes = Base64.decode(priKey.getBytes());
        toKey(pubKeyBytes,priKeyBytes);
    }

    /**
     * 
     * 把字符数组转为Rsa的Key
     * 
     * @author 137127
     * @param key
     * @exception/throws BusinessException RSA_UTIS_KEY_GEN_ERROR
     */
    public void toKey( byte[] pubKey, byte[] priKey) {
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            
            X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(pubKey);  
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(priKey);  
          
            KeyFactory keyf = KeyFactory.getInstance(CipherAlgorithms.RSA_ALGORITHM,CipherAlgorithms.BC_PROVIDER);
            PublicKey pubkey = keyf.generatePublic(pubX509);  
            PrivateKey privkey = keyf.generatePrivate(priPKCS8);  
            this.rsaKeys = new KeyPair(pubkey, privkey);
            this.cipher = Cipher.getInstance(keyf.getAlgorithm());
        } catch (Exception e) {
            logger.error("公钥秘钥还原失败"+e.getMessage(),e);
            throw new BusinessException(SdkExceptionCode.RSA_UTIS_KEY_GEN_ERROR);
        }
    }

    @Override
    public byte[] decrypt(byte[] bytes) {
        try {
            Cipher cipher = getCipher(Cipher.DECRYPT_MODE, this.rsaKeys.getPrivate());
            int inputLen = bytes.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(bytes, offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(bytes, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] data = out.toByteArray();
            out.close();
            return data;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException(SdkExceptionCode.DECRYPT_RSA_FAIL);
        }
    }

    @Override
    public byte[] encrypt(byte[] bytes) {
        try {
            Cipher cipher = getCipher(Cipher.ENCRYPT_MODE,  this.rsaKeys.getPublic());
            int inputLen = bytes.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(bytes, offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(bytes, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            out.close();
            return encryptedData;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new BusinessException(SdkExceptionCode.ENCRYPT_RSA_FAIL);
        }
    }

    /**
     * 
     * 获取密码对象（用于加密解密）
     * 
     * @param modeType
     *            加密或者解密类型 Cipher.ENCRYPT_MODE or Cipher.DECRYPT_MODE
     * @author 137127
     * @return
     */
    private Cipher getCipher(int modeType, Key key){
        try {
            this.cipher.init(modeType, key);
            return this.cipher;
        } catch (InvalidKeyException e) {
            logger.error("获取加解密工具失败"+e.getMessage(),e);
            throw new BusinessException(SdkExceptionCode.RSA_CIPHER_GET_FAIL);
        }
    }
    
    public static KeyPair genKeyPair(){  
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(CipherAlgorithms.RSA_ALGORITHM,CipherAlgorithms.BC_PROVIDER);
            keyPairGen.initialize(2048, new SecureRandom());  
            KeyPair keyPair = keyPairGen.generateKeyPair();  
            return keyPair;  
        } catch (Exception e) {
            logger.error("生成RSA秘钥对失败"+e.getMessage(),e);
            throw new BusinessException(SdkExceptionCode.RSA_GENERATOR_KEY_FAIL);
        }  
    }  

    
    public static void main(String[] args) throws UnsupportedEncodingException {
        KeyPair genKeyPair = genKeyPair();
        Key privateKey = genKeyPair.getPrivate();
        Key publicKey = genKeyPair.getPublic();
        System.out.println(privateKey.getEncoded().length);
        System.out.println(publicKey.getEncoded().length);
        String pubKeyStr = new String(Base64.encode(publicKey.getEncoded()));
        String priKeyStr = new String(Base64.encode(privateKey.getEncoded()));
        System.out.println(pubKeyStr);
        System.out.println(priKeyStr);
        
        RSA2048Cipher rsa2048Cipher = new RSA2048Cipher( pubKeyStr,priKeyStr);
        String encrypt2b64 = rsa2048Cipher.encrypt2B64("12345678997987987");
        System.out.println(encrypt2b64);
        
        RSA2048Cipher rsa2048Cipher1 = new RSA2048Cipher(pubKeyStr,priKeyStr);
        String decrypt2utf8 = rsa2048Cipher1.decrypt2UTF8(encrypt2b64, Decrypt.BASE64);
        System.out.println(decrypt2utf8);
    }
}
