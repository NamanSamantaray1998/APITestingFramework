package apiTestingFrameWork.UtilitiesStripeAPI;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import apiTestingFrameWork.SetUpStripeAPI.BaseTest;

//call directly this class to create customer test data provider
public class DataUtil extends BaseTest {

	@DataProvider(name = "Data", parallel = true)
	// To get the method name we used method from java lang reflection method

	public Object[][] getData(Method m) {
		// m.getName() it will give the method name where ever this data provider is called
		//System.out.println("Sheet Name is " + m.getName());
		//String sheetName = m.getName();
		String property = config.getProperty("testDataSheetName");
		int rows = excel.getRowCount(property);
		System.out.println("Total rows are : " + rows);
		String testName = m.getName();
		System.out.println("Test name is : "+testName);
		
		// find the test case start row
		
		int testCaseRowNum = 1;
		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {
			String testCaseName = excel.getCellData(config.getProperty("testDataSheetName"), 0, testCaseRowNum);
			if (testCaseName.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("Test case starts from row num " + testCaseRowNum);
		

		// checking total data rows in test case
		
		int dataStartRowNum = testCaseRowNum + 2;
		int testDataRows = 0;
		while (!excel.getCellData(config.getProperty("testDataSheetName"), 0, dataStartRowNum + testDataRows).equals("")) {
			testDataRows++;
		}
		System.out.println("total rows of data are"+testDataRows);
		
		
		// checking total data columns in test case
		
		int columnStartColumnNum = testCaseRowNum + 1;
		int testDataColumns = 0;
		while (!excel.getCellData(config.getProperty("testDataSheetName"), testDataColumns, columnStartColumnNum).equals("")) {
			testDataColumns++;
		}
		System.out.println("Total columns of data are" + testDataColumns);

		
		// printing the data
		Object[][] data = new Object[testDataRows][1];
		// pass data with hard coding
//		data[0][0]=excel.getCellData(sheetName, 0,2 ); 
//		data[0][1]=excel.getCellData(sheetName, 1,2 ); 
//		data[0][2]=excel.getCellData(sheetName, 2,2 ); 

		int i=0;
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum + testDataRows; rNum++) {
			
			Hashtable<String, String> table = new Hashtable<String, String>();

			for (int cNum = 0; cNum < testDataColumns; cNum++) {
				System.out.println(excel.getCellData(config.getProperty("testDataSheetName"), cNum, rNum));
				
				String testData=excel.getCellData(config.getProperty("testDataSheetName"), cNum, rNum);
				String colName=excel.getCellData(config.getProperty("testDataSheetName"), cNum, columnStartColumnNum);
				
				table.put(colName, testData);	
			}
			data[i][0]= table;
			i++;

		}
		return data;
		
		
		// pass data with loop
//		for (int rowNum = 2; rowNum <= rows; rowNum++) {
//			// (colNum<cols) because col count is 3 but we start from 0
//			for (int colNum = 0; colNum < cols; colNum++) {
//				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
//			}
//		}
//		

	}
}
