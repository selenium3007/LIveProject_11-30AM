package com.durgasoft.selenium.testng.iostreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_API {
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String filePath;

	public Excel_API(String file) throws Exception {
		this.filePath = file;
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}

	// Reading cell data from excel by using column index
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);

			if (cell.getCellTypeEnum() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK) {
				return " ";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "No matching value";
		}
	}

	// Reading cell data from excel by using column Name
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			int colNum = -1;
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
					colNum = i;
				}
			}
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell.getCellTypeEnum() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK) {
				return " ";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "No matching value";
		}
	}

	// Writing cell data to excel by using column index
	public boolean setCellData(String sheetName, int colNum, int rowNum, String value) throws Exception {
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			if (row == null)
				row = sheet.createRow(rowNum);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(value);
			fos = new FileOutputStream(filePath);
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Writing cell data to excel by using column Name
	public boolean setCellData(String sheetName, String colName, int rowNum, String value) throws Exception {
		try {
			int colNum = -1;
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
					colNum = i;
				}
			}
			row = sheet.getRow(rowNum);
			if (row == null)
				row = sheet.createRow(rowNum);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(value);
			fos = new FileOutputStream(filePath);
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Identify no.of rows and no.of columns in excel file
	public int getRows(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() + 1;
		return rowCount;
	}

	public int getColumns(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		return columnCount;
	}
}
