package dev.cuny.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectAppNewBug {

	public WebDriver driver;

	@FindBy(id = "AppsDropDown")
	public WebElement appsDropdown;
	
	public Select appsSelect; //Dont initialize here

	public SelectAppNewBug(WebDriver driver) {
	this.driver = driver;

	PageFactory.initElements(driver, this);
	appsSelect = new Select(appsDropdown);//initialize here
	}

	}