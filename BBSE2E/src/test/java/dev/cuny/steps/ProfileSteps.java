package dev.cuny.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.cuny.pages.BugReportPage;
import dev.cuny.pages.MainPage;
import dev.cuny.pages.ProfilePage;
import dev.cuny.runners.Runner;

public class ProfileSteps {

	public static MainPage mainPage = Runner.mainPage;
	public static ProfilePage profilePage = Runner.profilePage;
	public static WebDriver driver = Runner.driver;
	
	@When("^Client clicks on the profile button$")
	public void client_clicks_on_the_profile_button() throws Throwable {
	    mainPage.profileButton.click();
	}

	@Then("^Client should be on the profile page$")
	public void client_should_be_on_the_profile_page() throws Throwable {
	    Assert.assertTrue(profilePage.aboutMeSection.isDisplayed());
	}

	@Then("^Table of submitted bugs should be shown$")
	public void table_of_submitted_bugs_should_be_shown() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(profilePage.bugTable));
		Assert.assertTrue(profilePage.bugTable.isDisplayed());
	}

	@Then("^Table of submitted solutions should be shown$")
	public void table_of_submitted_solutions_should_be_shown() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(profilePage.solutionTable));
		Assert.assertTrue(profilePage.solutionTable.isDisplayed());
	}
	
	@When("^Client clicks update password link$")
	public void client_clicks_update_password_link() throws Throwable {
	    profilePage.updatePassword.click();
	}

	@Then("^Prompt should appear$")
	public void prompt_should_appear() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(profilePage.currentPassword));
	    Assert.assertTrue(profilePage.currentPassword.isDisplayed());
	}

	@When("^Client enters \"([^\"]*)\" as current password$")
	public void client_enters_as_current_password(String arg1) throws Throwable {
	    profilePage.currentPassword.sendKeys(arg1);
	}

	@When("^Client enters \"([^\"]*)\" as new password$")
	public void client_enters_as_new_password(String arg1) throws Throwable {
	    profilePage.newPassword.sendKeys(arg1);
	}

	@When("^Client enters \"([^\"]*)\" in verify field$")
	public void client_enters_in_verify_field(String arg1) throws Throwable {
		profilePage.verifyPassword.sendKeys(arg1);
	}

	@When("^Client clicks password submit button$")
	public void client_clicks_password_submit_button() throws Throwable {
	    profilePage.submitButton.click();
	}

	@Then("^An alert should appear$")
	public void an_alert_should_appear() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
	    Assert.assertEquals("password successfully updated", driver.switchTo().alert().getText());
	    driver.switchTo().alert().accept();
	}
	
	@When("^Client clicks on the my bugs button$")
	public void client_clicks_on_the_my_bugs_button() throws Throwable {
		profilePage.bugsTitle.click();
	}

	@When("^Client clicks on the my solutions button$")
	public void client_clicks_on_the_my_solutions_button() throws Throwable {
		profilePage.solutionsTitle.click();
	}
}
