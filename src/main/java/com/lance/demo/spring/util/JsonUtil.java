package com.lance.demo.spring.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> String getJson(T t) throws JsonProcessingException {
        return objectMapper.writeValueAsString(t);
    }
}
