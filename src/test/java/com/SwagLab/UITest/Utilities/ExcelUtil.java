package com.SwagLab.UITest.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static XSSFWorkbook wb;

	public static String getStringData(String sheetname, int row, int cell) {

		// file path
		File f1 = new File(System.getProperty("user.dir") + "//TestData//Data.xlsx");

		FileInputStream fs;

		// read
		try {
			fs = new FileInputStream(f1);

			// wb-->sheet-->row-->cell-->data
			wb = new XSSFWorkbook(fs);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();

	}

	public static String getData(String sheetname, int row, int cell) {
		// file path
		File f1 = new File(System.getProperty("user.dir") + "//TestData//Data.xlsx");

		FileInputStream fs;
		// read
		try {
			fs = new FileInputStream(f1);
			wb = new XSSFWorkbook(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// read the data as per type
		XSSFCell cellvalue = wb.getSheet(sheetname).getRow(row).getCell(cell);
		// get the type of that cell that
		CellType celltype = cellvalue.getCellType();
		String data = null;

		switch (celltype) {
		case STRING:
			data = cellvalue.getStringCellValue();
			break;
		case NUMERIC:
			double d = cellvalue.getNumericCellValue();
			data = String.valueOf(d);
			break;
		case BOOLEAN:
			boolean b = cellvalue.getBooleanCellValue();
			data = String.valueOf(b);
			break;
		default:
			break;
		}

		return data;

	}

}