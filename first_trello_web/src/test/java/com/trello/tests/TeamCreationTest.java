package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {
    @BeforeClass
public void ensurePreconditionsLogin(){
        if(!isUserLoggedIn()){
            login("leila231@rambler.ru", "12345rambler");
        }

}
@BeforeMethod
public void isOnHomePage() throws InterruptedException {
        if(!isTherePersonalBoards()){
            returnToHome();
        }
}

    public boolean isTherePersonalBoards() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    @Test
    public void testTeamCreationFromButtonOnHeader() throws InterruptedException {

        int before = getTeamsCount();
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName ="qa21-"+ System.currentTimeMillis();
        fillTeamCreationForm(teamName,"Description");
        clickContinueButton();
        String createdTeamName = getTeamNameFromTeamPage();
        returnToHome();
        refreshPage();
        int after= getTeamsCount();
        Assert.assertEquals(after,before+1);
//        Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());

    }

    //    @Test
//    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
//        int before = getTeamsCount();
//        clickOnPlusButtonOnLeftNavMenu();
//        fillTeamCreationForm("h", "g");
//        clickContinueButton();
//        String createdTeamName = getTeamNameFromTeamPage();
//        returnToHome();
//        int after = getTeamsCount();
//
//        Assert.assertEquals(after, before+1);
//       // Assert.assertEquals(createdTeamName, "h");
//    }

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




