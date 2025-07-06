package components;

public enum TitleNameData {
    LOGIN("Вход в систему"),
    REGISTRATION("Регистрация"),
    WISHLISTS("Мои списки желаний"),
    USERS("Пользователи");

    private final String text;

    TitleNameData(String text) {
        this.text = text;
    }

    public String getTitleText() {
        return text;
    }

}
