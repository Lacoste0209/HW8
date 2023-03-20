package test;

import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPage;
import page.VerificationPage;

public class LoginUserTest extends SetUp {

    @Test
    void validLoginTest() {
        var validUser = DataHelper.insertAuthInfo();
        var validCode = DataHelper.getValidCode();
        VerificationPage verificationPage = new VerificationPage();
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        loginPage.loginUser(validUser);
        verificationPage.enterCode(validCode);
        dashboardPage.dashboardLogo();
    }

    @Test
    void invalidLoginTest() {
        var invalidUser = DataHelper.getInvalidAuthInfo();
        LoginPage loginPage = new LoginPage();
        loginPage.loginUser(invalidUser);
        loginPage.errorUser();
    }

    @Test
    void invalidEnterCodeTest() {
        var validUser = DataHelper.insertAuthInfo();
        var invalidCode = DataHelper.getInvalidCode();
        LoginPage loginPage = new LoginPage();
        VerificationPage verificationPage = new VerificationPage();
        loginPage.loginUser(validUser);
        verificationPage.enterCode(invalidCode);
        verificationPage.errorCode();
    }

    @Test
    void invalidLoginLockingTest() {
        var invalidUser = DataHelper.getInvalidAuthInfo();
        LoginPage loginPage = new LoginPage();
        for (int i = 0; i < 3; i++) {
            loginPage.loginUser(invalidUser);
        }
        loginPage.blockedUser();
    }
}
