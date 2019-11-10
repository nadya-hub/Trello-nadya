import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenAppTest {
    AppiumDriver driver;
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName", "Nexus");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage", "com.trello");
        capabilities.setCapability("appActivity", ".home.HomeActivity");
        capabilities.setCapability("app","C:/Users/leila/Documents/GitHub/Trello-nadya/trello_mob/src/test/resources/Trello_new.apk");
     driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @Test
    public void openAppTest(){
        System.out.println("App opened");

    }
    @AfterMethod
    public void teardown (){

    }
}
