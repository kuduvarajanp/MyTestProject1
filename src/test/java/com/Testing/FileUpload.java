package com.Testing;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUpload {

	private FirefoxDriver driver=null;
	//Click the file upload link
	public FirefoxDriver clickLink(FirefoxDriver driver){
		this.driver = driver;
		driver.findElementByLinkText("File Upload").click();
		return(driver);
		}
	//Upload a text file 
	public String uploadFile(FirefoxDriver driver){
		this.driver=driver;
		String FileLocation="C:\\Users\\Public\\Testing.docx";
		String[] parts = FileLocation.split("\\\\");
		int Length=parts.length;
		String FileName=parts[Length-1];
		driver.findElementById("file-upload").sendKeys(FileLocation);
		driver.findElementById("file-submit").click();
		return(FileName);
	}
	//Checks file uploaded successfully
	public void checkforSuccessfulUpload(FirefoxDriver driver,String FileName){
	this.driver=driver;
	driver.get("http://the-internet.herokuapp.com/");
	//Verifies whether the uploaded file is present
	driver.findElementByLinkText("File Download").click();
	boolean present;
	try {
	   driver.findElementByLinkText(FileName);
	   present = true;
	} catch (NoSuchElementException e) {
	   present = false;
	}
	if(present){
		System.out.println("File uploaded successfully");
	}
	else
	{
		System.out.println("File not uploaded");
	}
	

	}
	
}
