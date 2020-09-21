package dev.cuny.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.cuny.pages.BugReportPage;
import dev.cuny.pages.ViewBugsPage;
import dev.cuny.runners.Runner;

public class AdminMarkBugAsResolved {
	
	public static ViewBugsPage viewBugsPage = Runner.viewBugsPage;
	public static BugReportPage bugReportPage = Runner.bugReportPage;
	public static WebDriver driver = Runner.driver;
	
	@When("^Admin clicks on view bugs button$")
	public void admin_clicks_on_view_bugs_button() throws Throwable {
		viewBugsPage.viewBugsTab.click();
	}

	@When("^Admin clicks on an unresolved bug tab$")
	public void admin_clicks_on_an_unresolved_bug_tab() throws Throwable {
		viewBugsPage.unresolvedBugsButton.click();
	}

	@When("^Admin clicks the inspect button$")
	public void admin_clicks_the_inspect_button() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		WebElement field = driver.findElement(By.linkText("Inspect"));
	    try {
			wait.until(ExpectedConditions.stalenessOf(field));
		    field  = driver.findElement(By.linkText("Inspect"));
		    field.click();
	    } catch (TimeoutException e) {
		    field.click();
	    }	 
	}

	@Then("^Admin is on to the Bug Report Details page$")
	public void admin_is_on_to_the_Bug_Report_Details_page() throws Throwable {
		Assert.assertEquals("Bug Report #61", bugReportPage.bugReportTitle.getText());
	}

	@Given("^Admin is on the view bugs tab$")
	public void admin_is_on_the_view_bugs_tab() throws Throwable {
		Assert.assertEquals("http://localhost:4200/bugs", driver.getCurrentUrl());
	}

	@When("^Admin scroll down$")
	public void admin_scroll_down() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 650);");
	}

	@Then("^Admin is able to see all Solutions for this bug$")
	public void admin_is_able_to_see_all_Solutions_for_this_bug() throws Throwable {
	   Assert.assertTrue(viewBugsPage.postedSolutionsTitle.isDisplayed());
	}
	
	@When("^Admin clicks solution six$")
	public void admin_clicks_solution_six() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(viewBugsPage.solution6));
		viewBugsPage.solution6.click();
	}
	
	@When("^Admin clicks solution four$")
	public void admin_clicks_solution_four() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(viewBugsPage.solution6));
		viewBugsPage.solution6.click();
	}
	
	@When("^Admin change the status to rejected$")
	public void admin_change_the_status_to_rejected() throws Throwable {
		viewBugsPage.solutStat.sendKeys("Rejected");
	}

	@Then("^Solution status is changed$")
	public void solution_status_is_changed() throws Throwable {
		Assert.assertTrue(viewBugsPage.solutStat.isDisplayed());
	}

	@When("^Admin change the status to accepted$")
	public void admin_change_the_status_to_accepted() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(viewBugsPage.solutStat));
		viewBugsPage.solutStat.sendKeys("Accepted");
	}
}
