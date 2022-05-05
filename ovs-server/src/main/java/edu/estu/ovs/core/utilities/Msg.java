package edu.estu.ovs.core.utilities;

public class Msg {

    public static final String REQUIRED = "required";
    public static final String SIZE = "size must be between {min} and {max}";
    public static final String MIN = "must be greater than {value}";
    public static final String MAX = "must be less than {value}";
    public static final String POSITIVE = "should be positive";
    public static final String FUTURE = "should be in the future";
    public static final String PATTERN = "is not in correct format";

    //simple
    public static final String SUCCESS = "Successful";
    public static final String FAILED = "Failed";
    public static final String SAVED = "Saved";
    public static final String UPDATED = "Updated";
    public static final String DELETED = "Deleted";
    public static final String DELETE_ERROR = "An error has occurred during deletion";
    public static final String RESULT_SUM = "Result summary";
    public static final String LOGGED_IN = "Logged in";

    //customizable
    public static final String INVALID = "invalid";
    public static final String INVALID_DATE = "invalid date format (should be yyyy-mm-dd)";
    public static final String USED = "used before";
    public static final String IS_IN_USE = "is in use";
    public static final String NOT_EXIST = "does not exist";
    public static final String NOT_FOUND = "not found";
    public static final String IS_THE_SAME = "is the same as before";
    public static final String THE_SAME = "the same as before";

    //explanation
    public static final String WRONG = "Wrong";
    public static final String EMPTY = "Empty";
    public static final String UK_ELECTION_ATTENDERS = "One candidate can only attend an election for once";
    public static final String START_END_CONFLICT = "The end year cannot be a date before the start year";
    public static final String MIN_MAX_CONFLICT = "Minimum value cannot be greater than maximum value";
    public static final String MALFORMED_JSON_REQUEST = "Malformed JSON request";
    public static final String LOGIN_FAIL = "Please check your email and password";

}
