package com.trello.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {
    @BeforeClass
    public void ensurePreconditionsLogin() {
        if (!app.isUserLoggedIn()) {
            app.login("leila231@rambler.ru", "12345rambler");
        }

    }
    @BeforeMethod
    public void isOnHomePage() throws InterruptedException {
        if (!app.isTherePersonalBoards()) {
            app.returnToHome();
        }
    }

    @Test
    public void deleteTeamFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamsCount();
        while(before>2){
        app.clickSettingsButton();
        app.clickDeleteThisTeam();
        app.clickConfirmButton();
       before = app.getTeamsCount();}
        //int after=getTeamsCount();
      // Assert.assertEquals(after,before-1);
        //Assert.assertTrue(isUserLoggedIn());


}}
