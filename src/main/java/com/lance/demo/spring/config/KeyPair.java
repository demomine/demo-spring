package com.lance.demo.spring.config;

import lombok.*;

import java.security.KeyStore;

@Getter
@Setter
@EqualsAndHashCode(of = {"payIdentify","merchantNo","bizType"})
@ToString(of = {"payIdentify","merchantNo","bizType"})
public class KeyPair {
    private String payIdentify;

    private String merchantNo;

    private String bizType;

    private KeyStore privateKey;

    private KeyStore publicKey;

    private String secretKey;

    private int connectionTimeout;

    private int socketTimeout;
}
