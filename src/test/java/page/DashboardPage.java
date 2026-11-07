package page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private final String dashboard = "[data-test-id=dashboard]";

    public void verifyDashboardPageVisibility() {
        $(dashboard).shouldBe(visible);
    }
}
