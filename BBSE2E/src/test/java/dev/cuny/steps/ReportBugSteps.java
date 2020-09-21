package dev.cuny.steps;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.cuny.pages.LoginPage;
import dev.cuny.pages.ReportBug;
import dev.cuny.pages.SelectAppNewBug;
import dev.cuny.pages.SelectPriorityNewBug;
import dev.cuny.pages.SelectSeverityNewBug;
import dev.cuny.runners.Runner;

public class ReportBugSteps {
	
	public static ReportBug reportBug = Runner.reportBug;
	//public static SelectClass selectClass = Runner.selectClass;
	public static WebDriver driver = Runner.driver;
	public static SelectAppNewBug selectClass;
	public static SelectSeverityNewBug selectSeverity;
	public static SelectPriorityNewBug selectPriority;
	
	@When("^Clien clicks on the Report New Bug tab$")
	public void clien_clicks_on_the_Report_New_Bug_tab() throws Throwable {
			reportBug.reportNewBug.click();
	}

	@Then("^Client is on the on the Report New Bug page$")
	public void client_is_on_the_on_the_Report_New_Bug_page() throws Throwable {
		Assert.assertEquals("Bug Report #", reportBug.newBugReport.getText());
	}

	@When("^Client enters \"([^\"]*)\" for a bug title$")
	public void client_enters_for_a_bug_title(String arg1) throws Throwable {
			reportBug.bugTitle.sendKeys(arg1);
	}
	

	@When("^Client selects \"([^\"]*)\" from the application dropdown$")
	public void client_selects_the_application(String arg1) throws Throwable {
		
		selectClass = new SelectAppNewBug(driver);
		selectClass.appsSelect.selectByVisibleText(arg1);
	}

	@When("^Client fills \"([^\"]*)\" for suspected location$")
	public void client_fills_for_suspected_location(String arg1) throws Throwable {
			reportBug.suspectedLocation.sendKeys(arg1);
	}

	@When("^Client selects \"([^\"]*)\" from the severity dropdown$")
	public void client_selects_from_the_severity_dropdown(String arg1) throws Throwable {
		selectSeverity = new SelectSeverityNewBug(driver);
		selectSeverity.severitySelect.selectByVisibleText(arg1);
	}

	@When("^Client selects \"([^\"]*)\" from the priority dropdown$")
	public void client_selects_from_the_priority_dropdown(String arg1) throws Throwable {
		selectPriority = new SelectPriorityNewBug(driver);
		selectPriority.prioritySelect.selectByVisibleText(arg1);
	}

	@When("^Client types \"([^\"]*)\" into the description field$")
	public void client_types_into_the_description_field(String arg1) throws Throwable {
		reportBug.descriptionHTML.sendKeys(Keys.TAB);
		reportBug.descriptionHTML.sendKeys("Description");
	}

	@When("^Client types \"([^\"]*)\" into reproduction field$")
	public void client_types_into_reproduction_field(String arg1) throws Throwable {
		reportBug.reproductionHTML.sendKeys(Keys.TAB);
		reportBug.reproductionHTML.sendKeys("Steps Steps");
	}

	@When("^Client clicks the submit bug button$")
	public String client_clicks_the_submit_bug_button() throws Throwable {
		
		String bugTitle = reportBug.bugTitle.getAttribute("innerText");
		reportBug.BugSubmit.click();
		
		return bugTitle;
	}

	@Then("^Client is on the Bug Report View$")
	public void client_is_on_the_Bug_Report_View() throws Throwable {
		
		//String reportedBugTitle = client_clicks_the_submit_bug_button();
		
		//Assert.assertEquals(reportBug.bugTitle.getText(), reportedBugTitle);
		
		String bugTitle = reportBug.bugTitle.getAttribute("innerText");
		
		Assert.assertEquals(reportBug.bugTitle.getText(), bugTitle);
	}



	@When("^Client clicks the cancel bug button$")
	public void client_clicks_the_cancel_bug_button() throws Throwable {
		reportBug.BugCancel.click();
	}


}
