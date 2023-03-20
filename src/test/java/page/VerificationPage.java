package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {

    private static SelenideElement codeInput = $("[name=code]");
    private static SelenideElement continueButton = $("[data-test-id=action-verify]");
    private static SelenideElement verifiedBy = $x("//h2");
    private static SelenideElement errorNotification = $("[data-test-id=error-notification]");
    private String clearInput = Keys.chord(Keys.CONTROL + "A", Keys.BACK_SPACE);


    public void enterCode(DataHelper.CodeInfo info) {
        codeInput.sendKeys(clearInput);
        codeInput.setValue(info.getCode());
        continueButton.click();
    }

    public void errorCode() {
        errorNotification.shouldBe(Condition.appear);
    }
}
