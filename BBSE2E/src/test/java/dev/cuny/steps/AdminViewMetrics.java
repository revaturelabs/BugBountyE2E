package dev.cuny.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.cuny.pages.LoginPage;
import dev.cuny.pages.MainPage;
import dev.cuny.pages.MetricsPage;
import dev.cuny.runners.Runner;
import junit.framework.Assert;
 
public class AdminViewMetrics {
	
	public WebDriver driver = Runner.driver;
	public LoginPage lpage = Runner.loginPage;
	public MetricsPage metricPage = Runner.metricPage;
	public MainPage mainPage = Runner.mainPage;
	



	@When("^Admin clicks the metrics tab$")
	public void admin_clicks_the_metrics_tab() throws Throwable {
	    mainPage.metricsButton.click();
	}
	

	@Then("^Admin is viewing metrics for bug bounty$")
	public void admin_is_viewing_metrics_for_bug_bounty() throws Throwable {
	    Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:4200/metrics");
	}
	
	@When("^I click the developers button$")
	public void i_click_the_developers_button() throws Throwable {
	    metricPage.developerButton.click();
	}
	
	@When("^Admin clicks the developers button$")
	public void admin_clicks_the_developers_button() throws Throwable {
	    metricPage.developerButton.click();
	}
	
	@Then("^Admin sees metrics on the developers$")
	public void admin_sees_metrics_on_the_developers() throws Throwable {
		String result = metricPage.peopleCounter.getText();
		Assert.assertNotNull(result);
	}


	@When("^Admin clicks the applications button$")
	public void admin_clicks_the_applications_button() throws Throwable {
		metricPage.applicationSideButton.click();
	}
	
	@Then("^Admin sees metrics on the applications$")
	public void admin_sees_metrics_on_the_applications() throws Throwable {
		Dimension size = new Dimension(0, 0);
		Assert.assertNotSame(0, metricPage.applicationGraph.getSize().getHeight());
		Assert.assertNotSame(0, metricPage.applicationGraph.getSize().getWidth());
	}
}
