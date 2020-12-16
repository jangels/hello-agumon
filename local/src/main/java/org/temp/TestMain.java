package org.temp;

import com.google.common.collect.Maps;
import org.springframework.util.Base64Utils;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

public class TestMain {

    public static final String KEY_ALGORITHM = "RSA";

    public static void main(String[] args) throws NoSuchAlgorithmException {


        System.out.println(Integer.toBinaryString(100));

        java.security.KeyPairGenerator keygen = java.security.KeyPairGenerator
                .getInstance((KEY_ALGORITHM));
        SecureRandom secrand = new SecureRandom();
        secrand.setSeed("tmriPayment".getBytes()); // 初始化随机产生器
        keygen.initialize(1024);
        KeyPair keys = keygen.genKeyPair();
        RSAPublicKey pubkey = (RSAPublicKey) keys.getPublic();
        RSAPrivateKey prikey = (RSAPrivateKey) keys.getPrivate();
        Map keyMap = Maps.newHashMap();
        keyMap.put("RSAPublicKey", pubkey);
        keyMap.put("RSAPrivateKey", prikey);
        String pubKeyStr=  Base64Utils.encodeToString(pubkey.getEncoded());//得到公钥 并做base64编码
        String priKeyStr=  Base64Utils.encodeToString(prikey.getEncoded());//得到私钥 并做base64编码

        System.out.println("公钥:" + pubKeyStr);
        System.out.println("私钥:" + priKeyStr);
    }
}
