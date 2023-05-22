package ru.netology.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.impl.Html.text;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item div");
    private ElementsCollection cardsList = $$x("//ul[contains(@class,'list')]//div[@data-test-id]");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    

    public DashboardPage() {
        heading.shouldBe(visible);

    }

    public int getFirstCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
    


    public int getCardBalance(String id) {

        return extractBalance(text);
    }







    public void doReplenishment(DataHelper validUser1Card2, int transactionAmount) {
    }
}
