package com.lance.demo.spring.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by immerer on 2017/6/24.
 */
@Service
@Slf4j
public class ResourceDemo {
    @Autowired
    private ApplicationContext applicationContext;

    public String resourceDemo1() throws IOException {
        String fileLocation = "Test.txt";
        Resource resource = applicationContext.getResource(fileLocation);
        if (!resource.exists()) {
            throw new FileNotFoundException(fileLocation + "  not found");
        }
        log.info("======file name : {} ",resource.getFilename());
        log.info("======file url : {} ",resource.getURL());
        log.info("======file uri : {} ",resource.getURI());
        return inputStreamToString(resource.getInputStream());
    }

    public String resourceDemo2() throws IOException {
        String fileLocation = "/Test.txt";
        Resource resource = applicationContext.getResource(fileLocation);
        if (!resource.exists()) {
            throw new FileNotFoundException(fileLocation + "  not found");
        }
        log.info("======file name : {} ",resource.getFilename());
        log.info("======file url : {} ",resource.getURL());
        log.info("======file uri : {} ",resource.getURI());
        return inputStreamToString(resource.getInputStream());
    }


    public String resourceDemo3() throws IOException {
        String fileLocation = "classpath:Test.txt";
        Resource resource = applicationContext.getResource(fileLocation);
        if (!resource.exists()) {
            throw new FileNotFoundException(fileLocation + "  not found");
        }
        log.info("======file name : {} ",resource.getFilename());
        log.info("======file url : {} ",resource.getURL());
        log.info("======file uri : {} ",resource.getURI());
        return inputStreamToString(resource.getInputStream());
    }

    public String resourceDemo4() throws IOException {
        String fileLocation = "classpath*:Test.txt";//不支持
        Resource resource = applicationContext.getResource(fileLocation);
        if (!resource.exists()) {
            throw new FileNotFoundException(fileLocation + "  not found");
        }
        log.info("======file name : {} ",resource.getFilename());
        log.info("======file url : {} ",resource.getURL());
        log.info("======file uri : {} ",resource.getURI());
        return inputStreamToString(resource.getInputStream());
    }

    public String resourceDemo5() throws IOException {

//        String projectPath = System.getProperty("user.dir");//错误
        String projectPath = applicationContext.getResource("/").getURL().getPath();//错误
        String fileLocation = projectPath + "Test.txt";//不支持
        Resource resource = applicationContext.getResource(fileLocation);
        if (!resource.exists()) {
            throw new FileNotFoundException(fileLocation + "  not found");
        }
        log.info("======file name : {} ",resource.getFilename());
        log.info("======file url : {} ",resource.getURL());
        log.info("======file uri : {} ",resource.getURI());
        return inputStreamToString(resource.getInputStream());
    }

    public String resourceDemo6() throws IOException {
        String url = "http://www.baidu.com";
        Resource resource = applicationContext.getResource(url);
        if (!resource.exists()) {
            throw new FileNotFoundException(url + "  not found");
        }
        log.info("======file name : {} ",resource.getFilename());
        log.info("======file url : {} ",resource.getURL());
        log.info("======file uri : {} ",resource.getURI());
        return inputStreamToString(resource.getInputStream());
    }

    public String resourceDemo7() throws IOException {
        String url = "ftp://user:pwd@localhost:21/apps/aa.csv";
        Resource resource = applicationContext.getResource(url);
       /* if (!resource.exists()) {
            throw new FileNotFoundException(url + "  not found");
        }*/
        log.info("======file name : {} ",resource.getFilename());
        log.info("======file url : {} ",resource.getURL());
        log.info("======file uri : {} ",resource.getURI());
        return inputStreamToString(resource.getInputStream());
    }


    private String inputStreamToString(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (inputStream.available()>0) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            sb.append(new String(bytes));
        }
        return sb.toString();
    }
}
