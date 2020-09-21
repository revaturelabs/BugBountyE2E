Feature: Client visits profile

	Background: Client logs in
		Given Client is on the Login page
		When Client types "jr" into the username field
		When Client types "password" into the password field
		When Client clicks the Login button
		Then Client should be on the main page
		
	Scenario: Client clicks on profile button and views bugs
		When Client clicks on the profile button
		Then Client should be on the profile page
		When Client clicks on the my bugs button
		Then Table of submitted bugs should be shown
		When Client clicks on the my solutions button
		Then Table of submitted solutions should be shown
		
	Scenario: Client updates password
		When Client clicks on the profile button
		Then Client should be on the profile page
		When Client clicks update password link
		Then Prompt should appear
		When Client enters "password" as current password
		When Client enters "betterPassword" as new password 
		When Client enters "betterPassword" in verify field
		When Client clicks password submit button
		Then An alert should appear