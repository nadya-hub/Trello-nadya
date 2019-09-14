package com.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;

    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();//max window

        openSite("https://trello.com");
        login("leila231@rambler.ru", "12345rambler");
    }

    public void login(String email, String password) {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("[type=email]"), email);
        type(By.cssSelector("[type=password]"), password);
        click(By.id("login"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();

    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void openSite(String url) {
        driver.get(url);

    }

    public void stop() {
        driver.quit();
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void clickContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("textarea"), description);
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
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

    public int getTeamsCount() throws InterruptedException {
        //Thread.sleep(5000);
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li")));
        return driver.findElements(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public void clickXButton(){

    }

    protected String getTeamNameFromTeamPage() {
        return driver.findElement(By.cssSelector("h1")).getText();
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

    public void clickConfirmButton() {
       // new WebDriverWait(driver,6)
               // .until(ExpectedConditions.elementToBeClickable(By.xpath("input[class='js-confirm full negate']")));

        //click(By.xpath("input[class='js-confirm full negate']"));
        click(By.cssSelector(".js-confirm"));
     }

    public void clickDeleteThisTeam() {
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quiet-button")));
        click(By.cssSelector(".quiet-button"));
     }

    public void clickSettingsButton() {
         click(By.xpath("//div[3]//div[1]//div[2]//a[3] "));
     }

    protected int getBoardsCount() {
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

    public void clickPermanentlyDelete() {
          click(By.cssSelector("a[class='quiet js-delete']"));
      }

    public void clickConfirmClose() {
          click(By.cssSelector("input[class='js-confirm full negate']"));
      }

    public void clickCloseBoard() {
          click(By.cssSelector("a[class='board-menu-navigation-item-link js-close-board']"));
      }

    public void clickButtonMore() {
          click(By.cssSelector("a[class='board-menu-navigation-item-link js-open-more']"));
      }

    public void clickOnTheBoard() {
          click(By.cssSelector("div[class='board-tile-details-name']"));
      }

    public void refreshPage() {
         driver.navigate().refresh();
     }

    public void clickOnPlusButtonOnLeftNavMenu() {
        click(By.cssSelector(".icon-add.icon-sm"));
    }

    public boolean isTherePersonalBoards() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    protected void clickOnMoreButtonInBoardMenu() {
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
}