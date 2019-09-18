package com.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase{

    public BoardHelper(WebDriver driver) {
        super(driver);
    }

    //    public void returnToHome() throws InterruptedException {
//        Thread.sleep(10000);
//        click(By.cssSelector("a[href='/']"));//""
//        click(By.cssSelector("a[href='/']"));
//
//    }
    public void returnToHome() {
        if(isElementPresent(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))){
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))));
            click(By.cssSelector("a[href='/']"));
            click(By.cssSelector("a[href='/']"));
        } else
            click(By.cssSelector("a[href='/']"));
    }

    public void clickXButton(){

    }

    public void confirmBoardCreation() {
        click(By.xpath("//button[@class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
     }

    public void fillBoardCreationForm() {
         driver.findElement(By.xpath("//input[@placeholder='Add board title']")).sendKeys("ABC");
     }

    public void selectCreateBoardFromDropDown() {
         click(By.xpath("//li[1]//button[1]//p[1]"));
     }


    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    protected int getBoardsCount() {
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

    public void clickPermanentlyDelete() {
          click(By.cssSelector("a[class='quiet js-delete']"));
      }

    public void clickConfirmClose() throws InterruptedException {
        Thread.sleep(5000);
        click(By.cssSelector(".js-confirm"));
          //click(By.cssSelector("input[class='js-confirm full negate']"));
      }

    public void clickCloseBoard() throws InterruptedException {
        Thread.sleep(5000);
          click(By.cssSelector("a[class='board-menu-navigation-item-link js-close-board']"));
      }

    public void clickButtonMore() throws InterruptedException {
        Thread.sleep(5000);

          click(By.cssSelector("a[class='board-menu-navigation-item-link js-open-more']"));
      }

    public void clickOnTheBoard() {
          click(By.cssSelector("div[class='board-tile-details-name']"));
      }



}
