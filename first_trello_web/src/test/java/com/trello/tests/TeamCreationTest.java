package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {
    @BeforeClass
public void ensurePreconditionsLogin(){
        if(!app.getSessionHelper().isUserLoggedIn()){
            app.getSessionHelper().login("leila231@rambler.ru", "12345rambler");
        }

}
@BeforeMethod
public void isOnHomePage() throws InterruptedException {
        if(!app.getSessionHelper().isTherePersonalBoards()){
            app.getSessionHelper().returnToHome();
        }
}

    @Test
    public void testTeamCreationFromButtonOnHeader() throws InterruptedException {

        int before = app.getTeamHelper().getTeamsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        String teamName ="qa21-"+ System.currentTimeMillis();
        app.getTeamHelper().fillTeamCreationForm(teamName,"Description");
        app.getTeamHelper().clickContinueButton();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getSessionHelper().returnToHome();
        //refreshPage();
        int after= app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after,before+1);
//        Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());

    }

        @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnLeftNavMenu();
        app.getTeamHelper().fillTeamCreationForm("h", "g");
        app.getTeamHelper().clickContinueButton();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getSessionHelper().returnToHome();
        int after = app.getTeamHelper().getTeamsCount();

        Assert.assertEquals(after, before+1);
       // Assert.assertEquals(createdTeamName, "h");
    }

    @Test(enabled = false)
   public void testTeamCuncellCreationFromButtonOnHeader(){
        app.getBoardHelper().clickOnPlusButtonOnHeader();
       app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().fillTeamCreationForm("QA21","Description");




        //Assert.assertTrue(isUserLoggedIn());

   }

}




