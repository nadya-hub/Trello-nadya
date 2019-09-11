package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
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
    public void testDeleteBoard() {
        int before = getBoardsCount();
        //while(before>2){
        clickOnTheBoard();
       // clickOnMoreButtonInBoardMenu();
       clickButtonMore();
        clickCloseBoard();
        clickConfirmClose();
        clickPermanentlyDelete();
       // before=getBoardsCount();}
        int after= getBoardsCount();

        Assert.assertEquals(after,before-1);
        //Assert.assertTrue(isUserLoggedIn());
    }
}
