package dev.cuny.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MetricsPage {

	private WebDriver driver;
	
	public MetricsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Developers")
	public WebElement developerButton;
	
	@FindBy(linkText = "Applications")
	public WebElement applicationButton;
	
	@FindBy(id = "applications-tab")
	public WebElement applicationSideButton;
	
	@FindBy(id = "average-time")
	public WebElement peopleCounter;
	
	@FindBy(className = "canvasjs-chart-canvas")
	public WebElement applicationGraph;
}
