package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;

public class DBInteraction {
    private DBInteraction() {
    }

    @SneakyThrows
    public static String getVerificationCode() {
        var runner = new QueryRunner();
        var dataSQL = "SELECT code FROM auth_codes ORDER BY created DESC LIMIT 1";

        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");)
        {
            var code = runner.query(conn, dataSQL, new ScalarHandler<String>());
            return code;
        }
    }

    @SneakyThrows
    public static void deleteUsers() {
        var runner = new QueryRunner();
        var deleteCodes = "DELETE FROM auth_codes";
        var deleteTransactions = "DELETE FROM card_transactions";
        var deleteCards = "DELETE FROM cards";
        var deleteUsers = "DELETE FROM users";

        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass"))
        {
            runner.update(conn, deleteCodes);
            runner.update(conn, deleteTransactions);
            runner.update(conn, deleteCards);
            runner.update(conn, deleteUsers);
        }
    }
}
