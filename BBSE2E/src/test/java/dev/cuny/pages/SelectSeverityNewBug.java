package dev.cuny.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectSeverityNewBug {

	public WebDriver driver;

	@FindBy(id = "SeverityDropDown")
	public WebElement severityDropdown;

	public Select severitySelect; // Dont initialize here

	public SelectSeverityNewBug(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		severitySelect = new Select(severityDropdown);// initialize here
	}

}
