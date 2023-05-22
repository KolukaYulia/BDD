package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;

import static ru.netology.data.DataHelper.CardInfo;

import static com.codeborne.selenide.Selenide.$;

public class СardTransferPage {
    private final SelenideElement amountInput = $("[data-test-id='amount'] input");
    private final SelenideElement fromCardNumberInput = $("[data-test-id='from'] input");
    private final SelenideElement button = $("[data-test-id='action-transfer']");
    private SelenideElement transferHead = $(byText("Пополнение карты"));

    public void CardTransferPage() {
        transferHead.shouldBe(visible);
    }

    public DashboardPage doTransfer(String amountToTransfer, CardInfo cardinfo) {
        amountInput.setValue(amountToTransfer);
        fromCardNumberInput.setValue(cardinfo.getCardNumber());
        button.click();
        return new DashboardPage();

    }

}
