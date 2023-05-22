package ru.netology.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.CardData;
import ru.netology.pages.DashboardPage;
import ru.netology.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;



    class PagesTest {
        private UserData validUser1 = new UserData("vasya", "qwerty123");
        private CardData validUser1Card1 = new CardData(validUser1, "5559 0000 0000 0001");
        private CardData validUser1Card2 = new CardData(validUser1, "5559 0000 0000 0002");

        private final static String VERIFICATION_CODE_TEST = "12345";
        DashboardPage dashboardPage;
        int startBalanceOfCard1;
        int startBalanceOfCard2;

        @BeforeEach
        void setup() {
            open("http://localhost:9999");
            new LoginPage()
                    .login(validUser1)
                    .acceptCode(VERIFICATION_CODE_TEST);
            dashboardPage = new DashboardPage();


            startBalanceOfCard1 = dashboardPage.writeBalance(validUser1Card1);
            startBalanceOfCard2 = dashboardPage.writeBalance(validUser1Card2);

        }

        @Test




