package dataProviderPackage;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import basepackage.Base;
import utility.ExcelLibrary;

public class DataFactory extends Base {
	
ExcelLibrary excel = new ExcelLibrary();


@DataProvider(name = "TestDataScenario01")
public  Object[][] testData01() {
	// Totals rows count
	int rows = excel.getRowCount("TestDataScenario01");
	// Total Columns
	int column = excel.getColumnCount("TestDataScenario01");
	int actRows = rows - 1;

	Object[][] data = new Object[actRows][column];

	for (int i = 0; i < actRows; i++) {
		for (int j = 0; j < column; j++) {
			data[i][j] = excel.getCellData("TestDataScenario01", j, i + 2);
		}
	}
	return data;
}
@DataProvider(name = "TestDataScenario02")
public  Object[][] testData02() {
	// Totals rows count
	int rows = excel.getRowCount("TestDataScenario02");
	// Total Columns
	int column = excel.getColumnCount("TestDataScenario02");
	int actRows = rows - 1;

	Object[][] data = new Object[actRows][column];

	for (int i = 0; i < actRows; i++) {
		for (int j = 0; j < column; j++) {
			data[i][j] = excel.getCellData("TestDataScenario02", j, i + 2);
		}
	}
	return data;
}


@DataProvider(name = "TestDataScenario03")
public  Object[][] testData03() {
	// Totals rows count
	int rows = excel.getRowCount("TestDataScenario03");
	// Total Columns
	int column = excel.getColumnCount("TestDataScenario03");
	int actRows = rows - 1;

	Object[][] data = new Object[actRows][column];

	for (int i = 0; i < actRows; i++) {
		for (int j = 0; j < column; j++) {
			data[i][j] = excel.getCellData("TestDataScenario03", j, i + 2);
		}
	}
	return data;
}

}
