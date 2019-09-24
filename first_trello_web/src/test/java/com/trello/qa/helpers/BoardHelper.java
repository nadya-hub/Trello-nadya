package com.trello.qa.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase{

    public BoardHelper(WebDriver driver) {
        super(driver);
    }

//        public void returnToHome() throws InterruptedException {
//        Thread.sleep(10000);
//        click(By.cssSelector("a[href='/']"));}
    public void returnToHome() {
        if(isElementPresent(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))){
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))));
            click(By.cssSelector("a[href='/']"));
            click(By.cssSelector("a[href='/']"));
        } else
            click(By.cssSelector("a[href='/']"));
    }

    public void confirmBoardCreation() {
        click(By.xpath("//button[@class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
     }

    public void fillBoardCreationForm(BoardData board) {
         driver.findElement(By.xpath("//input[@placeholder='Add board title']")).sendKeys(board.getBoardName());
        if(isElementPresent(By.cssSelector(".W6rMLOx8U0MrPx"))){
            click(By.cssSelector(".W6rMLOx8U0MrPx"));
            click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));//no team
        }
     }

    public void selectCreateBoardFromDropDown() {
         click(By.xpath("//li[1]//button[1]//p[1]"));
     }
    public void clickOnMoreButtonInBoardMenu() {
        WebElement menuButton = driver.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
        System.out.println(menuButton.getCssValue("visibility"));
        if (menuButton.getCssValue("visibility").equals("visible")) {
            click(By.cssSelector(".mod-show-menu"));
            click(By.cssSelector(".js-open-more"));
        } else {
            click(By.cssSelector(".js-open-more"));
            menuButton = driver.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
            System.out.println(menuButton.getCssValue("visibility"));
            if (menuButton.getCssValue("visibility").equals("visible")) {
                click(By.cssSelector(".mod-show-menu"));
                click(By.cssSelector(".js-open-more"));
            } else {
                click(By.cssSelector(".js-open-more"));
            }


        }
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }
    public int getBoardsCount() throws InterruptedException  {
        Thread.sleep(5000);
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

    public void clickPermanentlyDelete() throws InterruptedException {
        Thread.sleep(3000);
          click(By.cssSelector("a[class='quiet js-delete']"));
      }

    public void clickConfirmClose() throws InterruptedException {

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

    public void clickOnFirstPrivateBoard() {
       //click(By.cssSelector("li[class='boards-page-board-section-list-item']"));
        click(By.cssSelector("div[class=board-tile-details-name]"));
      }



    public void clickByNameBoard() throws InterruptedException {
        click(By.xpath("//span[@class='js-board-editing-target board-header-btn-text']"));
        Thread.sleep(3000);

    }
    public void changeBoardName(String name) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".js-rename-board")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input.js-board-name-input")).sendKeys(name);

    }
    public void changeNameTheBoard(String name) {
        driver.findElement(By.cssSelector(".js-rename-board")).click();
        driver.findElement(By.cssSelector(".js-board-name-input")).sendKeys(name);
       // type(By.xpath("//input[@class='board-name-input js-board-name-input']"),name);
        //type(By.xpath("//div[@id='content']//input[1]"),name);

    }

    public String getBoardNameFromBoardPage() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(By.cssSelector(".is-badged")).getText();
    }

    public void createBoard() {
        clickOnPlusButtonOnHeader();
       selectCreateBoardFromDropDown();
       String boardName ="Hope";
       fillBoardCreationForm(new BoardData().withBoardName(boardName));
       confirmBoardCreation();
       returnToHome();
       refreshPage();
    }



//    public void initChangeBoard() {
//        WebElement nameField = driver.findElement(By.cssSelector(".js-rename-board"));
//        new Actions(driver).moveToElement(nameField).click().perform();
//        type(By.cssSelector("input.js-board-name-input"),"one");
//        driver.findElement(By.cssSelector("input.js-board-name-input")).sendKeys(Keys.ENTER);

   // }
}
