package testautomationframework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendManager {
	
	ThreadLocal<ExtentReports> report = new ThreadLocal<ExtentReports>();
	ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	ThreadLocal<ExtentHtmlReporter> extentHtmlReporter = new ThreadLocal<ExtentHtmlReporter>();
	
	public ExtentReports getReport() {
		return report.get();
	}

	public ExtentTest getTest() {
		return test.get();
	}

	public ExtentHtmlReporter getExtentHtmlReporter() {
		return extentHtmlReporter.get();
	}

}
