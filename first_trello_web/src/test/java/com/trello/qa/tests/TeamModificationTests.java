package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
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
        }}

    @Test
    public  void testRenameTeam() throws InterruptedException {
        app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickSettingsButton();
        app.getTeamHelper().initEditTeamProfile();
        app.getTeamHelper().changeTeamProfile("Ho","HU");
        app.getTeamHelper().confirmEditTeam();
        Thread.sleep(5000);

        Assert.assertEquals(app.getTeamHelper().getTeamNameFromTeamPage(),"Ho");

    }
}
