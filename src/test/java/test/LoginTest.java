package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import data.DataHelper;
import database.DbUtilsHelper;

import java.sql.SQLException;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
    }

    @AfterEach
    void tearDown() throws SQLException {
        DbUtilsHelper.cleanDatabase();
    }

    @Test
    void shouldLoginWithCodeFromDb() throws SQLException {
        var loginPage = open("http://localhost:9999", LoginPage.class);

        String login = DataHelper.getValidLogin();
        String password = DataHelper.getValidPassword();

        var verificationPage = loginPage.validLogin(login, password);

        String code = DbUtilsHelper.getAuthCode(login);

        var dashboardPage = verificationPage.validVerify(code);

        dashboardPage.verifyDashboardPageVisibility();
    }
}
