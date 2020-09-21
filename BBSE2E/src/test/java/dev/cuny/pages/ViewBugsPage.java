package dev.cuny.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewBugsPage {

	WebDriver driver;
	
	public ViewBugsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "toggle-view")
	public WebElement toggleButton;
	
	@FindBy(id = "mat-tab-label-0-1")
	public WebElement unresolvedBugsButton;
	
	@FindBy(id = "mat-tab-label-0-2")
	public WebElement requestedBugsButton;
	
	@FindBy(linkText = "Inspect")
	public WebElement inspectButton;

	@FindBy(id="viewBugs")
	public WebElement viewBugsTab;	
	
	@FindBy(id="inspectButton1")
	public WebElement inspectButton1;
	
	@FindBy(id="postedSolutionsTitle")
	public WebElement postedSolutionsTitle;
	
	@FindBy(id="solution49")
	public WebElement solution6;
	
	@FindBy(id="solution49")
	public WebElement solution4;
	
	@FindBy(id="solutStat")
	public WebElement solutStat;
	
	@FindBy(id = "txtSolTitle")
	public WebElement solutionTitle;
	
	@FindBy(id = "txtSolDescribtion")
	public WebElement solutionDescription;
	
	@FindBy(id = "cancelButton")
	public WebElement cancelButton;
	
	@FindBy(id = "submitButton")
	public WebElement submitButton;
	
	@FindBy(id = "adminBugsTable")
	public WebElement adminBugsTable;
	
	@FindBy(id = "bugTitleReport")
	public WebElement bugReportDetails;
	
	@FindBy (id = "return-to-view-bugs")
	public WebElement returnToViewBugsButton;
	
	@FindBy(id = "resolvedBugsTable")
	public WebElement resolvedBugsTable;
	
	@FindBy(id = "unresolvedBugsTable")
	public WebElement unresolvedBugsTable;
	
	@FindBy(id = "solution2stat")
	public WebElement solution2stat;
	
	

	@FindBy(xpath = "//*[@id=\"resolvedBugsTable\"]/div[2]/table/thead/tr/th[1]/div/button")
	public WebElement titleSortButton;
	
	@FindBy(xpath = "//*[@id=\"resolvedBugsTable\"]/div[2]/table/thead/tr/th[6]/div/button")
	public WebElement dateSortButton;
	
	@FindBy(xpath = "//*[@id=\"resolvedBugsTable\"]/div[2]/table/thead/tr/th[4]/div/button")
	public WebElement severitySortButton;
	
	@FindBy(xpath = "//*[@id=\"resolvedBugsTable\"]/div[2]/table/thead/tr/th[5]/div/button")
	public WebElement prioritySortButton;
	
	@FindBy(xpath = "//*[@id=\"resolvedBugsTable\"]/div[2]/table/thead/tr/th[2]/div/button")
	public WebElement applicationSortButton;
	
	@FindBy(xpath = "//*[@id=\"resolvedBugsTable\"]/div[2]/table/thead/tr/th[3]/div/button")
	public WebElement locationSortButton;
	
	@FindBy(xpath = "//*[@id=\"resolvedBugsTable\"]/div[2]/table/thead/tr/th[7]/div/button")
	public WebElement developerSortButton;

	@FindBy(xpath = "//*[@id=\"appsort\"]/div/mat-form-field")
	public WebElement applicationFilter;
	
	@FindBy(xpath = "//*[@id=\"severitysort\"]/div/mat-form-field")
	public WebElement severityFilter;
	
	@FindBy(xpath = "//*[@id=\"prioritysort\"]/div/mat-form-field")
	public WebElement priorityFilter;
}
