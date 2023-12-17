package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("blohodavka@mail.ru", "Mama123$");
        app.getHelperUser().submitLogin();

//Assert
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        app.getHelperUser().clickOKButton();
    }
}
