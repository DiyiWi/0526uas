package com.uas.cloud.mall.admin.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author chaokunyang
 * @create 2017-04-14 16:06
 */
public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String writeObjectToJson(Object obj) throws IOException {
        String result = mapper.writeValueAsString(obj);
        return result;
    }

}
