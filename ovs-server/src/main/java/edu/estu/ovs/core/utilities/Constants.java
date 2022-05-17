package edu.estu.ovs.core.utilities;

public class Constants {

    public static class Origin {
        public static final String LOCALHOST_3000 = "http://localhost:3000";
    }

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
        public static final int PW = 6;
        public static final int ADDR = 20;
        public static final int ELECTION_TITLE = 2;
        public static final int CERT_NAME = 2;
        public static final int CERT_DESC = 2;
        public static final int SCH_NAME = 2;
    }

    public static class MaxLength {
        public static final int F_NAME = 30;
        public static final int M_NAME = 30;
        public static final int L_NAME = 30;
        public static final int PW = 25;
        public static final int CODED_PW =  100;
        public static final int CANDIDATE_INTRO = 1000;
        public static final int ADDR = 400;
        public static final int NAT_ID = 11;
        public static final int CERT_NAME = 40;
        public static final int CERT_DESC = 400;
        public static final int SCH_NAME = 30;
        public static final int SCH_DEG = 30;
        public static final int PHONE_NUM = 17;
        public static final int EMAIL = 100;
        public static final int ELECTION_TITLE = 100;
    }

}
