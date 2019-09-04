package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {
    @Test
    public void testBoardCreation(){
        Assert.assertTrue(isUserLoggedIn());

    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator) {

        return driver.findElements(locator).size()>0;
    }

    @Override
    public void click(By locator) {
        super.click(locator);
    }
}



