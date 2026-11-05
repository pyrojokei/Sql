import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    private LoginPage loginPage = new LoginPage();

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
    }

    @Test
    void shouldLoginWithCodeFromDb() throws SQLException {
        String login = DataHelper.getValidLogin();
        String password = DataHelper.getValidPassword();

        loginPage.fillLoginForm(login, password);

        String code = DbUtilsHelper.getAuthCode(login);
        System.out.println("Код из базы: " + code);

        loginPage.fillCode(code);

        loginPage.checkDashboardIsVisible();
    }
}