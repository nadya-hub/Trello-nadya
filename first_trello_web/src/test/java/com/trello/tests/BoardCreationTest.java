package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

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
        public void testBoardCreation() throws InterruptedException {
            int before = getBoardsCount();
            clickOnPlusButtonOnHeader();
            selectCreateBoardFromDropDown();
            fillBoardCreationForm();
            confirmBoardCreation();
            returnToHome();
            refreshPage();
            int after = getBoardsCount();
            Assert.assertEquals(after, before );

            Assert.assertTrue(isUserLoggedIn());

        }
   }



