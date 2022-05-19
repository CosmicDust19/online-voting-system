package edu.estu.ovs;

import edu.estu.ovs.core.config.MySQLConfig;
import edu.estu.ovs.core.config.request.HttpServletRequestReplacedFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OvsServerApplication {

    public static void main(String[] args) {
        MySQLConfig.start();
        SpringApplication.run(OvsServerApplication.class, args);
    }

}
