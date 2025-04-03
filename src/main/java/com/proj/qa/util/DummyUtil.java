//public class DummyUtil {
//	
//		public static String sheetFilePath = "C:\\Users\\admin\\eclipse-workspace\\MavenTest\\src\\main\\java\\com\\proj\\qa\\testdata\\FreeCRMTestData.xlsx";
//		Workbook book;
//		Sheet sheet;
//		
//		public Object[][] getTestData(String sheetName) throws InvalidFormatException {
//			FileInputStream file = null;
//			
//			try {
//				file = new FileInputStream(sheetFilePath);
//				book = WorkbookFactory.create(file);
//				sheet = book.getSheet(sheetName);
//			}
//			catch(FileNotFoundException e) {
//				e.printStackTrace();
//			}
//			catch(IOException e) {
//				e.printStackTrace();
//				}
//			
//			sheet = book.getSheet(sheetName);
//			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//			for (int i=0; i<sheet.getLastRowNum(); i++) {
//				for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
//					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
//				}
//			}
//			return data;
//		}
//	}

//<dependency>
//    <groupId>com.relevantcodes</groupId>  
//    <artifactId>extentreports</artifactId>
//    <version>2.41.2</version>
//</dependency>

/*	//com.relevantcodes
	import java.io.File;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.List;
	import java.util.Map;

	import org.testng.IReporter;
	import org.testng.IResultMap;
	import org.testng.ISuite;
	import org.testng.ISuiteResult;
	import org.testng.ITestContext;
	import org.testng.ITestResult;
	import org.testng.xml.XmlSuite;

	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	public class ExtentReporterNG implements IReporter {
		private ExtentReports extent;

		public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
				String outputDirectory) {
			extent = new ExtentReports(outputDirectory + File.separator
					+ "Extent.html", true);

			for (ISuite suite : suites) {
				Map<String, ISuiteResult> result = suite.getResults();

				for (ISuiteResult r : result.values()) {
					ITestContext context = r.getTestContext();

					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
					buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
					buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
				}
			}

			extent.flush();
			extent.close();
		}

		private void buildTestNodes(IResultMap tests, LogStatus status) {
			ExtentTest test;

			if (tests.size() > 0) {
				for (ITestResult result : tests.getAllResults()) {
					test = extent.startTest(result.getMethod().getMethodName());

					test.setStartedTime(getTime(result.getStartMillis()));
					test.setEndedTime(getTime(result.getEndMillis()));

					for (String group : result.getMethod().getGroups())
						test.assignCategory(group);

					if (result.getThrowable() != null) {
						test.log(status, result.getThrowable());
					} else {
						test.log(status, "Test " + status.toString().toLowerCase()
								+ "ed");
					}

					extent.endTest(test);
				}
			}
		}

		private Date getTime(long millis) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(millis);
			return calendar.getTime();
		}  
	} */
