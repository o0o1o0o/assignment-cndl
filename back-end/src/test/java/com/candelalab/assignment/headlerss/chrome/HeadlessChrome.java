package com.candelalab.assignment.headlerss.chrome;

import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;  
public class HeadlessChrome 
{  
 @Test  
 public void createChromeDriverHeadless() throws IOException  
 {  
   ChromeOptions chromeOptions = new ChromeOptions();  
   System.setProperty("webdriver.chrome.driver", "C:\\Users\\anjan\\Desktop\\cucmber\\chromedriver_win32\\chromedriver.exe");  
   chromeOptions.addArguments("--headless");  
   chromeOptions.addArguments("--disable-gpu");  
   WebDriver Driver = new ChromeDriver(chromeOptions);  
   Driver.navigate().to("https://localhost:");  
   WebDriverWait waitForUsername = new WebDriverWait(Driver, 5000);  
   waitForUsername.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));  
   Driver.findElement(By.id("email")).sendKeys("tomsmith");  
   Driver.findElement(By.id("loginbutton")).click();  
   WebDriverWait waitForError = new WebDriverWait(Driver, 5000);  
   waitForError.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));  
   Assert.assertTrue(Driver.findElement(By.id("loginbutton")).getText().contains("Log In"));  
   Driver.quit();  
 }  
}  