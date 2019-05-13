package com.crm.qa.register;

import java.util.ArrayList;

import com.crm.qa.util.UtilityClass;
import com.google.common.collect.ObjectArrays;

public class Register {

	
	public static UtilityClass util;
	
	public static ArrayList<Object[]> getdatafromExcel()
	
	
	{
	
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		
		try
		{
		util= new UtilityClass("C:\\Users\\admin\\Desktop\\excelpart2.xlsx");
		
	}

	catch (Exception e) {
		
	}
	
		for(int rowNum=1;rowNum<=util.getRowCount("DataValue");rowNum++)
		{
			
			String firstname=util.getCellData("DataValue","firstname", rowNum);
			String Lastname=util.getCellData("DataValue","Lastname", rowNum);
			String email=util.getCellData("DataValue","email", rowNum);
			String mobile=util.getCellData("DataValue","mobile", rowNum);
			String pass=util.getCellData("DataValue","pass", rowNum);
			String Regist_Num=util.getCellData("DataValue","Regist_Num", rowNum);
			
			Object[] ob = {firstname,Lastname,email,mobile,pass,Regist_Num};
			data.add(ob);
			
		}
	return data;	
	}
	}
