package edu.estu.ovs;

import edu.estu.ovs.core.utilities.MySQLUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OvsServerApplication {

    public static void main(String[] args) {
        MySQLUtils.start();
        SpringApplication.run(OvsServerApplication.class, args);
    }

}
