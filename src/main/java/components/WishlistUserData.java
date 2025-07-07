package components;

public enum WishlistUserData {
    USER_CARD("admin"),
    USER_WISHLIST("Тестовый"),
    USER_GIFT("Наушники"),
    GIFT_RESERVED("Подарок зарезервирован");

    private final String text;

    WishlistUserData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
