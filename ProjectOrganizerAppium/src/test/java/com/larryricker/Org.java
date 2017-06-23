/**
 * 
 */
package com.larryricker;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestReporter;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * @author lawrencericker
 *
 */
public class Org {
	private static final Logger LOGGER = Logger.getLogger(Org.class.getName());

	/**
	 * Clicks on settings button at the bottom of the page
	 * @throws MalformedURLException
	 */
	static void gotoSettingsTableView() throws MalformedURLException {
		App.click("Settings");
	}

	/**
	 * exit settings tab
	 * @throws MalformedURLException
	 */
	public static void exitSettingsTableView() throws MalformedURLException {
		App.click("Project");
	}

	/**
	 * get the bundle ID for the app being tested
	 * @return
	 * @throws IOException 
	 * @throws WebDriverException 
	 */
	public static String getBundleId(TestReporter testReporter) throws WebDriverException, IOException {
		Org.gotoSettingsTableView();
		App.snapAnyway("SettingsScreen", testReporter);
		String bundleId = "";
		WebElement bi = null;
		String using = "LR.Progress-Report";
		if (App.exists(using)) {
			bundleId = using;
		}
		using = "LR.Progress-Report-Pro";
		if (App.exists(using)) {
			bundleId = using;
		}
		exitSettingsTableView();
		LOGGER.log(Level.INFO, "getBundleId() - bundleId->" + bundleId);

		return bundleId;
	}

	/**
	 * Share app by email
	 * @throws MalformedURLException
	 */
	public static void shareAppFromSettingsTableView() throws MalformedURLException {
		// share app
		App.click("Share");
		// toField - enter text
		WebElement to = App.find("toField");
		to.sendKeys("larry@larryricker.com");
		// send email
		App.click("Send");
	}

	/**
	 * Creates a new project
	 * @param projectName
	 * @throws IOException 
	 * @throws WebDriverException 
	 * @throws InterruptedException 
	 */
	public static void createNewProject(String projectName, TestReporter testReporter) throws WebDriverException, IOException, InterruptedException {
		App.click("Add");

		if (App.exists("Continue")) {
			// Search
//			App.click("Search");
//			App.click("Cancel");
			// Unlimited Projects
			// Share All Projects
			// Backup All Projects
			// No Advertising
			// Continue
			App.click("Continue");
		}
		else {
			// projectNameEdit
//			App.waitForAccessibilityId("projectNameEdit");
			App.waitForScreenToLoad("projectNameEdit", 10);
			App.snapAnyway("NewProjectNameView", testReporter);			// name project
			App.enterText("projectNameEdit", projectName);
			// click on done button
			App.click("Done");
		}
	}

	/**
	 * verify settings upsell message
	 * @throws MalformedURLException
	 */
	public static void verifySettingsUpsellMessage() throws MalformedURLException {
		WebElement upsell = App.find("Buy Progress Report Pro 4.99");
		Assertions.assertEquals(upsell.getText(), upsell.getText(), "Upsell message is correct");
	}

	/**
	 * add status report
	 * @param statusReportName
	 * @throws MalformedURLException
	 */
	public static void addStatusReport(String statusReportName) throws MalformedURLException {
		// create a new status report
		App.click("Add");
		// statusToAdd
		App.enterText("statusToAdd", statusReportName);
		// save status
		App.click("Done");
	}

	/**
	 * add test case
	 * @param statusReportTitle
	 * @param answer
	 * @throws MalformedURLException
	 */
	public static void addTestCase(String statusReportTitle, String answer) throws MalformedURLException {
		App.click("Add");
		App.enterText("statusReportTitle", statusReportTitle);
		App.enterText("questionTextField", "What is the test case?");
		App.focus("answerTextField");
		App.enterText("answerTextField", answer);
		App.click("Done");
	}

}