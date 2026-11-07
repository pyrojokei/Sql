package page;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final String loginField = "[data-test-id=login] input";
    private final String passwordField = "[data-test-id=password] input";
    private final String loginButton = "[data-test-id=action-login]";

    public VerificationPage validLogin(String login, String password) {
        $(loginField).setValue(login);
        $(passwordField).setValue(password);
        $(loginButton).click();
        return new VerificationPage();
    }
}

