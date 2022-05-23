package edu.estu.ovs.core.utilities;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public class Msg {

    public static final String SUCCESS = "Successful";
    public static final String SAVED = "Saved";
    public static final String ERROR = "Error";
    public static final String VALIDATION_ERROR = "Validation Error";
    public static final String UNEXPECTED_ERROR = "Unexpected Error";

    public static final String DELETED = "Deleted";
    public static final String REMOVED = "Removed";
    public static final String INVALID = "Invalid";
    public static final String INVALID_LOGIN = "Invalid email or password.";
    public static final String UK_ELECTION_ATTENDERS = "One candidate can only attend an election for once";
    public static final String START_END_CONFLICT = "The end year cannot be a date before the start year";
    public static final String MALFORMED_JSON_REQUEST = "Malformed JSON request";
    public static final String JWT_EXPIRED = "Your session has expired, Please login again.";

    // subject required
    public static final String REQUIRED = "%s required";
    public static final String SIZE = "%s size must be between {min} and {max}";
    public static final String FUTURE = "%s should be in the future";
    public static final String PAST = "%s should be in the past";
    public static final String PATTERN = "%s is not in correct format";
    public static final String IS_IN_USE = "%s is in use";
    public static final String NOT_EXIST = "%s does not exist";

    public static String getViolationMsg(String camelCaseProp, String rawMsg) {
        return String.format(rawMsg, camelCaseToHuman(camelCaseProp));
    }

    public static String camelCaseToHuman(String camelCase) {
        String[] sliced = StringUtils.splitByCharacterTypeCamelCase(camelCase);
        String subPropName = StringUtils.join(sliced, " ").toLowerCase(Locale.ENGLISH);
        return String.format("%s%s", Character.toUpperCase(subPropName.charAt(0)), subPropName.substring(1));
    }

}
