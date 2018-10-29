package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.BaseEntity;
import framework.BrowserFactory;
import framework.Wait;

public class CucumberHooks  extends BaseEntity {

    @Before
    public void setUp(){
        driver = BrowserFactory.getDriver();
        new Wait(driver).implicitWait();
    }

    @After
    public void tearDown() {
        BrowserFactory.closeDriver();
    }

}