package dev.cuny.steps;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.cuny.pages.BugReportPage;
import dev.cuny.pages.MainPage;
import dev.cuny.pages.ViewBugsPage;
import dev.cuny.runners.Runner;

public class ViewAndResolveBugsSteps {

	public static MainPage mainPage = Runner.mainPage;
	public static BugReportPage bugReportPage = Runner.bugReportPage;
	public static ViewBugsPage viewBugsPage = Runner.viewBugsPage;
	public static WebDriver driver = Runner.driver;
	
	@When("^Client clicks on an application$")
	public void client_clicks_on_an_application() throws Throwable {
		mainPage.firstApplication.click();
	}

	@Then("^The application's bugs are shown$")
	public void the_application_s_bugs_are_shown() throws Throwable {
		Assert.assertTrue(mainPage.bugReportLink.isDisplayed());
	}

	@When("^Client clicks on the application$")
	public void client_clicks_on_the_application() throws Throwable {
	    mainPage.firstApplication.click();
	}

	@Then("^The application's bugs are not shown$")
	public void the_application_s_bugs_are_not_shown() throws Throwable {
		try {
			Assert.assertFalse(mainPage.bugReportLink.isDisplayed());
		} catch(NoSuchElementException e) {
			Assert.assertTrue(e.getMessage().contains("no such element"));
		}
	}
	
	@When("^Client clicks on a bug link$")
	public void client_clicks_on_a_bug_link() throws Throwable {
	    mainPage.bugReportLink.click();
	}

	@Then("^The Bug's page is shown$")
	public void the_Bug_s_page_is_shown() throws Throwable {
	    Assert.assertTrue(bugReportPage.bugReportTitle.isDisplayed());
	}

	@When("^Client enters \"([^\"]*)\" into the title input$")
	public void client_enters_into_the_title_input(String arg1) throws Throwable {
		bugReportPage.solutionTitle.sendKeys(arg1);
	}

	@When("^Client enters \"([^\"]*)\" into the solution input$")
	public void client_enters_into_the_solution_input(String arg1) throws Throwable {
		bugReportPage.solutionDescription.sendKeys(arg1);
	}

	@When("^Client clicks the submit button$")
	public void client_clicks_the_submit_button() throws Throwable {
		bugReportPage.submitButton.click();
	}

	@Then("^The solution is added under Posted Solution\\(s\\)$")
	public void the_solution_is_added_under_Posted_Solution_s() throws Throwable {
		bugReportPage.solutionDescription.clear();
		bugReportPage.solutionTitle.clear();
	    Assert.assertTrue(driver.getPageSource().contains("This is a great solution"));
	}
	
	@When("^Client clicks the cancel button$")
	public void client_clicks_the_cancel_button() throws Throwable {
		bugReportPage.cancelButton.click();
	}

	@Then("^The title input is cleared$")
	public void the_title_input_is_cleared() throws Throwable {
	    Assert.assertEquals("", bugReportPage.solutionTitle.getText());
	}

	@Then("^The solution input is cleared$")
	public void the_solution_input_is_cleared() throws Throwable {
		Assert.assertEquals(" ", bugReportPage.solutionDescription.getText());
	}
	
	@When("^Client clicks on view bugs button$")
	public void client_clicks_on_view_bugs_button() throws Throwable {
	    mainPage.viewBugsButton.click();
	}

	@Then("^Client should be on view bugs page$")
	public void client_should_be_on_view_bugs_page() throws Throwable {
	    Assert.assertTrue(viewBugsPage.toggleButton.isDisplayed());
	}

	@When("^Client clicks on unresolved bugs button$")
	public void client_clicks_on_unresolved_bugs_button() throws Throwable {
	    viewBugsPage.unresolvedBugsButton.click();
	}
	
	@When("^Client clicks the mark as resolved button$")
	public void client_clicks_the_mark_as_resolved_button() throws Throwable {
		bugReportPage.resolveBugButton.click();
	}

	@Then("^status should be set to resolved$")
	public void status_should_be_set_to_resolved() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(bugReportPage.bugStatus, "Resolved"));
	    Assert.assertEquals("Resolved", bugReportPage.bugStatus.getText());
	}
	
	@When("^Client clicks on the return to view bugs button$")
	public void client_clicks_on_the_return_to_view_bugs_button() throws Throwable {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", bugReportPage.returnToViewBugsButton);
	}
}
