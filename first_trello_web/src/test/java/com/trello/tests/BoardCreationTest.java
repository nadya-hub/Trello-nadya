package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {
    @Test
    public void testBoardCreation(){
        Assert.assertTrue(isUserLoggedIn());

      driver.findElement(By.xpath("//span[@name='add']")).click();
       driver.findElement(By.xpath("//li[1]//button[1]//p[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Add board title']")).sendKeys("ABC");
        driver.findElement(By.xpath("//button[@class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']")).click();

    }


}



