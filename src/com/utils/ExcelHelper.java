package com.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	XSSFWorkbook wb ;

	public ExcelHelper(String xlpath){
		try{
			
	 File src = new File(xlpath);	
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
			
		}
		catch (Exception e) {
			System.out.println("file is not found"+e.getMessage());
			
		}
	}	
		public int getLastrow(int sheetindex){
			int row = wb.getSheetAt(sheetindex).getLastRowNum();
			row=row +1;
			return row;
							
		}
			public String getdata(int sheetnum,int row,int col){
				String data = wb.getSheetAt(sheetnum).getRow(row).getCell(col).toString();
				return data;
			}
			
			}