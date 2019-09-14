package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

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
        public void testBoardCreation() throws InterruptedException {
            int before = app.getBoardsCount();
            app.clickOnPlusButtonOnHeader();
            app.selectCreateBoardFromDropDown();
            app.fillBoardCreationForm();
            app.confirmBoardCreation();
            app.returnToHome();
            app.refreshPage();
            int after = app.getBoardsCount();
            Assert.assertEquals(after, before );

            Assert.assertTrue(app.isUserLoggedIn());

        }
   }



