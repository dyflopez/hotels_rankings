package com.ms.user.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class JsonUtil {

    private static final ObjectMapper  objectMapper = new ObjectMapper();

    private JsonUtil() {
    }

    public static String  convertJson (@NotNull final Object data){
        try{
            return  objectMapper.writeValueAsString(data);
        }catch (JsonProcessingException e){
            log.error(e.getMessage(),e);
        }
        return  null;
    }
}
