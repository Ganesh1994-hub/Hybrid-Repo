package com.QA.Utlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.QA.Baseclass.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=60;
	public static long Implicit_wait=10;
		
	public void swithchToFrame()
	{
		d.switchTo().frame("mainpanel");
	}
	
	public Object[][] getTestData(String sheetName) throws IOException
	{
		FileInputStream fis=null;
		fis = new FileInputStream("D:\\workspace_working\\HybridFramework\\src\\main\\java\\com\\QA\\Testdata\\CRM contatc data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheetName);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
			
		
	}

	public static void takeScreenshotAtEndOfTest() throws IOException 
	{
		// TODO Auto-generated method stub
		String currDir=System.getProperty("user.dir");
			TakesScreenshot t=(TakesScreenshot) d;
			File f1=t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f1, new File(currDir+"/ScreenShots/"+System.currentTimeMillis()+".png"));
			
	}

}
