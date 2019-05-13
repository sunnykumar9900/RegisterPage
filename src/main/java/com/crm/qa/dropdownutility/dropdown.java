package com.crm.qa.dropdownutility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Testbaseclass;
import com.crm.qa.util.UtilityClass;

public class dropdown extends Testbaseclass{

   public static String DropDown_Value;	
	
	public static String DropDown_Location()
	{
		
		
		//*[@id="loginapp"]/div[6]/div/div/div[1]/a/div/div
		//*[@id="loginapp"]/div[6]/div/div/div[2]/a/div/div
		//*[@id="loginapp"]/div[6]/div/div/div[3]/a/div/div
		
		String beforexpath="//*[@id=\"loginapp\"]/div[6]/div/div/div[";
		String afterxpath="]/a/div/div";
		
		List<WebElement> ele = driver.findElements(By.xpath("*[@id=\"loginapp\"]/div[6]/div/div/div"));
		int size = ele.size();
		
		UtilityClass dropdownutil = new UtilityClass("C:\\Users\\admin\\Desktop\\excelpart2.xlsx");
		dropdownutil.addSheet("DropDown");
		
				
		
		for(int i=1;i<=size;i++)
		{
			
			String actuaxpath=beforexpath+i+afterxpath;
			String DropDown_Value=driver.findElement(By.xpath(actuaxpath)).getText();
			dropdownutil.setCellData("DropDown","Medical_Council_Location",i,"Medical_Council_Location");
			
			
			
			
		}
				
		return DropDown_Value;	
	}
}
