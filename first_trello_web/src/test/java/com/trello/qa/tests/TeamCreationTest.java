package com.trello.qa.tests;

import com.trello.qa.helpers.TeamData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamCreationTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validTeams() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"name", "description"});
        list.add(new Object[]{"NAME", "DESCR"});
        list.add(new Object[]{"naME1", "!@#3"});
        list.add(new Object[]{"Name%", "23445"});
        list.add(new Object[]{"Name%", ""});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validTeamsfromcsv() throws IOException {
        List<Object[]> list= new ArrayList<>();
        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/Team.csv")));
        String line = reader.readLine();
        while(line!=null){
            String[] split= line.split(",");
            list.add(new Object[]{new TeamData().withTeamName(split[0]).withDescription(split[1])});
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

    @Test
    public void testTeamCreationFromButtonOnHeader() throws InterruptedException {

        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        String teamName = "qa21-" + System.currentTimeMillis();
        app.getTeamHelper().fillTeamCreationForm(new TeamData().withTeamName(teamName).withDescription("Description"));
        app.getTeamHelper().clickContinueButton();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getSessionHelper().returnToHome();
        //refreshPage();
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before + 1);
//        Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());
    }

    @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnLeftNavMenu();
        app.getTeamHelper().fillTeamCreationForm(new TeamData().withTeamName("h").withDescription("u"));
        app.getTeamHelper().clickContinueButton();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getSessionHelper().returnToHome();
        int after = app.getTeamHelper().getTeamsCount();

        Assert.assertEquals(after, before + 1);
        // Assert.assertEquals(createdTeamName, "h");
    }

    @Test(enabled = false)
    public void testTeamCuncellCreationFromButtonOnHeader() throws InterruptedException {
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().fillTeamCreationForm(new TeamData().withTeamName("QA21").withDescription("Description"));

        //Assert.assertTrue(isUserLoggedIn());

    }

        @Test(dataProvider ="validTeams" )
    public void testTeamCreationFromButtonOnHeaderWithDataProvider(String teamName, String description) throws InterruptedException {
        TeamData team= new TeamData().withTeamName(teamName).withDescription(description);
        int before = app.getTeamHelper().getTeamsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
      //  String teamName ="qa21-"+ System.currentTimeMillis();
        app.getTeamHelper().fillTeamCreationForm(team);
        app.getTeamHelper().clickContinueButton();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getSessionHelper().returnToHome();
        //refreshPage();
       // int after= app.getTeamHelper().getTeamsCount();
      //  Assert.assertEquals(after,before+1); }
//    @Test(dataProvider = "validTeamsfromcsv")
//    public void testTeamCreationFromButtonOnHeaderWithDataProviderFromcsv(TeamData team) throws InterruptedException {
//        TeamData team = new TeamData().withTeamName(teamName).withDescription(description);
//        int before = app.getTeamHelper().getTeamsCount();
//        app.getTeamHelper().clickOnPlusButtonOnHeader();
//        app.getTeamHelper().selectCreateTeamFromDropDown();
//        app.getTeamHelper().fillTeamCreationForm(team);
//        app.getTeamHelper().clickContinueButton();
//        //String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
//        app.getSessionHelper().returnToHome();
//        //refreshPage();
//        int after = app.getTeamHelper().getTeamsCount();
//        Assert.assertEquals(after, before + 1);
//    }

}}


