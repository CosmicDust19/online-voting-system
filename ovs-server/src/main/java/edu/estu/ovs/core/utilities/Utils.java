package edu.estu.ovs.core.utilities;

import edu.estu.ovs.core.response.results.abstracts.ApiResult;
import lombok.SneakyThrows;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.io.*;

public class Utils {

    public static ResponseEntity<ApiResult> buildResponseEntity(ApiResult apiResult) {
        return ResponseEntity.status(apiResult.getStatus()).body(apiResult);
    }

    @SneakyThrows
    public static boolean isProcessRunning(String processName) {
        Process taskList = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
        BufferedReader reader = taskList.inputReader();
        String processLine = reader.lines().filter(line -> line.startsWith(processName)).findFirst().orElse(null);
        reader.close();
        return processLine != null;
    }

    public static Sort getSort(Short direction, String... props) {
        if (direction == null || direction < 0) return Sort.by(Sort.Direction.DESC, props);
        else return Sort.by(Sort.Direction.ASC, props);
    }

    public static String getFormattedPhoneNumber(String phone) {
        if (phone == null) return null;
        if (!phone.matches(Constants.RegExp.PHONE_NUM)) return phone;
        phone = phone.replaceAll("[\\s-()]", "");
        StringBuilder body = new StringBuilder(phone.substring(phone.length() - 10));
        StringBuilder countryCode = new StringBuilder(phone.substring(0, phone.length() - 10));
        body.insert(8, "-");
        body.insert(6, "-");
        body.insert(3, "-");
        body.insert(0, "-");
        if (countryCode.length() > 0 && countryCode.charAt(0) != '+') countryCode.insert(0, "+");
        if (countryCode.length() == 2 && countryCode.charAt(0) == '+' && countryCode.charAt(1) == '0')
            countryCode.deleteCharAt(0);
        if (countryCode.length() == 0) countryCode.insert(0, "0");
        countryCode.append(body);
        return countryCode.toString();
    }

}
