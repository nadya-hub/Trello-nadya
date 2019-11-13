package com.trello.qa;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SessionHelper extends com.trello.qa.HelperBase {
    public SessionHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        click(By.id("log_in_button"));
        type(By.id("user"), email);
        type(By.id("password"), password);
        click(By.id("authenticate"));
    }

    public void openSite(String url) {
        driver.get(url);

    }
    public boolean isUserLoggedIn() {
        return isTherePersonalBoards();
    }
    public void returnToHome() {
        if(isElementPresent(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))){
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))));
            click(By.cssSelector("a[href='/']"));
            click(By.cssSelector("a[href='/']"));
        } else
            click(By.cssSelector("a[href='/']"));
    }
}
