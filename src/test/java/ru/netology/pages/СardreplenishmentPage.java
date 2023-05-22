package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class СardreplenishmentPage {
    private final SelenideElement amountInput = $("span[data-test-id='amount'] input");
    private final SelenideElement fromCardNumberInput = $("span[data-test-id='from'] input");
    private final SelenideElement button = $("button[data-test-id='action-transfer']");
    private final SelenideElement escapeButton = $("button[data-test-id='action-cancel']");
    private final SelenideElement errorNotification = $("div[class='notification__content']");

    private void inputCardInfoAndAmount(DataHelper card, int amount) {
        amountInput.sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.BACK_SPACE);
        amountInput.setValue(String.valueOf(amount));
        fromCardNumberInput.sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.BACK_SPACE);
        fromCardNumberInput.setValue(card.toString());
        button.click();
    }
    public DashboardPage doReplenishment(DataHelper card, int amount) {
        inputCardInfoAndAmount(card, amount);

        return new DashboardPage();
    }

}
