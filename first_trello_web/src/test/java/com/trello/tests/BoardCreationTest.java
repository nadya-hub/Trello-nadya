package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {
    @Test
    public void testBoardCreation() throws InterruptedException {
       int before = getBoardsCount();
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillBoardCreationForm();
        confirmBoardCreation();
        returnToHome();
        int after= getBoardsCount();
        Assert.assertEquals(after,before+1);

        Assert.assertTrue(isUserLoggedIn());

    }


}



