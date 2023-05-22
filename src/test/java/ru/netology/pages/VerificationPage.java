package ru.netology.pages;


import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement codeInput = $("span[data-test-id='code'] input");
    private final SelenideElement okButton = $("button[data-test-id='action-verify']");

    public DashboardPage validVerify(DataHelper.VerificationCode verificationCode) {
        codeInput.setValue(verificationCode.getCode());
        okButton.click();

        return new DashboardPage();
    }

    public VerificationPage() {
        codeInput.shouldBe(visible);
    }

}
