package components;

public enum PagesData {
    LOGIN("login"),
    REGISTRATION("register");

    private final String text;

    PagesData(String text) {
        this.text = text;
    }

    public String getPage() {
        return text;
    }

}
