package dev.cuny.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectPriorityNewBug {
	public WebDriver driver;

	@FindBy(id = "PriorityDropDown")
	public WebElement priorityDropdown;
	
	public Select prioritySelect; //Dont initialize here

	public SelectPriorityNewBug(WebDriver driver) {
	this.driver = driver;

	PageFactory.initElements(driver, this);
	prioritySelect = new Select(priorityDropdown);//initialize here
	}

	}