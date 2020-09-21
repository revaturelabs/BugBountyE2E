package dev.cuny.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	WebDriver driver;
	
	public MainPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "mat-expansion-panel-header-0")
	public WebElement firstApplication;
	
	@FindBy(linkText = "Profile")
	public WebElement profileButton;
	
	@FindBy(linkText = "Logout")
	public WebElement logoutButton;
	
	@FindBy(id = "mainBanner")
	public WebElement mainBanner;

	@FindBy(id = "bugReportLink")
	public WebElement bugReportLink;
	
	@FindBy(linkText = "View Bugs")
	public WebElement viewBugsButton;
	
	@FindBy(linkText = "Metrics")
	public WebElement metricsButton;
	
	@FindBy(id = "resolveStatus")
	public List<WebElement> bugList;
	
	@FindBy(className = "application-select")
	public WebElement applicationContainer;
}
