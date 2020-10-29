package main.java.com.metrobank.mobile.core.logger;

import java.io.File;
import java.io.IOException;







import main.java.com.metrobank.mobile.core.Report.ReportGeneration;
import main.java.com.metrobank.mobile.core.base.AutomationConstants;
import main.java.com.metrobank.mobile.core.base.Enums.LogType;
import main.java.com.metrobank.mobile.core.utilities.TestUtil;

import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.io.Files;



public class LogGeneration extends ReportGeneration{
	
	String tempResultFolder = "tempFolder";
  
	public void inputLogs(LogType type, String description, String screenshot) {

		switch (type) {
		case info:
			if(screenshot != null){
				try {
					test.log(Status.INFO, description, MediaEntityBuilder
							.createScreenCaptureFromBase64String(screenshot)
							.build());
					testSummary.log(Status.INFO, description, MediaEntityBuilder
							.createScreenCaptureFromBase64String(screenshot)
							.build());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}else{
				test.log(Status.INFO,
						MarkupHelper.createLabel(description, ExtentColor.BLUE));
				testSummary.log(Status.INFO,
						MarkupHelper.createLabel(description, ExtentColor.BLUE));
			}
			System.out.println(description);
			break;

		case pass:
			if(screenshot != null){
				try {
					test.log(Status.PASS, description, MediaEntityBuilder
							.createScreenCaptureFromBase64String(screenshot)
							.build());
					testSummary.log(Status.PASS, description, MediaEntityBuilder
							.createScreenCaptureFromBase64String(screenshot)
							.build());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}else{
				test.log(Status.PASS, MarkupHelper.createLabel(description, ExtentColor.GREEN));
				testSummary.log(Status.PASS, MarkupHelper.createLabel(description, ExtentColor.GREEN));
			}
			tempResultFolder = AutomationConstants.TEST_PASSED;
			System.out.println(description);
			break;

		case warning:
			test.log(Status.WARNING,
					MarkupHelper.createLabel(description, ExtentColor.ORANGE));
			testSummary.log(Status.WARNING,
					MarkupHelper.createLabel(description, ExtentColor.ORANGE));
			System.out.println(description);
			break;

		case fail:
			try {
				test.log(Status.FAIL, description, MediaEntityBuilder
						.createScreenCaptureFromBase64String(screenshot)
						.build());
				testSummary.log(Status.FAIL, description, MediaEntityBuilder
						.createScreenCaptureFromBase64String(screenshot)
						.build());
				System.out.println(description);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempResultFolder = AutomationConstants.TEST_FAILED;
			break;

		case fatal:
			try {
				test.log(Status.FATAL, description, MediaEntityBuilder
						.createScreenCaptureFromBase64String(screenshot)
						.build());
				testSummary.log(Status.FATAL, description, MediaEntityBuilder
						.createScreenCaptureFromBase64String(screenshot)
						.build());
				System.out.println(description);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tempResultFolder = AutomationConstants.TEST_FAILED;
			break;

		case skip:
			test.log(Status.SKIP,
					MarkupHelper.createLabel(description, ExtentColor.INDIGO));
			testSummary.log(Status.SKIP,
					MarkupHelper.createLabel(description, ExtentColor.INDIGO));
			System.out.println(description);
			break;

		default:
			System.out.println(AutomationConstants.FRAMEWORK_LOGS
					+ "Log Generations");

		}
}

	
	
	@AfterSuite
	public void extentFlush() throws IOException{
		String path = null;
		if(tempResultFolder != null || tempResultFolder == AutomationConstants.TEST_PASSED || tempResultFolder == AutomationConstants.TEST_FAILED){
			path = TestUtil.createResultFolder(tempResultFolder);
		}else{
			path = TestUtil.createNewFolderBaseDate();
		}
		extent.flush();
		extentSummary.flush();
		
		File testPath = new File(fileDirectory + fileNameData);
		File newPath = new File(path + fileNameData);

		if (tempResultFolder.equals(AutomationConstants.TEST_PASSED)) {
			Files.move(testPath, newPath);
		} else {
			try{
				Files.move(testPath, newPath);
			}catch(Exception e){
				path = TestUtil.createResultFolder("tempFolder");
				newPath = new File(path + fileNameData);	
				Files.move(testPath, newPath);
			}
		
		}
	}

}
