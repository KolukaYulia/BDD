package ru.netology.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.CardData;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class DashboardPage {
    private ElementsCollection cards = $$(".list__item div");
    private ElementsCollection cardsList = $$x("//ul[contains(@class,'list')]//div[@data-test-id]");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    

    public DashboardPage() {

    }
    

    public SelenideElement findCardInList(CardData card) {
        String CardNumber = card.getCardNumber();
        for (SelenideElement element : cardsList) {
            if (element.text().contains(CardNumber)) {
                return element;
            }
        }
        return null;
    }

    public int getCardBalance(CardData card) {
        val text = findCardInList(card).text();
        return extractBalance(text);
    }


    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public int writeBalance(CardData card) {
        int balance = getCardBalance(card);
        card.setCardAmount(balance);
        return balance;
    }


    public void doReplenishment(CardData validUser1Card2, int transactionAmount) {
    }
}
