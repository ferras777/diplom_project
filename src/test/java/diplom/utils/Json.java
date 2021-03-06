package diplom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Json {
    private static final Logger LOG = LoggerFactory.getLogger(Json.class);

    public static String convertMapToJson(Map<String, Object> map) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            LOG.error("Не удалось преобразовать map в Json", e);
        }
        return json;
    }

    public static String convertPOJOToJSON(Object pojo) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(pojo);
    }
}
