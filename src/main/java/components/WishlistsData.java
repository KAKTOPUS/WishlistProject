package components;

public enum WishlistsData {
    WISHLIST_NAME("Птицы"),
    ERROR_TEXT("Ошибка: Не удалось добавить подарок");

    private final String text;

    WishlistsData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
