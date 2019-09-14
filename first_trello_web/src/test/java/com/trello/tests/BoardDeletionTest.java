package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
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
    public void testDeleteBoard() {
        int before = app.getBoardsCount();
     // while(before>2){
        app.clickOnTheBoard();
       // clickOnMoreButtonInBoardMenu();
       app.clickButtonMore();
        app.clickCloseBoard();
        app.clickConfirmClose();
        app.clickPermanentlyDelete();
        //before=getBoardsCount();}
        int after= app.getBoardsCount();

        Assert.assertEquals(after,before-1);

    }
}
