package edu.estu.ovs.core.utilities;

import edu.estu.ovs.core.config.MySQLConfig;
import lombok.SneakyThrows;

import java.sql.SQLException;

public class ValidationUtils {

    @SneakyThrows(SQLException.class)
    public static boolean existsByField(String table, String column, String value) {
        if (table == null || column == null || value == null) return false;
        String query = String.format("SELECT t.%s FROM %s t WHERE t.%s = '%s' LIMIT 1", column, table, column, value);
        return MySQLConfig.getConnection().createStatement().executeQuery(query).next();
    }

}
