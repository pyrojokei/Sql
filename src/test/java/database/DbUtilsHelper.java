package database;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtilsHelper {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/app";
    private static final String DB_USER = "app";
    private static final String DB_PASS = "pass";

    public static String getAuthCode(String login) throws SQLException {
        String sql = "SELECT code FROM auth_codes JOIN users ON auth_codes.user_id = users.id WHERE users.login = ? ORDER BY created DESC LIMIT 1;";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            QueryRunner runner = new QueryRunner();
            return runner.query(conn, sql, new ScalarHandler<>(), login);
        }
    }

    public static void cleanDatabase() throws SQLException {
        var runner = new QueryRunner();

        String deleteAuthCodes = "DELETE FROM auth_codes;";
        String deleteTransactions = "DELETE FROM card_transactions;";
        String deleteCards = "DELETE FROM cards;";
        String deleteUsers = "DELETE FROM users;"; //users удаляется строго последней!

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            runner.update(conn, deleteAuthCodes);
            runner.update(conn, deleteTransactions);
            runner.update(conn, deleteCards);
            runner.update(conn, deleteUsers);
        }
    }
}
