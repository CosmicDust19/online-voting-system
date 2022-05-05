package edu.estu.ovs.core.utilities;

import edu.estu.ovs.core.utilities.results.Result;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

public class Utils {

    public static final String LOCALHOST_3000 = "http://localhost:3000";

    public ResponseEntity<?> getResponseEntity(Result result) {
        if (result.isSuccess()) return ResponseEntity.ok(result);
        else return ResponseEntity.badRequest().body(result);
    }

    public Sort getSort(Short direction, String... props) {
        if (direction == null || direction < 0) return Sort.by(Sort.Direction.DESC, props);
        else return Sort.by(Sort.Direction.ASC, props);
    }

    public String getEditedPhoneNumber(String phone) {
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
