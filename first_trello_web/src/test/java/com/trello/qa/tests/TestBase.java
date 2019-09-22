package com.trello.qa.tests;

import com.trello.qa.helpers.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite

    public void setUp() {
        app.init();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }


}

