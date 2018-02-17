package com.lance.demo.spring.util;

import java.security.*;
import java.util.Enumeration;

public class SSLUtil {
    Key getSingleKey(KeyStore keyStore,String password) throws Exception{
        Enumeration<String> aliases = keyStore.aliases();
        if (aliases.hasMoreElements()) {
            return keyStore.getKey(aliases.nextElement(), password.toCharArray());
        }
        throw new Exception("no key alias found");
    }
}
