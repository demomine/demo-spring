package com.lance.demo.spring.util;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;

/**
 * Created by perdonare on 2016/11/2.
 */
public class EncryptUtil {
    public final static String RSA_CHIPER = "RSA/ECB/PKCS1Padding";
    public static String base64Encode(String str) throws UnsupportedEncodingException {
        return new BASE64Encoder().encode(str.getBytes("UTF-8"));
    }

    public static String encryptBASE64(byte[] data) {
        return new String(Base64.encodeBase64(data));
    }

    public static String base64Decode(String str) throws IOException {
        return new String(new BASE64Decoder().decodeBuffer(str), "UTF-8");
    }

    public static PublicKey loadPublicKey(String path) throws Exception{
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        Certificate c = cf.generateCertificate(EncryptUtil.class.getClassLoader().getResourceAsStream(path));
        return c.getPublicKey();
    }

    public static PrivateKey loadPrivateKey(String path,String password) throws Exception{
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(EncryptUtil.class.getClassLoader().getResourceAsStream(path),password.toCharArray());
        Enumeration<String> aliases = keyStore.aliases();
        if (aliases.hasMoreElements()) {
            return (PrivateKey)keyStore.getKey(aliases.nextElement(), password.toCharArray());
        }
        throw new Exception("no key alias found");
    }

    public static String encrypt(String text, PublicKey publicKey) throws Exception {
        final Cipher cipher = Cipher.getInstance(RSA_CHIPER);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] data = cipher.doFinal(text.getBytes());
        if (data == null) {
            throw new Exception("");
        }
        return byte2Hex(data);
    }

    private static String byte2Hex(byte[] srcBytes) {
        StringBuilder hexRetSB = new StringBuilder();
        for (byte b : srcBytes) {
            String hexString = Integer.toHexString(0x00ff & b);
            hexRetSB.append(hexString.length() == 1 ? 0 : "").append(hexString);
        }
        return hexRetSB.toString();
    }
}
