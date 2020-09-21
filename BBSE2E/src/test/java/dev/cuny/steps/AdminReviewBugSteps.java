package dev.cuny.steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.cuny.pages.BugReportPage;
import dev.cuny.pages.ViewBugsPage;
import dev.cuny.runners.Runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class AdminReviewBugSteps {

	public static BugReportPage bugReportPage = Runner.bugReportPage;
	public static ViewBugsPage viewBugsPage = Runner.viewBugsPage;
	public static WebDriver driver = Runner.driver;

	@When("^Client updates priority with \"([^\"]*)\"$")
	public void client_updates_priority_with(String arg1) throws Throwable {
		Select priority = new Select(bugReportPage.prioritySelect);
		priority.selectByValue(arg1);
	}

	@When("^Client updates severity with \"([^\"]*)\"$")
	public void client_updates_severity_with(String arg1) throws Throwable {
		Select severity = new Select(bugReportPage.severitySelect);
		severity.selectByValue(arg1);
	}

	@When("^Client updates points with \"([^\"]*)\"$")
	public void client_updates_points_with(String arg1) throws Throwable {
		bugReportPage.pointsInput.clear();
	    bugReportPage.pointsInput.sendKeys(arg1);
	}

	@When("^Client clicks on the approve button$")
	public void client_clicks_on_the_approve_button() throws Throwable {
	    bugReportPage.approveButton.click();
	}

	@Then("^status should be set to unresolved$")
	public void status_should_be_set_to_unresolved() throws Throwable {
	    Assert.assertEquals("Unresolved", bugReportPage.bugStatus.getText());
	}

	@Then("^priority should be \"([^\"]*)\"$")
	public void priority_should_be(String arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(bugReportPage.prioritySelect, arg1));
		Select priority = new Select(bugReportPage.prioritySelect);
		Assert.assertEquals(arg1, priority.getFirstSelectedOption().getText());
	}

	@Then("^severity should be \"([^\"]*)\"$")
	public void severity_should_be(String arg1) throws Throwable {
		Select severity = new Select(bugReportPage.severitySelect);
		Assert.assertEquals(arg1, severity.getFirstSelectedOption().getText());
	}

	@Then("^points should be \"([^\"]*)\"$")
	public void points_should_be(String arg1) throws Throwable {
		Assert.assertEquals(arg1, bugReportPage.pointsInput.getAttribute("ng-reflect-model"));
	}

	@When("^Client clicks on the reject button$")
	public void client_clicks_on_the_reject_button() throws Throwable {
	    bugReportPage.rejectButton.click();
	}

	@Then("^status should be set to Denied$")
	public void status_should_be_set_to_Denied() throws Throwable {
		Assert.assertEquals("Denied", bugReportPage.bugStatus.getText());
	}
	
	@When("^Client clicks on requested bugs tab$")
	public void client_clicks_on_requested_bugs_tab() throws Throwable {
		viewBugsPage.requestedBugsButton.click();
	}
}
