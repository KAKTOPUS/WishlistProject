package components;

public enum LoginData {
    ERROR_LOGIN("Неверное имя пользователя или пароль");

    private final String text;

    LoginData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
