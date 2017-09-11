/**
 * Copyright (c) 2017 Larry Ricker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package com.larryricker;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestReporter;
import org.openqa.selenium.SessionNotCreatedException;
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
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws WebDriverException
	 */
	static void gotoSettingsTableView(TestReporter testReporter)
			throws InterruptedException, WebDriverException, IOException {
		handleRateMeReminder(testReporter);
		returnToProjectMainScreen();
		App.click("Settings");
		App.waitForAccessibilityId("Project");
	}

	private static void handleRateMeReminder(TestReporter testReporter)
			throws MalformedURLException, IOException, InterruptedException {
		if (App.exists("Remind me later")) {
			App.snapAnyway("RemindMeLater", testReporter);
			App.click("Remind me later");
		}
		if (App.exists("OK")) {
			App.snapAnyway("NoMailAccounts", testReporter);
			App.click("OK");
		}
	}

	public static void returnToProjectMainScreen() throws MalformedURLException, InterruptedException {
		exitQuestionsScreen();
		exitQuestionsSelection();
		exitStatusSelection();
	}

	public static void exitStatusSelection() throws MalformedURLException, InterruptedException {
		if (App.exists("Project")) {
			App.click("Project");
			App.waitForAccessibilityId("Edit");
		}
	}

	public static void exitQuestionsSelection() throws MalformedURLException, InterruptedException {
		if (App.exists("Defects")) {
			App.click("Defects");
			App.waitForAccessibilityId("Edit");
		}
	}

	public static void exitQuestionsScreen() throws MalformedURLException, InterruptedException {
		if (App.exists("Back")) {
			App.click("Back");
			App.waitForAccessibilityId("Edit");
		}
	}

	/**
	 * exit settings tab
	 * 
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	public static void exitSettingsTableView() throws MalformedURLException, InterruptedException {
		App.click("Project");
	}

	/**
	 * get the bundle ID for the app being tested
	 * 
	 * @return
	 * @throws IOException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public static String getBundleId(TestReporter testReporter)
			throws WebDriverException, IOException, InterruptedException {
		Org.gotoSettingsTableView(testReporter);
		App.snapAnyway("SettingsScreen", testReporter);
		String bundleId = "";
		bundleId = isThisTheBundleId(bundleId, "LR.Progress-Report");
		bundleId = isThisTheBundleId(bundleId, "LR.Progress-Report-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.PMIS2");
		bundleId = isThisTheBundleId(bundleId, "LR.PMIS-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Project-Organizer");
		bundleId = isThisTheBundleId(bundleId, "LR.Project-Organizer-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Project-Status");
		bundleId = isThisTheBundleId(bundleId, "LR.Project-Status-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Project-Info");
		bundleId = isThisTheBundleId(bundleId, "LR.Project-Info-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Bad-With-Names");
		bundleId = isThisTheBundleId(bundleId, "LR.Bad-With-Names-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Good-With-Names");
		bundleId = isThisTheBundleId(bundleId, "LR.Good-With-Names-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.StatusReport4");
		bundleId = isThisTheBundleId(bundleId, "LR.StatusReport4-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Student-Organizer");
		bundleId = isThisTheBundleId(bundleId, "LR.Student-Organizer-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Job-Hunt");
		bundleId = isThisTheBundleId(bundleId, "LR.Job-Hunt-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Opportunity-Organizer");
		bundleId = isThisTheBundleId(bundleId, "LR.Opportunity-Organizer-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Passing-Notes");
		bundleId = isThisTheBundleId(bundleId, "LR.Passing-Notes-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Class-Organizer");
		bundleId = isThisTheBundleId(bundleId, "LR.Class-Organizer-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Notes-Organizer");
		bundleId = isThisTheBundleId(bundleId, "LR.Notes-Organizer-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Career-Search");
		bundleId = isThisTheBundleId(bundleId, "LR.Career-Search-Pro");
		bundleId = isThisTheBundleId(bundleId, "LR.Curriculum-Organizer");
		bundleId = isThisTheBundleId(bundleId, "LR.Curriculum-Organizer-Pro");
		exitSettingsTableView();
		LOGGER.log(Level.INFO, "getBundleId() - bundleId->" + bundleId);
		return bundleId;
	}

	private static String isThisTheBundleId(String bundleId, String using) throws MalformedURLException {
		// LOGGER.info("bundleId bundleId-> " + bundleId + ", using->" + using);
		if ("".equals(bundleId) && App.exists(using)) {
			bundleId = using;
		}
		return bundleId;
	}

	/**
	 * Share app by email
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws WebDriverException
	 */
	public static void shareAppFromSettingsTableView(TestReporter testReporter)
			throws InterruptedException, WebDriverException, IOException {
		// share app
		App.click("Share");
		App.waitForAccessibilityId("toField");
		// toField - enter text
		WebElement to = App.find("toField");
		// to.clear();
		to.sendKeys("larry@larryricker.com");
		// handle double entry issue
		int count = 0;
		while ("larry@larryricker.comlarry@larryricker.com".equals(App.find("toField").getText()) && count < 10) {
			count++;
			LOGGER.info("shareAppFromSettingsTableView() fixing email " + count);
			App.clear("toField");
			App.enterText("toField", "larry@larryricker.com");
		}
		App.snapAnyway("ShareApplication", testReporter);
		if (count >= 10) {// send email
			App.click("Cancel");
		} else {
			App.click("Send");
		}
	}

	/**
	 * Creates a new project
	 * 
	 * @param projectName
	 * @throws IOException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public static void createNewProject(String projectName, TestReporter testReporter)
			throws WebDriverException, IOException, InterruptedException {
		// App.click("Add");
		// Thread.sleep(10000);
		// App.clickUntilOneOfTwoElementsPresent("Add", "Undo", "Continue");
		App.waitThenClickUntilOneOfTwoElementsPresent("Add", "Undo", "Continue");
		// App.clickWhileStillExists("Add");
		if (App.exists("Continue")) {
			// Search
			// App.click("Search");
			// App.click("Cancel");
			// Unlimited Projects
			// Share All Projects
			// Backup All Projects
			// No Advertising
			// Continue
			App.click("Continue");
			Thread.sleep(10000);
		} else {
			// projectNameEdit
			App.waitForAccessibilityId("projectNameEdit");
			App.enterText("projectNameEdit", projectName);
			App.snapAnyway("NewProjectNameView", testReporter); // name project
			// click on done button
			App.click("Done");
			// Thread.sleep(10000);
			App.waitThenClickUntilOneElementPresent("Done", "Add");
		}
	}

	private static void verifyUpsellMessage(String using) throws MalformedURLException {
		WebElement upsell;
		upsell = App.find(using);
		if (upsell != null) {
			Assertions.assertEquals(upsell.getText(), using, "Upsell message is correct");
		}
	}

	/**
	 * add status report
	 * 
	 * @param statusReportName
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws WebDriverException
	 */
	public static void addStatusReport(String statusReportName, TestReporter testReporter)
			throws InterruptedException, WebDriverException, IOException {
		// create a new status report
		App.click("Add");
		// statusToAdd
		App.enterText("statusToAdd", statusReportName);
		App.snapAnyway("AddStatusReport", testReporter);
		// save status
		App.click("Done");
	}

	/**
	 * add test case
	 * 
	 * @param statusReportTitle
	 * @param answer
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	public static void addTestCase(String statusReportTitle, String answer)
			throws MalformedURLException, InterruptedException {
		App.click("Add");
		// handle prompt for Reminders and Calendar access
		if (App.exists("OK")) {
			App.clickWhileStillExists("OK");
		}
		if (App.exists("OK")) {
			App.clickWhileStillExists("OK");
		}
		App.enterText("statusReportTitle", statusReportTitle);
		String using = "questionTextField";
		App.clear(using);
		App.enterText(using, "What is the test case?");
		App.focus("answerTextField");
		App.enterText("answerTextField", answer);
		App.click("Done");
	}

	/**
	 * delete all rows of the tableview
	 * 
	 * @param bundleId
	 * @return
	 */
	public static boolean isProVersion(String bundleId) {
		return bundleId.equals("LR.Progress-Report-Pro") || bundleId.equals("LR.StatusReport4-Pro")
				|| bundleId.equals("LR.Project-Organizer-Pro") || bundleId.equals("LR.Project-Status-Pro")
				|| bundleId.equals("LR.Project-Info-Pro") || bundleId.equals("LR.PMIS-Pro")
				|| bundleId.equals("LR.Good-With-Names-Pro") || bundleId.equals("LR.Bad-With-Names-Pro")
				|| bundleId.equals("LR.Student-Organizer-Pro") || bundleId.equals("LR.Class-Organizer-Pro")
				|| bundleId.equals("LR.Passing-Notes-Pro") || bundleId.equals("LR.Job-Hunt-Pro")
				|| bundleId.equals("LR.Opportunity-Organizer-Pro");
	}

	/**
	 * verify settings upsell message
	 * 
	 * @throws MalformedURLException
	 */
	public static void verifySettingsUpsellMessage() throws MalformedURLException {
		verifyUpsellMessage("Buy PMIS Pro 4.99");
		verifyUpsellMessage("Buy Progress Report Pro 4.99");
		verifyUpsellMessage("Buy Project Organizer Pro 4.99");
		verifyUpsellMessage("Buy Project Status Pro 4.99");
		verifyUpsellMessage("Buy StatusReport4 Pro 3.99");
		verifyUpsellMessage("Buy Project Info Pro 4.99");
		verifyUpsellMessage("Buy Bad With Names Pro 0.99");
		verifyUpsellMessage("Buy Good With Names Pro 0.99");
		verifyUpsellMessage("Buy Student Organizer Pro 0.99");
		verifyUpsellMessage("Buy Passing Notes Pro 4.99");
		verifyUpsellMessage("Buy Job Hunt Pro 1.99");
		verifyUpsellMessage("Buy Opportunity Organizer Pro 2.99");
		verifyUpsellMessage("Buy Class Organizer Pro 0.99");
	}

	/**
	 * delete all table view rows
	 * 
	 * @param deleteButtonName
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public static void deleteAllTableViewRows(String deleteButtonName, TestReporter testReporter)
			throws InterruptedException, IOException {
		Org.handleRateMeReminder(testReporter);
		List<WebElement> dashes = null;
		int numberOfDashes = 0;
		do {
			// click on -
			// dash = App.find("-");
			Org.editMode();
			dashes = Driver.getDriver().findElementsByAccessibilityId(deleteButtonName);
			numberOfDashes = dashes.size();
			LOGGER.info("Number of " + deleteButtonName + " Dash Buttons found->" + numberOfDashes);
			for (int i = (numberOfDashes > 4 ? 4 : numberOfDashes); --i >= 0;) {
				WebElement dash = dashes.get(i);
				if (dash.isDisplayed()) {
					dash.click();
					App.click("Delete");
				}
			}
		} while (numberOfDashes > 0 && dashes.isEmpty() == false && dashes.get(0).isDisplayed());
	}

	/**
	 * edit mode of table view
	 * 
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	public static void editMode() throws MalformedURLException, InterruptedException {
		if (App.exists("Edit")) {
			App.click("Edit");
		}
	}

	/**
	 * exit edit mode of table view and return to selection mode
	 * 
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	public static void exitEditMode() throws MalformedURLException, InterruptedException {
		if (App.exists("Done")) {
			App.click("Done");
		} else if (App.exists("Edit")) {
			editMode();
		}
	}

}
