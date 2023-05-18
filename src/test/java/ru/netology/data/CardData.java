package ru.netology.data;

public class CardData {
    private UserData user;
    private String cardNumber;
    private int cardAmount;

    public CardData(UserData user, String cardNumber) {
        this.user = user;
        this.cardNumber = cardNumber;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(int cardAmount) {
        this.cardAmount = cardAmount;
    }
}
