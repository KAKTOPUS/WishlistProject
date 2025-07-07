package components;

public enum RegistrationData {
    ERROR_REGISTRATION("Не удалось зарегистрировать пользователя");

    private final String text;

    RegistrationData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
