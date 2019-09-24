package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getBoardHelper().isTherePersonalBoards()){
            app.getBoardHelper().createBoard();
        }
    }
    @Test
    public void testRenameBoard() throws InterruptedException {

        app.getBoardHelper().clickOnFirstPrivateBoard();
        String name="One";//+System.currentTimeMillis();
        app.getBoardHelper().changeBoardName(name);
        app.getBoardHelper().returnToHome();
        String thisBoardNameFromBoardPage = app.getBoardHelper().getBoardNameFromBoardPage();
       Assert.assertEquals(thisBoardNameFromBoardPage,name);



    }

}
