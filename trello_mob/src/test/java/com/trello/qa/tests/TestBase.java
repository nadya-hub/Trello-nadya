package com.trello.qa.tests;

import com.trello.qa.helpers.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;


public class TestBase {
    public ApplicationManager app = new ApplicationManager();

    @BeforeSuite

    public void setUp() throws MalformedURLException {
        app.init();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }


}

