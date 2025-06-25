package dto;

import com.github.javafaker.Faker;

public class TestDataGenerator {

    private Faker faker = new Faker();
    private String name = faker.name().fullName();
    private String email = faker.internet().emailAddress();
    private int price = faker.number().numberBetween(1, 1000);
    private String password = faker.internet().password(8, 16, true, true, true);

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getPrice() {
        return price;
    }

}
