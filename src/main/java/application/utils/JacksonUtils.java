package application.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by mj on 10/6/16.
 */
@Component
public class JacksonUtils<T> {
    private static Logger logger = LoggerFactory.getLogger(JacksonUtils.class);

    public T getObjectFromJson(String json, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        T classObject = null;
        try {
            classObject = mapper.readValue(json, new TypeReference<T>() {
            });
        } catch (IOException e) {
            logger.debug("COuld not parse json : " + json + "to list");
        }
        return classObject;
    }

    public static String toJson(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        if (o == null) {
            return null;
        }
        try {
            return mapper.writeValueAsString(o);
        } catch (Exception e) {
            logger.error(JacksonUtils.class.getSimpleName(), e);
            throw new RuntimeException(e);
        }
    }
}
