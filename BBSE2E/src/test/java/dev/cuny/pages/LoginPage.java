package dev.cuny.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "Sign in")
	public WebElement loginRegisterSwitchBtn;
	
	@FindBy(name = "username")
	public WebElement username;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(name = "repassword")
	public WebElement repassword;
	
	@FindBy(name = "firstname")
	public WebElement firstName;
	
	@FindBy(name = "lastname")
	public WebElement lastName;
	
	@FindBy(name = "email")
	public WebElement email;
	
	@FindBy(id = "loginButton")
	public WebElement loginButton;
	
	@FindBy(id = "loginError")
	public WebElement loginError;
	
	@FindBy(id = "mat-tab-label-0-1")
	public WebElement registerTab;
	
	@FindBy(id = "registerButton")
	public WebElement registerButton;
	
	@FindBy(id = "regUsername")
	public WebElement regUsername;
	
	@FindBy(id = "regPassword")
	public WebElement regPassword;
	
}
