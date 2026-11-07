package page;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final String codeField = "[data-test-id=code] input";
    private final String verifyButton = "[data-test-id=action-verify]";

    public DashboardPage validVerify(String code) {
        $(codeField).setValue(code);
        $(verifyButton).click();
        return new DashboardPage();
    }
}
