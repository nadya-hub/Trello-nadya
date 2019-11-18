package com.trello.qa.helpers;

import com.trello.qa.model.TeamData;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TeamHelper extends HelperBase{

    public TeamHelper(AppiumDriver driver) {
        super(driver);
    }

    public TeamHelper(WebDriver driver) {
        super(driver);
    }

    public void clickContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }
    public void fillTeamCreationForm(TeamData team) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), team.getTeamName());
        type(By.cssSelector("textarea"), team.getDescription());
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

    public String getTeamNameFromTeamPage() throws InterruptedException {
        Thread.sleep(3000);
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
    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
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

    public boolean isTeamsPresent() throws InterruptedException {
       return getTeamsCount()>0;
    }


    public void createTeam() throws InterruptedException {
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName = "qa21-" + System.currentTimeMillis();
        fillTeamCreationForm(new TeamData().withTeamName(teamName).withDescription("Description"));
        clickContinueButton();
       returnToHomePage();
    }

    private void returnToHomePage() {
        click(By.cssSelector("a[href='/']"));
    }

    public void clickcXButton() {
        click(By.xpath("//button[@class='qb90FI2uVIybRy _2b_HpRl1Tyl1YK']//span[@name='close'] "));
    }
}
