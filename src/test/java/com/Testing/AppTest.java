package com.Testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppTest{
	//Program to upload text file
	//Verifies whether the file was uploaded successfully
	//Page object model and junit
	FileUpload fileupload = new FileUpload();
	private FirefoxDriver driver;
	//Opens the url and maximizes the window
	@Before
	public void openBrowser(){
		driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void TextFileUpload(){
		
	  fileupload.clickLink(driver);
	  String FileName=fileupload.uploadFile(driver);
	  fileupload.checkforSuccessfulUpload(driver,FileName);
	}
	
	@After
	public void closeBrowser(){
		driver.quit();
	}
	
}