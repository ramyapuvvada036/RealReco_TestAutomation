package com.realreco.automation.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	public static DataFormatter formatter = new DataFormatter();

	public static HashMap<String, HashMap<String, String>> readData(String excelsheetName)
			throws InvalidFormatException, IOException {

		System.out.println("****************************  Inside Excel Reader");
		System.out.println("*******************   Sheet  Name = " + excelsheetName);

		File file = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\realreco\\automation\\testdata\\TestData_HashMap.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(excelsheetName);
		// int maxRowCount = 20;
		int emptyLineCnt = 0;

		// Store each test case name as key and value as hashmap of field and values
		HashMap<String, HashMap<String, String>> testDataMap = new HashMap<String, HashMap<String, String>>();

		int colIdx = 0;
		HashMap<String, String> testCaseDataMap = null;
		for (int i = 0; true; i++) {
			XSSFRow row = sh.getRow(i);
			System.out.println("**** " + i);

			// Skip the empty row if there 10 or more empty lines
			if (row == null || row.getCell(1) == null || row.getCell(1).getStringCellValue().trim().equals("")) {
				emptyLineCnt++;
				if (emptyLineCnt == 10) {
					break;
				}
				continue;
			}

			emptyLineCnt = 0;
			// Current row will have field names
			XSSFRow fieldRow = row;
			// Next row should be values
			XSSFRow valueRow = sh.getRow(i + 1);

			// Skip the value row next time
			i = i + 1;

			String testcaseName = fieldRow.getCell(1).getStringCellValue();

			System.out.println(testcaseName);
			// Key will be field name.
			testCaseDataMap = new HashMap<String, String>();
			// To read the values after test case name
			colIdx = 2;

			while (true) {

				XSSFCell fieldCell = fieldRow.getCell(colIdx);

				// Read until field name is null
				if (fieldCell == null || fieldCell.getStringCellValue() == null
						|| fieldCell.getStringCellValue().trim().isEmpty()) {
					break;
				} else {

					// Read the value for the corresponding field
					XSSFCell valueCell = valueRow.getCell(colIdx);
					String value = null;
					if (valueCell == null || valueCell.getRawValue() == null
							|| valueCell.getRawValue().trim().isEmpty()) {
						value = null;
					} else {
						// value = valueCell.toString();
						value = formatter.formatCellValue(valueCell);
					}
					// Store the field name and corresponding value
					testCaseDataMap.put(fieldCell.getStringCellValue().trim(), value);
					System.out.println(fieldCell.getStringCellValue().trim() + " ======== " + value);

				}
				colIdx++;
			}
			// Store the field and value map for each test case
			testDataMap.put(testcaseName, testCaseDataMap);

		}
		return testDataMap;
	}

	public static String getNullData(HashMap<String, String> testcaseData, String field) throws Exception {
		String val = null;
		try {
			if (testcaseData.containsKey(field)) {
				val = testcaseData.get(field);
				if (val == null) {
					val = "";
				}
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception("Test Data for field " + field + " may not be present");
		}
		return val;
	}

	public static String getData(HashMap<String, String> testcaseData, String field) throws Exception {
		String val = null;
		try {
			if (testcaseData.containsKey(field)) {
				val = testcaseData.get(field);
				if (val == null) {
					throw new Exception();
				}
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception("Test Data for field " + field + " may not be present");
		}
		return val;
	}
}