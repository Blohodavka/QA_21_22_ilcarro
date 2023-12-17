package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {super(wd);}

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }
//    public void openLoginForm() {
//
//        click(By.cssSelector("a[href='/login?url=%2Fsearch']"));
//
//    }

    public void fillLoginForm(String email, String password){

        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void submitLogin(){
        click(By.xpath("//button[@type='submit']"));
    }


    public void clickOKButton() {
        click(By.xpath("//button[text()='Ok']"));
    }
}
