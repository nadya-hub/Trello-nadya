package com.trello.qa.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TeamHelper extends HelperBase{

    public TeamHelper(WebDriver driver) {
        super(driver);
    }
    public void clickContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }
    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("textarea"), description);
    }

    public void selectCreateTeamFromDropDown() throws InterruptedException {
        Thread.sleep(5000);
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }



    public int getTeamsCount() throws InterruptedException {
        Thread.sleep(5000);
      // new WebDriverWait(driver,5)
       //         .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li")));
        return driver.findElements(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public String getTeamNameFromTeamPage() {
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public void clickDeleteThisTeam() throws InterruptedException {
        Thread.sleep(5000);
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quiet-button")));
        click(By.cssSelector(".quiet-button"));
     }
    public void clickConfirmButton() {
        // new WebDriverWait(driver,6)
        // .until(ExpectedConditions.elementToBeClickable(By.xpath("input[class='js-confirm full negate']")));

        //click(By.xpath("input[class='js-confirm full negate']"));
        click(By.cssSelector(".js-confirm"));
    }

    public void clickSettingsButton() {
         click(By.xpath("//div[3]//div[1]//div[2]//a[3] "));
     }

    public void clickOnPlusButtonOnLeftNavMenu() {
        click(By.cssSelector(".icon-add.icon-sm"));
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

    public void initEditTeamProfile() {
       // waitForElementAndClick(By.cssSelector(".js-edit-profile"));
        click(By.cssSelector(".js-edit-profile"));
    }

    public void changeTeamProfile(String Name, String description) {
       type(By.name("displayName"),Name);
        type(By.name("desc"),description);
    }

    public void confirmEditTeam() {
        click(By.cssSelector(".js-submit-profile"));

    }
}
