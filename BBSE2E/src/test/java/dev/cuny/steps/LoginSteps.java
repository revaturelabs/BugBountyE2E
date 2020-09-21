package dev.cuny.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.cuny.pages.LoginPage;
import dev.cuny.pages.MainPage;
import dev.cuny.runners.Runner;

public class LoginSteps {
	

	public static LoginPage loginPage = Runner.loginPage;
	public static MainPage mainPage = Runner.mainPage;
	public static WebDriver driver = Runner.driver;
	
	@Given("^Client is on the Login page$")
	public void client_is_on_the_Login_page() throws Throwable {
	    driver.get("http://localhost:4200");
	}

	@When("^Client types \"([^\"]*)\" into the username field$")
	public void client_types_into_the_username_field(String arg1) throws Throwable {
		loginPage.username.clear();
	    loginPage.username.sendKeys(arg1);
	}

	@When("^Client types \"([^\"]*)\" into the password field$")
	public void client_types_into_the_password_field(String arg1) throws Throwable {
		loginPage.password.clear();
	    loginPage.password.sendKeys(arg1);
	}

	@When("^Client clicks the Login button$")
	public void client_clicks_the_Login_button() throws Throwable {

	    loginPage.loginButton.click();

	}

	@Then("^Client should be on the main page$")
	public void client_should_be_on_the_main_page() throws Throwable {
	    WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.visibilityOf(mainPage.mainBanner));
	    Assert.assertTrue(mainPage.mainBanner.isDisplayed());
	}

	@Then("^Login Error Message is Displayed$")
	public void login_Error_Message_is_Displayed() throws Throwable {
	    WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.visibilityOf(loginPage.loginError));
	    Assert.assertTrue(loginPage.loginError.isDisplayed());
	}
	
	@Given("^Admin is on the Login page$")
	public void admin_is_on_the_Login_page() throws Throwable {
		driver.get("http://localhost:4200");
	}

	@When("^Admin types \"([^\"]*)\" into the username field$")
	public void admin_types_into_the_username_field(String arg1) throws Throwable {
		loginPage.username.clear();
	    loginPage.username.sendKeys(arg1);
	}

	@When("^Admin types \"([^\"]*)\" into the password field$")
	public void admin_types_into_the_password_field(String arg1) throws Throwable {
		loginPage.password.clear();
	    loginPage.password.sendKeys(arg1);
	}

	@When("^Admin clicks the Login button$")
	public void admin_clicks_the_Login_button() throws Throwable {
	
		loginPage.loginButton.click();
	}

	@Then("^Admin is on the main page$")
	public void admin_is_on_the_main_page() throws Throwable {
	    WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.visibilityOf(mainPage.mainBanner));

	    Assert.assertTrue(mainPage.mainBanner.isDisplayed());
	}
	
	@When("^Client clicks the log out button$")
	public void client_clicks_the_log_out_button() throws Throwable {
	    mainPage.logoutButton.click();
	}
	
	@Given("^Client is on the main page$")
	public void client_is_on_the_main_page() throws Throwable {
		driver.get("http://localhost:4200/main");
	}
}
