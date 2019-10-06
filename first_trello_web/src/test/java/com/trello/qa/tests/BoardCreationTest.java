package com.trello.qa.tests;

import com.trello.qa.model.BoardData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validBoards(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Hello"});
        list.add(new Object[]{"34567"});
        list.add(new Object[]{"@%&*"});
        list.add(new Object[]{"TWO"});
        list.add(new Object[]{"4"});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validBoardsfromcsv() throws IOException {
        List<Object[]> list= new ArrayList<>();
        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/Boards.csv")));
        String line = reader.readLine();
        while(line!=null){
            String[] split= line.split(",");
            list.add(new Object[]{new BoardData().withBoardName(split[0])});
            line= reader.readLine();
        }
        return list.iterator();

    }
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

//        @Test()
//        public void testBoardCreation() throws InterruptedException {
//            int before = app.getBoardHelper().getBoardsCount();
//            app.getTeamHelper().clickOnPlusButtonOnHeader();
//            app.getBoardHelper().selectCreateBoardFromDropDown();
//            String boardName ="Hope";
//            app.getBoardHelper().fillBoardCreationForm(new BoardData().withBoardName(boardName));
//            app.getBoardHelper().confirmBoardCreation();
//            app.getBoardHelper().returnToHome();
//            app.getSessionHelper().refreshPage();
//            int after = app.getBoardHelper().getBoardsCount();
//            Assert.assertEquals(after, before );
//
//            Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());
//
//        }
        @Test(dataProvider ="validBoards")
    public void testBoardCreationWithDataProvider(String boardName) throws InterruptedException {
        BoardData board = new BoardData().withBoardName(boardName);
        int before = app.getBoardHelper().getBoardsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        //String boardName ="Hope";
        app.getBoardHelper().fillBoardCreationForm(board);
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHome();
        app.getSessionHelper().refreshPage();
        int after = app.getBoardHelper().getBoardsCount();
       // Assert.assertEquals(after, before );

       // Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());

    }
//    @Test(dataProvider ="validBoardsfromcsv")
//    public void testBoardCreationWithDataProviderFromcsv(BoardData board) throws InterruptedException {
//       // BoardData board = new BoardData().withBoardName(boardName);
//        int before = app.getBoardHelper().getBoardsCount();
//        app.getTeamHelper().clickOnPlusButtonOnHeader();
//        app.getBoardHelper().selectCreateBoardFromDropDown();
//        //String boardName ="Hope";
//        app.getBoardHelper().fillBoardCreationForm(board);
//        app.getBoardHelper().confirmBoardCreation();
//        app.getBoardHelper().returnToHome();
//        app.getSessionHelper().refreshPage();
//        int after = app.getBoardHelper().getBoardsCount();}
 }



