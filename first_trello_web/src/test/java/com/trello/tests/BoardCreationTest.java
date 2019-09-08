package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {
    @Test
    public void testBoardCreation(){
       
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillBoardCreationForm();
        confirmBoardCreation();
        Assert.assertTrue(isUserLoggedIn());


    }


}



