package dev.cuny.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReportBug {

	WebDriver driver;

	public ReportBug(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "reportNewBug")
	public WebElement reportNewBug;

	@FindBy(id = "newBugReport")
	public WebElement newBugReport;

	@FindBy(id = "bugTitle")
	public WebElement bugTitle;

	@FindBy(id = "suspectedLocation")
	public WebElement suspectedLocation;

	@FindBy(id = "bugDescription_ifr")
	public WebElement descriptionHTML;

	@FindBy(id = "bugReproduction_ifr")
	public WebElement reproductionHTML;

	@FindBy(id = "BugCancel")
	public WebElement BugCancel;

	@FindBy(id = "BugSubmit")
	public WebElement BugSubmit;

	@FindBy(id = "bugTitleReport")
	public WebElement BugTitleReport;

}
