package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text){

        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
       clearNew(element);
        if(text != null){
            element.sendKeys(text);
        }
    }

    public void clearNew(WebElement element){
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);

    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));
    }
    public void click(By locator){
        WebElement element = wd.findElement(locator);
        element.click();
    }

    public boolean isElementPresent(By locator){
        // return wd.findElements(locator).size()>0;
        List<WebElement> list = wd.findElements(locator);
        return list.size()>0;
    }
    public String getMessage() {
       // pause(4000);
return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isYallaButtonNotActive() {
       boolean res =  isElementPresent(By.cssSelector("button[disabled]"));

       WebElement element = wd.findElement(By.cssSelector("button[type='submit']"));
       boolean result = element.isEnabled();
        return res && !result;
    }
}
