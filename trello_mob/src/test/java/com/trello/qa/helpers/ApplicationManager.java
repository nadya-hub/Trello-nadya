package com.trello.qa.helpers;

import com.trello.qa.BoardHelper;
import com.trello.qa.SessionHelper;
import com.trello.qa.TeamHelper;
import com.trello.qa.UserHelper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {
    AppiumDriver driver;
    TeamHelper teamHelper;
    BoardHelper boardHelper;
    SessionHelper sessionHelper;
    UserHelper userHelper;

    public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nexus");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.trello");
        capabilities.setCapability("appActivity", ".home.HomeActivity");
        capabilities.setCapability("app", "C:/Users/leila/Documents/GitHub/Trello-nadya/trello_mob/src/test/resources/Trello_new.apk");
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        teamHelper= new TeamHelper(driver);
        boardHelper = new BoardHelper(driver);
        sessionHelper= new SessionHelper(driver);
        userHelper= new UserHelper(driver);

       sessionHelper.login("leila231@rambler.ru", "12345rambler");
    }

    public void stop() {
        //driver.quit();
    }

    public TeamHelper getTeamHelper() {
        return teamHelper;
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public UserHelper getUserHelper() { return userHelper; }
}
