/*
 * 文件名：RSAKeys.java
 * 版权： Copyright 2014-2017 .
 * 描述：〈描述〉
 * 修改人：137127
 * 修改时间：2017年5月27日
 * 修改单号：2017年5月27日
 * 修改内容：〈修改内容〉
 */
package org.smallfire.java.cipher;

import java.io.Serializable;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * RSA 的秘钥对
 * 
 * @author 137127
 * @version [1.0.0, 2017年5月27日]
 */
public class RSAKeys implements Serializable {

    /**
     * serialVersionUID:TODO
     */
    private static final long serialVersionUID = 1L;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public Key getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public Key getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

}
