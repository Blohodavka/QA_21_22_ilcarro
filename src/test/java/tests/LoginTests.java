package tests;

import jdk.internal.instrumentation.Logger;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
        }
    }

    @Test
    public void loginSuccess1() {

        User user = new User().setEmail("blohodavka@mail.ru").setPassword("Mama123$");
        logger.info("Test start with test data --->" + " email : 'blohodavka@mail.ru' & password : 'Mama123$'");
//        user.setEmail("blohodavka@mail.ru");
//        user.setPassword("Mama123$");


        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();


        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");


    }
    @Test
    public void loginSuccess() {

        logger.info("Test start with test data --->" + " email : 'blohodavka@mail.ru' & password : 'Mama123$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("blohodavka@mail.ru", "Mama123$");
        app.getHelperUser().submit();

//Assert
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        //app.getHelperUser().clickOKButton();
        // Assert.assertTrue(app.getHelperUser().isLogged());

    }

    @Test
    public void loginSuccessModel() {
        logger.info("Test start with test data --->" + " email : 'blohodavka@mail.ru' & password : 'Mama123$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("blohodavka@mail.ru", "Mama123$");
        app.getHelperUser().submit();

//Assert
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

        //  app.getHelperUser().clickOKButton();
    }

    @Test
    public void loginWrongEmail() {

        logger.info("Test start with test data --->" + " email : 'blohodavkamail.ru' & password : 'Mama123$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("blohodavkamail.ru", "Mama123$");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");

        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());


    }

    @Test
    public void loginEmptyEmail() {
        logger.info("Test start with test data --->" + " email : ' ' & password : 'Mama123$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(" ", "Mama123$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void loginWrongPassword() {
        logger.info("Test start with test data --->" + " email : 'blohodavka@mail.ru' & password : 'Manjja123$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("blohodavka@mail.ru", "Mama1");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");


    }

    //    @Test
//    public void loginEmptyPassword() {
//        app.getHelperUser().openLoginForm();
//        app.getHelperUser().fillLoginForm("blohodavka@mail.ru", "");
//        app.getHelperUser().submit();
//        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password is required");
//        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
//    }

    @Test
    public void loginUnregistereUser() {
        logger.info("Test start with test data --->" + " email: 'luck@gmail.com' & password: 'Lluck123456$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("luck@mail.ru", "Luck123$");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");


    }

    @AfterMethod
    public void postConditions() {

        app.getHelperUser().clickOKButton();
    }
}

