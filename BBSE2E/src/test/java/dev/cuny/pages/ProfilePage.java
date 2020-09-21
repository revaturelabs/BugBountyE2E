package dev.cuny.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

	WebDriver driver;
	
	public ProfilePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "AboutMeDiv")
	public WebElement aboutMeSection;
	
	@FindBy(id = "bugTableDiv")
	public WebElement bugTable;
	
	@FindBy(id = "solutionTableDiv")
	public WebElement solutionTable;
	
	@FindBy(linkText = "Update Password")
	public WebElement updatePassword;
	
	@FindBy(id = "currentPassword")
	public WebElement currentPassword;
	
	@FindBy(id = "newPassword")
	public WebElement newPassword;
	
	@FindBy(id = "verifyPassword")
	public WebElement verifyPassword;
	
	@FindBy(id = "submitButton")
	public WebElement submitButton;
	
	@FindBy(id = "SolutionsTableTitle")
	public WebElement solutionsTitle;
	
	@FindBy(id = "BugsTableTitle")
	public WebElement bugsTitle;
}
