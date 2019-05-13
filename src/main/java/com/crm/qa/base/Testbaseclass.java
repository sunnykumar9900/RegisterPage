package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.dropdownutility.dropdown;
import com.crm.qa.register.Register;

public class Testbaseclass {

	
	
	public static WebDriver driver;
	@BeforeMethod
	public void launch()
	{
       
		System.setProperty("webdriver.chrome.driver","C:\\chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://facebook.com");
		
	}
	
	
	
	@Test(dataProvider="getdata")
	public void EnterDetails(String firstname,String Lastname,String email,String mobile
			,String pass,String Regist_Num,String dropdwn )
	{
		
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/form/div[1]/div[2]/div/div[1]/input")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/form/div[1]/div[3]/div/div[1]/input")).sendKeys(Lastname);
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/form/div[2]/div[1]/div/div[1]/input")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/form/div[2]/div[2]/div/div[1]/input")).sendKeys(mobile);
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/form/div[2]/div[3]/div/div[1]/input")).sendKeys(pass);;
		driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/form/div[2]/div[4]/div/div[1]/input")).sendKeys(Regist_Num);
		try
		{
			dropdown value = new dropdown();
			
			
			
			driver.findElement(By.xpath("//*[@id=\"statesofindia\"]/div/div")).sendKeys(value.DropDown_Value);
			
			
			
		}
		
		catch (Exception e) {
			
		}
	}

	
	@DataProvider
	public Iterator<Object[]> getdata()
	{
		
	ArrayList<Object[]> data=Register.getdatafromExcel();
	return data.iterator();
	}
	
@AfterMethod
public void Register()
{
	
	driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/form/div[4]/div/label")).click();
	driver.findElement(By.xpath("//*[@id=\"inspire\"]/div/form/div[5]/button/div")).click();
}


}



	
	


	