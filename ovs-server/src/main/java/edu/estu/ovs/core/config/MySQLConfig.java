package edu.estu.ovs.core.config;

import edu.estu.ovs.core.utilities.PropertiesUtils;
import edu.estu.ovs.core.utilities.Utils;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class MySQLConfig {

    @Getter
    private static DataSource dataSource;

    @Getter
    private static String mysqlHome;

    @Getter
    private static boolean running;

    static {
        String defMysqlHome = PropertiesUtils.getElement("application.properties", "mysql.home-path");
        mysqlHome = defMysqlHome != null && Files.exists(Paths.get(defMysqlHome)) ? defMysqlHome : null;
        running = Utils.isProcessRunning("mysqld.exe");
    }

    // for windows
    // linux: /etc/init.d/mysqld start
    // mac: sudo launchctl load -F /Library/LaunchDaemons/com.oracle.oss.mysql.mysqld.plist
    @SneakyThrows(IOException.class)
    public static void start() {
        if (running || mysqlHome == null || !System.getProperty("os.name").toLowerCase().contains("win")) return;
        running = new ProcessBuilder(String.format("%s\\bin\\mysqld.exe", mysqlHome)).start().isAlive();
        System.out.println("MySQL Server Has Started.");
    }

    // for windows
    // @PreDestroy // (uncomment if you want to stop mysql after program finishes)
    @SneakyThrows(IOException.class)
    public static void stop() {
        running = !new ProcessBuilder(String.format("%s\\bin\\mysqladmin.exe", mysqlHome), "−u", "root", "shutdown").start().isAlive();
    }

    // refreshes mysql path (it requires to mysql running)
    @PreDestroy
    @SneakyThrows(SQLException.class)
    public static void setMySQLHomePath() {
        if (!running) return;
        ResultSet res = dataSource.getConnection().createStatement().executeQuery("select @@datadir");
        if (!res.next()) return;
        mysqlHome = res.getString(1).substring(0, res.getString(1).lastIndexOf("mysql") + 6);
        String oldPath = PropertiesUtils.updateElement("application.properties", "mysql.home-path", mysqlHome);
        if (!mysqlHome.equals(oldPath)) System.out.println("MySQL Home Path Has Changed.");
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        MySQLConfig.dataSource = dataSource;
    }

    /*String username = Utils.getElementFromProperties("application.properties", "spring.datasource.username");
        String password = Utils.getElementFromProperties("application.properties", "spring.datasource.password");
        ResultSet res = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", username, password)
                .createStatement().executeQuery("select @@datadir");*/
}
