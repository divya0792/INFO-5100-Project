package m4.Team1.database.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public final class SQLUtil {

    private SQLUtil() { }

    public static Connection getConnection(String url) {
        try {
            return DriverManager.getConnection(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String escape(String str) {
        return str.replaceAll("'", "''");
    }
}
