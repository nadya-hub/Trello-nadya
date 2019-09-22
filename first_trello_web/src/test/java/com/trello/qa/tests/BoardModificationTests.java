package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
    @Test
    public void testRenameBoard() throws InterruptedException {

        app.getBoardHelper().clickOnTheBoard();
        app.getBoardHelper().clickByNameBoard();
        String name="One";
        app.getBoardHelper().changeNameTheBoard(name);
        app.getBoardHelper().returnToHome();
        Assert.assertEquals(app.getBoardHelper().isTherePersonalBoards(),"One");



    }

}
