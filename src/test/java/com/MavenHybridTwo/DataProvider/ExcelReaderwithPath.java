package com.MavenHybridTwo.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderwithPath {
	XSSFWorkbook wb;

	public ExcelReaderwithPath (String XLFile)// create constructor 
	{
		try {
			wb = new XSSFWorkbook(new FileInputStream( new File(XLFile)));
			// every time we call this constructor we should be able to load the data 
			System.out.println("LOG :INFO- Excel is ready to use");
		} 
		catch (IOException e) {
			System.out.println("Exception while reading Excel" +e.getMessage());			
		}
	}

	public String  getCellData( String sheetName, int row , int column)
	{
		XSSFCell cell= wb.getSheet(sheetName).getRow(row).getCell(column);
		String data = "";
		if( cell.getCellType() ==  CellType.STRING)
		{
			data = cell.getStringCellValue();					
		}
		else if( cell.getCellType() == CellType.NUMERIC)
		{
			double  celVal = cell.getNumericCellValue();
			data =    String.valueOf(celVal);
		}

		else if( cell.getCellType() == CellType.BLANK )
		{

			data = "";

		}
		return data;
	}


	public String  getCellData( int sheetIndex , int row , int column)
	{
		XSSFCell cell= wb.getSheetAt(sheetIndex).getRow(row).getCell(column);
		String data = "";
		if( cell.getCellType() ==  CellType.STRING)
		{
			data = cell.getStringCellValue();					
		}
		else if( cell.getCellType() == CellType.NUMERIC)
		{
			double  celVal = cell.getNumericCellValue();
			data =    String.valueOf(celVal);
		}

		else if( cell.getCellType() == CellType.BLANK )
		{

			data = "";

		}
		return data;
	}


	public int getNumberOfColumns(String sheetName )
	{		
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}

	public int getNumberOfColumns(int sheetIndex)
	{		
		return  wb.getSheetAt(sheetIndex).getPhysicalNumberOfRows();	

	}	

	public int getNumberOfRows(String sheetName)
	{		
		return  wb.getSheet(sheetName).getPhysicalNumberOfRows();	

	}

	public int getNumberOfRows(int sheetIndex)
	{		
		return  wb.getSheetAt(sheetIndex).getPhysicalNumberOfRows();	

	}

}
