import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final String loginField = "[data-test-id=login] input";
    private final String passwordField = "[data-test-id=password] input";
    private final String codeField = "[data-test-id=code] input";

    private final String loginButton = "[data-test-id=action-login]";
    private final String verifyButton = "[data-test-id=action-verify]";

    private final String dashboard = "[data-test-id=dashboard]";

    public void fillLoginForm(String login, String password) {
        $(loginField).setValue(login);
        $(passwordField).setValue(password);
        $(loginButton).click();
    }

    public void fillCode(String code) {
        $(codeField).setValue(code);
        $(verifyButton).click();
    }

    public void checkDashboardIsVisible() {
        $(dashboard).shouldBe(visible);
    }
}