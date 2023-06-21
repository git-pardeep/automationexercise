package com.automationexercise.utilities;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentReports extent;
	public static ExtentSparkReporter sparkreporter;
	public static ExtentTest test;

	public static void setExtent() throws IOException {
		sparkreporter = new ExtentSparkReporter(
				new File(System.getProperty("user.dir") + "\\test-output\\ExtentReport\\MyReport.html"));
		sparkreporter.loadXMLConfig(System.getProperty("user.dir") + "\\extent-config.xml");
		sparkreporter.config().setDocumentTitle("Automation Exercise");
		sparkreporter.config().setReportName("AutomationExercise test Report");
		sparkreporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Project", "Automation Exercise");
		extent.setSystemInfo("Window", "OS11");
		extent.setSystemInfo("Tester Name", "Pardeep");

	}

	public static void endExtent() {
		extent.flush();
	}
}
