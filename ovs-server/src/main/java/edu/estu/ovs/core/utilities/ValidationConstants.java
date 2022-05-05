package edu.estu.ovs.core.utilities;

public class ValidationConstants {

    public static class RegExp {
        public static final String NAT_ID = "\\d{11}";
        public static final String EMAIL = "^\\w+(\\.\\w+)*@\\p{javaLowerCase}{2,12}+(\\.\\p{javaLowerCase}{2,6})+$";
        public static final String WEBSITE = "^(w{3}\\.)?[^.]+(\\.\\p{javaLowerCase}{2,12})+$";
        public static final String PHONE_NUM = "^((\\+?\\d{1,3})?0?[\\s-]?)?\\(?0?\\d{3}\\)?[\\s-]?\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}$";
        public static final String DATE = "^\\d{4}-\\d{2}-\\d{2}$";
    }

    public static class MinLength {
        public static final int F_NAME = 2;
        public static final int M_NAME = 2;
        public static final int L_NAME = 2;
        public static final int PASSWORD = 6;
    }

    public static class MaxLength {
        public static final int F_NAME = 30;
        public static final int M_NAME = 30;
        public static final int L_NAME = 30;
        public static final int PASSWORD = 25;
    }

}
