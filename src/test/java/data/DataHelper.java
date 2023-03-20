package data;

import com.github.javafaker.Faker;
import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo insertAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getInvalidAuthInfo() {
        Faker faker = new Faker();
        return new AuthInfo(faker.name().username(), faker.internet().password());
    }
    @Value
    public static class CodeInfo {
        private String Code;
    }

    public static CodeInfo getValidCode() {
        return new CodeInfo(DBInteraction.getVerificationCode());
    }

    public static CodeInfo getInvalidCode() {
        Faker faker = new Faker();
        String code = String.valueOf(faker.number().numberBetween(1000, 9999));
        return new CodeInfo(code);
    }
}

