package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {
    @Test
    public void testTeamCreationFromButtonOnHeader(){
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("QA21","Description");
        clickContinueButton();
        //Accert


        Assert.assertTrue(isUserLoggedIn());

    }


}




