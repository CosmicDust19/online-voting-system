package edu.estu.ovs.core.config.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.estu.ovs.core.utilities.Constants;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class HttpHelper {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static String getBodyString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        reader.lines().forEach(line -> sb.append(trim(line)));
        System.out.println(sb);
        inputStream.close();
        reader.close();
        return sb.toString();
    }

    @SneakyThrows
    private static String trim(Object object) {
        String json = object instanceof String ? object.toString() : objectMapper.writeValueAsString(object);
        if (json.matches(Constants.RegExp.JSON_OBJECT))
            return handleJsonObjectTrim(json);
        if (object instanceof String)
            return String.format("\"%s\"", json.trim());
        return object.toString();
    }

    @SneakyThrows
    private static String handleJsonObjectTrim(String line) {
        LinkedHashMap<?, ?> jsonMap = objectMapper.readValue(line, LinkedHashMap.class);
        return jsonMap.entrySet().stream()
                .map(e -> String.format("\"%s\":%s", e.getKey(), trim(e.getValue())))
                .collect(Collectors.joining(",", "{", "}"));
    }

}