package CucumberNopComerce;


import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Utils {
    @Before
    public void setUpBrowser(){
        set_chrome_driver();
    }

    @After
    public void tearBrowser(){
        driver.close();
    }
}
