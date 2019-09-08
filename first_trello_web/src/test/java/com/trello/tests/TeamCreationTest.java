package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {
    @Test
    public void testTeamCreationFromButtonOnHeader() throws InterruptedException {
        int before = getTeamsCount();
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName ="qa21";
        fillTeamCreationForm(teamName,"Description");
        clickContinueButton();
        String createdTeamName = getTeamNameFromTeamPage();
        returnToHome();
        refreshPage();
        int after= getTeamsCount();
        Assert.assertEquals(after,before+1);
        Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());

    }

    private void refreshPage() {
        driver.navigate().refresh();
    }

    @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = getTeamsCount();
        clickOnPlusButtonOnLeftNavMenu();
        fillTeamCreationForm("h", "g");
        clickContinueButton();
        String createdTeamName = getTeamNameFromTeamPage();
        returnToHome();
        int after = getTeamsCount();

        Assert.assertEquals(after, before+1);
       // Assert.assertEquals(createdTeamName, "h");
    }

    public void clickOnPlusButtonOnLeftNavMenu() {
        click(By.cssSelector(".icon-add.icon-sm"));
    }

    @Test(enabled = false)
   public void testTeamCuncellCreationFromButtonOnHeader(){
        clickOnPlusButtonOnHeader();
       selectCreateTeamFromDropDown();
        fillTeamCreationForm("QA21","Description");
        clickXButton();



        Assert.assertTrue(isUserLoggedIn());

   }

}




