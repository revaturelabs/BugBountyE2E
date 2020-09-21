Feature: As an Admin I want to view bug report metrics
	
		Background: Admin logs into their account
		Given Admin is on the Login page
		When Admin types "TheRaidman" into the username field
		When Admin types "password" into the password field
		When Admin clicks the Login button
		Then Admin is on the main page
	
	
	Scenario: Admin viewing BugBounty metrics
		Given Admin is on the main page
		When Admin clicks the metrics tab
		Then Admin is viewing metrics for bug bounty
	
	Scenario: Admin viewing developer metrics
		Given Admin is on the main page
		When Admin clicks the metrics tab
		When Admin clicks the developers button
		Then Admin sees metrics on the developers
		
	Scenario: Admin viewing application metrics
		Given Admin is on the main page
		When Admin clicks the metrics tab
		When Admin clicks the applications button
		Then Admin sees metrics on the applications
		