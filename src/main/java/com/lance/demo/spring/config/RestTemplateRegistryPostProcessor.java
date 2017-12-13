package com.lance.demo.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;


@Configuration
@Slf4j
public class RestTemplateRegistryPostProcessor implements BeanFactoryPostProcessor {
    public static final String TEMPLATE_SUFFIX = "RestTemplate";
    private HttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager();



    /**
     * 1.生成keyStore
     * 2.生成sslContext
     * 3.生成SSLConnectionSocketFactory
     * 4.生成connectionManager
     * 5.生成httpClient
     * 6.生成restTemplate
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        KeyPair[] keyPairs = new KeyPair[0];
        try {
            keyPairs = loadKeyPair();
            if (keyPairs.length == 0) {
                log.warn("not key loaded for https");
                return;
            }
        } catch (Exception e) {
            log.error("key load error:{}",e.getMessage());
            return;
        }


        for (KeyPair keyPair : keyPairs) {
            try {
                RestTemplate restTemplate = createRestTemplate(keyPair);
                String beanName = getRestTemplateBean(keyPair);
                configurableListableBeanFactory.registerSingleton(beanName,restTemplate);
            } catch (Exception e) {
                log.error("restTemplate generate fail,fail reason:{}",e.getMessage());
            }
        }
    }



    private KeyPair[] loadKeyPair() throws Exception{
        KeyPair keyPair = new KeyPair();
        keyPair.setBizType("withhold");
        keyPair.setConnectionTimeout(30000);
        keyPair.setSocketTimeout(50000);
        keyPair.setPublicKey(loadKeyStore("certificate/bfkey_100000276@@100000990.cer"));
        keyPair.setPrivateKey(loadKeyStore("certificate/bfkey_100000276@@100000990.pfx"));
        keyPair.setSecretKey("123456");
        return new KeyPair[]{keyPair};
    }

    private KeyStore loadKeyStore(String path) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(this.getClass().getClassLoader().getResourceAsStream("path"),"123456".toCharArray());
        return keyStore;
    }

    private RestTemplate createRestTemplate(KeyPair keyPair) throws Exception {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(keyPair.getConnectionTimeout());
        requestFactory.setReadTimeout(keyPair.getSocketTimeout());
        requestFactory.setHttpClient(createHttpClient(keyPair));
        return new RestTemplate(requestFactory);
    }

    private CloseableHttpClient createHttpClient(KeyPair keyPair) throws Exception{
//        KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        keyStore.load(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\jiaoyiping.p12")), "123456".toCharArray());
        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial(keyPair.getPublicKey(),
                        new TrustSelfSignedStrategy())
                .loadKeyMaterial(keyPair.getPrivateKey(),keyPair.getSecretKey().toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslContext,
                new String[] { "TLSv1" },
                null,
                SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        return HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(httpClientConnectionManager)
                .build();
    }

    private String getRestTemplateBean(KeyPair keyPair) {
        return keyPair + TEMPLATE_SUFFIX;
    }



}
