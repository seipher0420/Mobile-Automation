package main.java.com.metrobank.mobile.core.Report;




import main.java.com.metrobank.mobile.core.utilities.GetData;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class ReportGeneration {


	public static ExtentHtmlReporter htmlReporter;
	public static ExtentHtmlReporter htmlReporterSummary;
	public static String fileNameData;
	public static String fileDirectory;

	public static ExtentReports extent;
	public static ExtentReports extentSummary;
	public static ExtentTest test;
	public static ExtentTest testSummary;
	
	@BeforeSuite
	public static synchronized ExtentReports GetExtent() {
		if (extentSummary != null) {
			return extentSummary;
		} else {
			return extentSummary = new ExtentReports();
		}
	}

	@BeforeClass
	public void generateReport(String reportName) {

		GetData data = new GetData();
		data.setFileName(reportName + ".html");
		data.setFileDirectory(TestUtil.createNewFolderBaseDate());
		htmlReporter = new ExtentHtmlReporter(data.getFileDirectory()
				+ data.getFileName());
		fileNameData = data.getFileName();
		fileDirectory = data.getFileDirectory();
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setReportName(reportName);
		htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
		htmlReporter.config().setTheme(Theme.STANDARD);

		htmlReporter.config().setTimeStampFormat(
				"EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		test = extent.createTest(reportName);
		generateTestSummary(reportName);
	}	
	
	@BeforeSuite
	public void generateTestSummary(String reportName){
		String text = TestUtil.createNewFolderBaseDate();
		htmlReporterSummary = new ExtentHtmlReporter(text + "ReportSummary.html");
		GetExtent();
		extentSummary.attachReporter(htmlReporterSummary);
		htmlReporterSummary.config().setReportName(reportName);
		htmlReporterSummary.config().setTheme(Theme.STANDARD);
		htmlReporterSummary.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
		htmlReporterSummary.config().setTimeStampFormat(
				"EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		testSummary = extentSummary.createTest(reportName);
		
	}
}
