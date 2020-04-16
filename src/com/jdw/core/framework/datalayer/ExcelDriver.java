package com.jdw.core.framework.datalayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 *  Author Name : Pritam Kumar
 *  It Will work with Excel sheet
 */

public class ExcelDriver 
{
	public String filePath;
	public String sheetName;
	public ExcelDriver(String filePath, String sheetName)
	{
		this.filePath = filePath;
		this.sheetName = sheetName;
	}
	
	/**
	 * getData(int rowNum, int colNum) : is use to read the data from excel sheet and it will return Same Data
	 * @param rowNum : Row number from where it needs to read the Data
	 * @param colNum : Column number from where it needs to read the Data
	 *  
	 */
	
	public String getData(int rowNum, int colNum)
	{
		String data= "";
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell = row.getCell(colNum);
			
			data = cell.getStringCellValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * setData(int rowNum, int colNum, String data) : is use to Set the data To the excel sheet
	 * @param rowNum : Row number to which need to set the Data
	 * @param colNum : Column number to which need to set the Data
	 * @param data : Data need to write to the excel sheet
	 */
	
	public void setData(int rowNum, int colNum, String data)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell = row.createCell(colNum);
			cell.setCellType(CellType.STRING);
			cell.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(filePath);
			workbook.write(fos);
			fos.close();
			System.out.println("SUCCESS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList getAllRowData(int rowNum)
	{
		ArrayList al = new ArrayList();
		
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowNum);
			Iterator<Cell> itr = row.cellIterator();
			while(itr.hasNext())
			{
				Cell cell = itr.next();
				CellType cellType = cell.getCellType();
				switch(cellType)
				{
					case STRING:
						String data = cell.getStringCellValue();
						al.add(data);
						break;
					case NUMERIC:
						Number num = cell.getNumericCellValue();
						al.add(num);
						break;
					case BOOLEAN:
						Boolean b1 = cell.getBooleanCellValue();
						al.add(b1);
						break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
	
	
	public ArrayList getAllColData(int colNum)
	{
		ArrayList al = new ArrayList();
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Iterator<Row> itr = sheet.rowIterator();
			while(itr.hasNext())
			{
				Row row = itr.next();
				Cell cell = row.getCell(colNum);
				CellType cellType = cell.getCellType();
				switch(cellType)
				{
				case STRING:
					String data = cell.getStringCellValue();
					al.add(data);
					break;
				case NUMERIC:
					Number num = cell.getNumericCellValue();
					al.add(num);
					break;
				case BOOLEAN:
					Boolean b1 = cell.getBooleanCellValue();
					al.add(b1);
					break; 
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}
