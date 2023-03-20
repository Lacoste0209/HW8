package page;

import com.codeborne.selenide.*;
import data.DataHelper;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement loginInput = $x("//input[@name='login']");
    private SelenideElement passwordInput = $x("//input[@name='password']");
    private SelenideElement signInButton = $x("//button[@data-test-id='action-login']");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");
    private SelenideElement blockedNotification = $("[data-test-id=blocked-notification]");
    private String clearInput = Keys.chord(Keys.CONTROL + "A", Keys.BACK_SPACE);

    public void loginUser(DataHelper.AuthInfo info) {
        loginInput.sendKeys(clearInput);
        loginInput.setValue(info.getLogin());
        passwordInput.sendKeys(clearInput);
        passwordInput.setValue(info.getPassword());
        signInButton.click();
    }

    public void errorUser() {
        errorNotification.shouldBe(Condition.appear);
    }


    public void blockedUser() {
        blockedNotification.shouldBe(Condition.appear);
    }
}
