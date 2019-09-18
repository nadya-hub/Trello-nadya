package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeClass
    public void ensurePreconditionsLogin() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login("leila231@rambler.ru", "12345rambler");
        }

    }
    @BeforeMethod
    public void isOnHomePage() throws InterruptedException {
        if (!app.sessionHelper.isTherePersonalBoards()) {
            app.getSessionHelper().returnToHome();
        }
    }

    @Test
    public void testDeleteBoard() throws InterruptedException {
        int before = app.getBoardHelper().getBoardsCount();
     // while(before>2){
        app.getBoardHelper().clickOnTheBoard();
       // clickOnMoreButtonInBoardMenu();
       app.getBoardHelper().clickButtonMore();
        app.getBoardHelper().clickCloseBoard();
        app.getBoardHelper().clickConfirmClose();

        app.getBoardHelper().clickPermanentlyDelete();
        //before=getBoardsCount();}
        int after= app.getBoardHelper().getBoardsCount();

        Assert.assertEquals(after,before-1);

    }
}
