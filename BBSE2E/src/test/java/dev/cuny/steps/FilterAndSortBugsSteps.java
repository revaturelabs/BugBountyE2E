package dev.cuny.steps;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import org.junit.Assert;
import dev.cuny.pages.ViewBugsPage;
import dev.cuny.pages.LoginPage;
import dev.cuny.pages.MainPage;
import dev.cuny.runners.Runner;
public class FilterAndSortBugsSteps {
	
	public static LoginPage loginPage = Runner.loginPage;
	public static ViewBugsPage viewBugsPage = Runner.viewBugsPage;
	public static MainPage mainPage = Runner.mainPage;
	public static WebDriver driver = Runner.driver;
	
	@Given("^Client is on view bugs page$")
	public void client_is_on_the_view_bugs_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 2);
	    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.resolvedBugsTable));
	    Assert.assertTrue(viewBugsPage.resolvedBugsTable.isDisplayed());
	}
	@When("^Client clicks on the requested bugs tab$")
	public void client_clicks_on_the_requested_bugs_tab() throws Throwable {
	    WebElement requestedBugsTab = driver.findElement(By.xpath("//div[substring(@id,string-length(@id) -string-length('-2') +1) = '-2']"));
	    WebDriverWait wait = new WebDriverWait(driver, 2);
	    wait.until(ExpectedConditions.visibilityOf(requestedBugsTab));
	    requestedBugsTab.click();
	}
	
	@When("^Client clicks on the \"([^\"]*)\" bugs tab$")
	public void client_clicks_on_the_bugs_tab(String arg1) throws Throwable {
		String tab="";
		if(arg1.equals("resolved")) {
			tab = "-0";
		} else if(arg1.equals("unresolved")) {
			tab = "-1";
		} else if(arg1.equals("requested")) {
			tab = "-2";
		}
	    WebElement bugsTab = driver.findElement(By.xpath("//div[substring(@id,string-length(@id) -string-length('"+tab+"') +1) = '"+tab+"']"));
	    WebDriverWait wait = new WebDriverWait(driver, 2);
	    wait.until(ExpectedConditions.visibilityOf(bugsTab));
	    bugsTab.click();
	}

	@Then("^\"([^\"]*)\" table is displayed$")
	public void table_is_displayed(String arg1) throws Throwable {
		if(arg1.equals("resolved")) {
			WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.resolvedBugsTable));
		    Assert.assertTrue(viewBugsPage.resolvedBugsTable.isDisplayed());
		} else if(arg1.equals("unresolved")) {
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.unresolvedBugsTable));
		    Assert.assertTrue(viewBugsPage.unresolvedBugsTable.isDisplayed());
		} else if(arg1.equals("requested")) {
			WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.adminBugsTable));
		    Assert.assertTrue(viewBugsPage.adminBugsTable.isDisplayed());
		}
	}

	@When("^Client clicks on inspect button$")
	public void client_clicks_inspect_button_on_a_unresolved_bug() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		WebElement field = driver.findElement(By.linkText("Inspect"));
	    try {
			wait.until(ExpectedConditions.stalenessOf(field));
		    field  = driver.findElement(By.linkText("Inspect"));
		    field.click();
	    } catch (TimeoutException e) {
		    field.click();
	    }	    
	}
	
	@When("^Client clicks \"([^\"]*)\" filter select$")
	public void client_clicks_filter_select(String arg1) throws Throwable {
		if(arg1.equals("application")) {
			WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.applicationFilter));
			viewBugsPage.applicationFilter.click();
		}else if(arg1.equals("severity")){
			WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.severityFilter));
			viewBugsPage.severityFilter.click();
		}else if(arg1.equals("priority")){
			WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.priorityFilter));
			viewBugsPage.priorityFilter.click();
		}
	}

	@When("^Client clicks an option$")
	public void client_clicks_an_option() throws Throwable {
	    
		WebDriverWait wait = new WebDriverWait(driver, 1);
		WebElement field = driver.findElements(By.className("mat-option-text")).get(1);
	    try {
			wait.until(ExpectedConditions.stalenessOf(field));
		    field  = driver.findElements(By.className("mat-option-text")).get(1);
		    field.click();
	    } catch (TimeoutException e) {
	    	field.click();
	    }	
	}

	@Then("^Bugs of that \"([^\"]*)\" should be shown$")
	public void bugs_of_that_should_be_shown(String arg1) throws Throwable {
	    if(arg1.equals("application")) {
		    WebElement app = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[2]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(app));
		    Assert.assertEquals("Bug Bounty System", app.getText());
	    }else if(arg1.equals("severity")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[4]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("Low", title.getText());
	    }else if(arg1.equals("priority")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[5]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("Low", title.getText());
	    }
	}
	
	@Then("^Bug report view is displayed$")
	public void bug_report_view_is_displayed() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 3);
	    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.bugReportDetails));
	    Assert.assertTrue(viewBugsPage.bugReportDetails.isDisplayed());
	}
	@When("^Client clicks on return to view bugs button$")
	public void client_clicks_on_return_to_view_bugs_button() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 3);
	    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.returnToViewBugsButton));
	    viewBugsPage.returnToViewBugsButton.click();
	}
	
	@When("^Client types location into search bar$")
	public void client_types_location_into_search_bar() throws Throwable {
	    WebElement search = driver.findElement(By.xpath("//input[@ng-reflect-placeholder='Search Bugs']"));
	    WebDriverWait wait = new WebDriverWait(driver, 2);
	    wait.until(ExpectedConditions.visibilityOf(search));
	    search.sendKeys("line 342");
	}
	
	@When("^Client clears search bar$")
	public void client_clears_search_bar() throws Throwable {
	    WebElement search = driver.findElement(By.xpath("//input[@ng-reflect-placeholder='Search Bugs']"));
	    search.clear();
	}

	@Then("^Only bugs from that location should be visible$")
	public void only_bugs_from_that_location_should_be_visible() throws Throwable {
	    WebElement line = driver.findElement(By.tagName("app-admin-bugs-table"));
	    WebDriverWait wait = new WebDriverWait(driver, 2);
	    wait.until(ExpectedConditions.visibilityOf(line));
		Assert.assertTrue(line.getText().contains("Line 342"));
	}
	
	@When("^Client clicks on \"([^\"]*)\" sort button$")
	public void client_clicks_on_sort_button(String arg1) throws Throwable {
		if(arg1.equals("title")) {
			WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.titleSortButton));
			viewBugsPage.titleSortButton.click();
	    }else if(arg1.equals("location")) {
	    	WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.locationSortButton));
			viewBugsPage.locationSortButton.click();
	    }else if(arg1.equals("severity")) {
	    	WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.severitySortButton));
			viewBugsPage.severitySortButton.click();
	    }else if(arg1.equals("priority")) {
	    	WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.prioritySortButton));
			viewBugsPage.prioritySortButton.click();
	    }else if(arg1.equals("date")) {
	    	WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.dateSortButton));
			viewBugsPage.dateSortButton.click();
	    }else if(arg1.equals("developer")) {
	    	WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(viewBugsPage.developerSortButton));
			viewBugsPage.developerSortButton.click();
	    }
	}

	@Then("^Bugs should be sorted by \"([^\"]*)\"$")
	public void bugs_should_be_sorted_by(String arg1) throws Throwable {
		if(arg1.equals("title")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[1]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("DataBuffer doesn't write to file called: The flood", title.getText());
	    }else if(arg1.equals("location")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[3]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("I have no Idea", title.getText());
	    }else if(arg1.equals("severity")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[4]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("High", title.getText());
	    }else if(arg1.equals("priority")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[5]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("High", title.getText());
	    }else if(arg1.equals("date")) {
	    	WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[6]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("8/26/20, 8:00 PM", title.getText());
	    }else if(arg1.equals("developer")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[7]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("AlwaysDeugging", title.getText());
	    }else if(arg1.equals("application")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[2]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("Bug Bounty System", title.getText());
	    }
	}

	@Then("^Bugs should be sorted reverse by \"([^\"]*)\"$")
	public void bugs_should_be_sorted_reverse_by(String arg1) throws Throwable {
		if(arg1.equals("title")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[1]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("When using the code from Bioshock it causes my compter", title.getText());
	    }else if(arg1.equals("location")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[3]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("Swift encoder", title.getText());
	    }else if(arg1.equals("severity")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[4]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("Low", title.getText());
	    }else if(arg1.equals("priority")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[5]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("Low", title.getText());
	    }else if(arg1.equals("date")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[6]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("5/2/20, 8:00 PM", title.getText());
	    }else if(arg1.equals("developer")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[7]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("user1", title.getText());
	    }else if(arg1.equals("application")) {
		    WebElement title = driver.findElement(By.xpath("//*[@id=\"resolvedBugsTable\"]/div[2]/table/tbody/tr[1]/td[2]"));
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.visibilityOf(title));
		    Assert.assertEquals("Pizza Ordering Application", title.getText());
	    }
	}
	
	@When("^Client clicks all$")
	public void client_clicks_all() throws Throwable {
	    List<WebElement> field = driver.findElements(By.className("mat-option-text"));
	    WebDriverWait wait = new WebDriverWait(driver, 2);
	    wait.until(ExpectedConditions.visibilityOfAllElements(field));
	    field.get(0).click();
	}
}