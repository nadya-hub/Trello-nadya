package com.trello.qa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {
    @BeforeClass
    public void ensurePreconditionsLogin() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login("leila231@rambler.ru", "12345rambler");
        }

    }
    @BeforeMethod
    public void isOnHomePage() throws InterruptedException {
        if (!app.getSessionHelper().isTherePersonalBoards()) {
            app.getSessionHelper().returnToHome();
        }
    }

    @Test
    public void deleteTeamFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        while(before>2){
        app.getTeamHelper().clickSettingsButton();
        app.getTeamHelper().clickDeleteThisTeam();
        app.getTeamHelper().clickConfirmButton();

       before = app.getTeamHelper().getTeamsCount();}
        //int after=getTeamsCount();
      // Assert.assertEquals(after,before-1);
        //Assert.assertTrue(isUserLoggedIn());


}}
