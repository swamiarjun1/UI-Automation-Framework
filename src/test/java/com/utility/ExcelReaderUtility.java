package com.utility;

import java.awt.desktop.UserSessionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	
	
	public static Iterator<User> readExcelFile(String fileName)   {
		
		File file = new File(System.getProperty("user.dir")+"/testData/"+fileName);
		XSSFWorkbook xssfWorkbook = null;
		List<User> userList = null;
	
			try {
				xssfWorkbook = new XSSFWorkbook(file);
				
				XSSFSheet xssfSheet=xssfWorkbook.getSheet("LoginTestData");
				
				Iterator<Row> rowIterator=xssfSheet.iterator();
				rowIterator.next();
				userList = new ArrayList<User>();
				
				while(rowIterator.hasNext())
				{
					Row row= rowIterator.next();
					Cell firstCell=row.getCell(0);
					Cell secondCell=row.getCell(1);			
					userList.add(new User(firstCell.toString(), secondCell.toString()));
					
				}
				xssfWorkbook.close();
							
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return userList.iterator();
		
		 
	}

}
