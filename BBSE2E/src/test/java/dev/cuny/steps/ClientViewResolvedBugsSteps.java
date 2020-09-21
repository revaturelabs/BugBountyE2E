package dev.cuny.steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.cuny.pages.BugReportPage;
import dev.cuny.pages.LoginPage;
import dev.cuny.pages.MainPage;
import dev.cuny.runners.Runner;
import junit.framework.Assert;

public class ClientViewResolvedBugsSteps {
	
	public static WebDriver driver = Runner.driver;
	public static LoginPage lPage = Runner.loginPage;
	public static MainPage mPage = Runner.mainPage;
	public static BugReportPage brPage = Runner.bugReportPage;
	
	@Given("^The user is on the home page$")
	public void the_user_is_on_the_home_page() throws Throwable {
		driver.get("http://localhost:4200/");
	}

	@When("^The user signs in as a client$")
	public void the_user_signs_in_as_a_client() throws Throwable {
	    lPage.username.sendKeys("mo");
	    lPage.password.sendKeys("password");
	    lPage.loginButton.click();
	}

	@When("^The client clicks view bugs$")
	public void the_client_clicks_view_bugs() throws Throwable {
	    mPage.viewBugsButton.click();
	}

	@Then("^The client is on the bug page viewing resolved bugs$")
	public void the_client_is_on_the_bug_page_viewing_resolved_bugs() throws Throwable {
	    Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/bugs");
	}
}
