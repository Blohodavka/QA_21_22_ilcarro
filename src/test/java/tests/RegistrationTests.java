package tests;

import models.User;
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
                .setEmail("Ivanova"+i+"@mail.ru")
                .setPassword("Mama123$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();

    }


}
