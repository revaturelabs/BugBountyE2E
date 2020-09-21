package dev.cuny.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStatistics {

	
WebDriver driver;
	
	public UserStatistics(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

		@FindBy(className="mainLeaderboardRow")
		public WebElement mainLeaderboardRow;
		
		@FindBy(id="profileTab")
		public WebElement profileTab;
		
		@FindBy(id="profileHalf")
		public WebElement profilePage;
		
		@FindBy(id="pointsDiv")
		public WebElement pointsDiv;
		
		@FindBy(id="solutionTableDiv")
		public WebElement solutionTableDiv;
		
		@FindBy(id="bugTableDiv")
		public WebElement bugTableDiv;
		
		@FindBy(id="profileDetail")
		public WebElement profileDetail;
		
		
		
		
		
		
		
		
		
		
		
		

}
