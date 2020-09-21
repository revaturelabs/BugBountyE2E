package dev.cuny.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BugReportPage {

	WebDriver driver;
	
	public BugReportPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "bugTitleReport")
	public WebElement bugReportTitle;
	
	@FindBy(id = "txtSolTitle")
	public WebElement solutionTitle;
	
	@FindBy(id = "txtSolDescribtion")
	public WebElement solutionDescription;
	
	@FindBy(id = "cancelButton")
	public WebElement cancelButton;
	
	@FindBy(id = "submitButton")
	public WebElement submitButton;
	
	@FindBy(id = "resolve-bug-button")
	public WebElement resolveBugButton;
	
	@FindBy(id = "txtstatus")
	public WebElement bugStatus;
	
	@FindBy(id = "approve-bug-button")
	public WebElement approveButton;
	
	@FindBy(id = "reject-bug-button")
	public WebElement rejectButton;
	
	@FindBy(id = "return-to-view-bugs")
	public WebElement returnToViewBugsButton;
	
	@FindBy(id = "ddlseverity")
	public WebElement severitySelect;
	
	@FindBy(id = "ddlpriority")
	public WebElement prioritySelect;
	
	@FindBy(id = "txtpoints")
	public WebElement pointsInput;
	
	@FindBy(id = "point-label")
	public WebElement pointLabel;
}
