package edu.estu.ovs.core.config.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HttpHelper {

    @SneakyThrows
    public static String getBodyString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        reader.lines().forEach(line -> sb.append(trimFieldValues(line)));
        inputStream.close();
        reader.close();
        return sb.toString();
    }

    @SneakyThrows
    private static String trimFieldValues(String line) {
        List<String> trimmed = new ArrayList<>();
        LinkedHashMap<?, ?> jsonMap = new ObjectMapper().readValue(line, LinkedHashMap.class);
        for (Map.Entry<?, ?> field : jsonMap.entrySet()) {
            String value = String.format(field.getValue() instanceof String ? "\"%s\"" : "%s", field.getValue().toString().trim());
            trimmed.add(String.format("\"%s\":%s", field.getKey(), value));
        }
        return String.format("{%s}", StringUtils.join(trimmed, ","));
    }



}