package test;

import data.DBInteraction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class SetUp {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999/");
    }

    @AfterAll
    static void clearUser() {
        DBInteraction.deleteUsers();
    }
}
