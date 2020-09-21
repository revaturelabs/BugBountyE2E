package dev.cuny.steps;


import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import dev.cuny.pages.LoginPage;
import dev.cuny.runners.Runner;

public class RegisterSteps {
	

	public static LoginPage loginPage = Runner.loginPage;
	public static WebDriver driver = Runner.driver;
	
	@When("^Client clicks the register tab$")
	public void client_clicks_the_register_tab() throws Throwable {
		loginPage.registerTab.click();
	}

	@Then("^Client is on the Registration page$")
	public void client_is_on_the_Registration_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.visibilityOf(loginPage.firstName));
	    Assert.assertTrue(loginPage.firstName.isDisplayed());
	}

	@When("^Client types \"([^\"]*)\" into first name field$")
	public void client_types_into_first_name_field(String arg1) throws Throwable {
	    loginPage.firstName.clear();
	    loginPage.firstName.sendKeys(arg1);
	}

	@When("^Client types \"([^\"]*)\" into last name field$")
	public void client_types_into_last_name_field(String arg1) throws Throwable {
	    loginPage.lastName.clear();
	    loginPage.lastName.sendKeys(arg1);
	}

	@When("^Client Types \"([^\"]*)\" into the email field$")
	public void client_Types_into_the_email_field(String arg1) throws Throwable {
	    loginPage.email.clear();
	    loginPage.email.sendKeys(arg1);
	}

	@When("^Client types \"([^\"]*)\" into the confirm password field$")
	public void client_types_into_the_confirm_password_field(String arg1) throws Throwable {
	    loginPage.repassword.clear();
	    loginPage.repassword.sendKeys(arg1);
	}

	@When("^Client clicks the register button$")
	public void client_clicks_the_register_button() throws Throwable {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", loginPage.registerButton);
	}

	@Then("^Client should be on the login page$")
	public void client_should_be_on_the_login_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));
	    Assert.assertTrue(loginPage.loginButton.isDisplayed());
	}
	
	@When("^Client types \"([^\"]*)\" into the register username field$")
	public void client_types_into_the_register_username_field(String arg1) throws Throwable {
		loginPage.regUsername.clear();
		loginPage.regUsername.sendKeys(arg1);
	}

	@When("^Client types \"([^\"]*)\" into the register password field$")
	public void client_types_into_the_register_password_field(String arg1) throws Throwable {
	    loginPage.regPassword.clear();
	    loginPage.regPassword.sendKeys(arg1);
	}
	
}
