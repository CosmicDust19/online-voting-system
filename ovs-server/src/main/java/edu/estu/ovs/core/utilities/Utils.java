package edu.estu.ovs.core.utilities;

import edu.estu.ovs.core.utilities.results.Result;
import lombok.SneakyThrows;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.util.Properties;

public class Utils {

    public boolean notExistsById(CrudRepository<?, Integer> dao, Integer id) {
        return id == null || id <= 0 || !dao.existsById(id);
    }

    @SneakyThrows
    public static String getElementFromProperties(String fileName, String property) {
        Properties props = new Properties();
        InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) return null;
        props.load(inputStream); // load
        inputStream.close();
        return props.getProperty(property); // get by prop name
    }

    @SneakyThrows
    public static void changeElementFromProperties(String fileName, String property, String newValue) {
        String path = String.format("./ovs-server/src/main/resources/%s", fileName);
        InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) return;
        FileOutputStream outputStream = new FileOutputStream(path);
        Properties props = new Properties();
        props.load(inputStream); // load
        props.replace(property, newValue); // change
        props.store(outputStream, null); // save
        inputStream.close();
        outputStream.close();
    }

    @SneakyThrows
    public static boolean isProcessRunning(String processName) {
        Process taskList = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
        BufferedReader reader = taskList.inputReader();
        String processLine = reader.lines().filter(line -> line.startsWith(processName)).findFirst().orElse(null);
        reader.close();
        return processLine != null;
    }

    public static ResponseEntity<?> getResponseEntity(Result result) {
        if (result.isSuccess()) return ResponseEntity.ok(result);
        else return ResponseEntity.badRequest().body(result);
    }

    public static Sort getSort(Short direction, String... props) {
        if (direction == null || direction < 0) return Sort.by(Sort.Direction.DESC, props);
        else return Sort.by(Sort.Direction.ASC, props);
    }

    public static String getFormattedPhoneNumber(String phone) {
        if (phone == null) return null;
        String rawPhone = phone.replaceAll("[\\s-()]", "");
        StringBuilder body = new StringBuilder(rawPhone.substring(rawPhone.length() - 10));
        body.insert(8, " ");
        body.insert(6, " ");
        body.insert(3, " ");
        body.insert(0, " ");
        StringBuilder countryCode = new StringBuilder(rawPhone.substring(0, rawPhone.length() - 10));
        if (countryCode.length() > 0 && countryCode.charAt(0) != '+') countryCode.insert(0, "+");
        if (countryCode.length() == 2 && countryCode.charAt(0) == '+' && countryCode.charAt(1) == '0')
            countryCode.deleteCharAt(0);
        if (countryCode.length() == 0) countryCode.insert(0, "0");
        countryCode.append(body);
        return countryCode.toString();
    }

}
