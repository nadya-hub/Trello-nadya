package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {
    @BeforeClass
public void ensurePreconditionsLogin(){
        if(!app.isUserLoggedIn()){
            app.login("leila231@rambler.ru", "12345rambler");
        }

}
@BeforeMethod
public void isOnHomePage() throws InterruptedException {
        if(!app.isTherePersonalBoards()){
            app.returnToHome();
        }
}

    @Test
    public void testTeamCreationFromButtonOnHeader() throws InterruptedException {

        int before = app.getTeamsCount();
        app.clickOnPlusButtonOnHeader();
        app.selectCreateTeamFromDropDown();
        String teamName ="qa21-"+ System.currentTimeMillis();
        app.fillTeamCreationForm(teamName,"Description");
        app.clickContinueButton();
        String createdTeamName = app.getTeamNameFromTeamPage();
        app.returnToHome();
        //refreshPage();
        int after= app.getTeamsCount();
        Assert.assertEquals(after,before+1);
//        Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());

    }

        @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamsCount();
        app.clickOnPlusButtonOnLeftNavMenu();
        app.fillTeamCreationForm("h", "g");
        app.clickContinueButton();
        String createdTeamName = app.getTeamNameFromTeamPage();
        app.returnToHome();
        int after = app.getTeamsCount();

        Assert.assertEquals(after, before+1);
       // Assert.assertEquals(createdTeamName, "h");
    }

    @Test(enabled = false)
   public void testTeamCuncellCreationFromButtonOnHeader(){
        app.clickOnPlusButtonOnHeader();
       app.selectCreateTeamFromDropDown();
        app.fillTeamCreationForm("QA21","Description");
        app.clickXButton();



        //Assert.assertTrue(isUserLoggedIn());

   }

}




