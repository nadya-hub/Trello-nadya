package com.trello.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {
    @BeforeClass
    public void ensurePreconditionsLogin() {
        if (!isUserLoggedIn()) {
            login("leila231@rambler.ru", "12345rambler");
        }

    }
    @BeforeMethod
    public void isOnHomePage() throws InterruptedException {
        if (!isTherePersonalBoards()) {
            returnToHome();
        }
    }

    @Test
    public void deleteTeamFromLeftNavMenu() throws InterruptedException {
        int before = getTeamsCount();
        while(before>2){
        clickSettingsButton();
        clickDeleteThisTeam();
        clickConfirmButton();
        before = getTeamsCount();
        }
        //int after=getTeamsCount();
        //Assert.assertEquals(after,before-1);
        //Assert.assertTrue(isUserLoggedIn());


}}
