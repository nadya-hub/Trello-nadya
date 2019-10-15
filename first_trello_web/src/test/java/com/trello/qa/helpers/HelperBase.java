package com.trello.qa.helpers;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class HelperBase  {
    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();

    }

    public void type(By locator, String text) {
        if(text!=null){
            driver.findElement(locator).click();
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }

    }



    public void refreshPage() {
         driver.navigate().refresh();
     }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
    public boolean isTherePersonalBoards() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }
    public void takeScreenshot(){
        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screen = new File("src/test/resources/Screenshots/screen "+System.currentTimeMillis()+".png");
        try {
            Files.copy(tmp,screen);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
