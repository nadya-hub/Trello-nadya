package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAvatar() throws InterruptedException {
        Thread.sleep(5000);
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));

    }

    public void openProfileFromDropDown() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void initAvatarChanging() throws InterruptedException {
        Thread.sleep(10000);
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector(".rsiNque2CCqtPE"))).click().perform();
    }

    public void addPicture() {
        attach(new File("C:/Users/leila/Documents/GitHub/Trello-nadya/first_trello_web/src/test/resources/30256.jpg"));
    }

    private void attach(File file) {
        driver.findElement(By.name("file")).sendKeys(file.getAbsolutePath());
    }
}
