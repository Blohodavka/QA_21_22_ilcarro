package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{

    @Test
    public void searchCyrrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel", "8/10/2024", "8/22/2024");
        app.getHelperCar().submit();

       Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());


    }
}
