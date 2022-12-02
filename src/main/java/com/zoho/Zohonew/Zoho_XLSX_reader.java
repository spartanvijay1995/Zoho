package com.zoho.Zohonew;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Zoho_XLSX_reader {
	public static String valueOf;
	
	public static String Single_zoho(String name,int rowNo,int cellNo) throws IOException {
		File f=new File("C:\\\\Users\\\\admin\\\\Desktop\\\\workbook.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fi);
		Sheet s=w.getSheet(name);
		Row r=s.getRow(rowNo);
		Cell c=r.getCell(cellNo);
		CellType ce=c.getCellType();
		if(ce.equals(CellType.STRING)) {
			valueOf=c.getStringCellValue();
			
		}else if(ce.equals(CellType.NUMERIC)) {
			double d=c.getNumericCellValue();
			int i=(int) d;
		valueOf = String.valueOf(i);
		}
		
		return(valueOf);

	}

	public static void main(String[] args) throws IOException {
		Single_zoho(valueOf, 0, 0);
		

	}

}
