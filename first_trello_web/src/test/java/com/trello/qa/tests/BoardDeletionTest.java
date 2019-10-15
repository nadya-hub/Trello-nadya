package com.trello.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTest extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getBoardHelper().isTherePersonalBoards()){
            app.getBoardHelper().createBoard();
        }
    }

    @Test
    public void testDeleteBoard() throws InterruptedException {
        Thread.sleep(3000);
        int before = app.getBoardHelper().getBoardsCount();
      while(before>2){
          app.getBoardHelper().clickOnFirstPrivateBoard();
          Thread.sleep(3000);
       // clickOnMoreButtonInBoardMenu();
       app.getBoardHelper().clickButtonMore();
        app.getBoardHelper().clickCloseBoard();
          Thread.sleep(3000);
        app.getBoardHelper().clickConfirmClose();
          Thread.sleep(3000);
        app.getBoardHelper().clickPermanentlyDelete();
        app.getBoardHelper().returnToHome();
       before=app.getBoardHelper().getBoardsCount();}
       // int after= app.getBoardHelper().getBoardsCount();
       // Assert.assertEquals(after,before-1);

    }
}
