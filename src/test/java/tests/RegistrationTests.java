package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
        }
    }

    @Test
    public void registrationSuccess(){

        Random random = new Random();
        int i = random.nextInt(1000);

        User user = new User().withFirstName("Lisa")
                .withLastName("Ivanova")
                .setEmail("ivanova"+i+"@mail.ru")
                .setPassword("Mama123$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");

    }

    @Test
    public void registrationWrongEmail(){

        User user = new User().setEmail("maniamail.ru").setPassword("Mama123$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submit();


    }

    @Test
    public void registrationWrongPassword(){

        Random random = new Random();
        int i = random.nextInt(1000);

        User user = new User().setEmail("mania"+i+"@mail.ru").setPassword("Mama12");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submit();




    }

    @Test
    public void registrationExistsUser() {

        User user = new User().setEmail("blohodavak@mail.ru").setPassword("Masha123$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submit();




    }


}
