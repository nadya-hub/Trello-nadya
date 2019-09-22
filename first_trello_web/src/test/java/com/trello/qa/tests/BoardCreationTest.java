package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

        @BeforeClass
        public void ensurePreconditionsLogin() {
            if (!app.getSessionHelper().isUserLoggedIn()) {
                app.getSessionHelper().login("leila231@rambler.ru", "12345rambler");
            }

        }
        @BeforeMethod
        public void isOnHomePage() throws InterruptedException {
            if (!app.getSessionHelper().isTherePersonalBoards()) {
                app.getSessionHelper().returnToHome();
            }
        }

        @Test
        public void testBoardCreation() throws InterruptedException {
            int before = app.getBoardHelper().getBoardsCount();
            app.getBoardHelper().clickOnPlusButtonOnHeader();
            app.getBoardHelper().selectCreateBoardFromDropDown();
            app.getBoardHelper().fillBoardCreationForm();
            app.getBoardHelper().confirmBoardCreation();
            app.getBoardHelper().returnToHome();
            app.getSessionHelper().refreshPage();
            int after = app.getBoardHelper().getBoardsCount();
            Assert.assertEquals(after, before );

            Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());

        }
   }



