Feature: As a Client, I want to report a bug, So that I can get a solution
	
	Background: Client logs into their account
		Given Client is on the Login page
		When Client types "posttest" into the username field
		When Client types "password" into the password field
		When Client clicks the Login button
		Then Client is on the main page

	@UserStory3.1
	Scenario: As a Client, I want to fill out a bug report form, so I can get help with a project bug
		Given Client is on the main page 
		When Clien clicks on the Report New Bug tab
		Then Client is on the on the Report New Bug page
		When Client enters "AppTitleTest" for a bug title 
		When Client selects "Bug Bounty System" from the application dropdown
		When Client fills "SuspectedLocationTest" for suspected location 
		When Client selects "Low" from the severity dropdown
		When Client selects "Medium" from the priority dropdown
		When Client types "Bug description test" into the description field
		When Client types "Bug reproduction steps test" into reproduction field
		When Client clicks the submit bug button
		Then Client is on the Bug Report View
		
	@UserStory3.1.1	
	Scenario: As a Client, I want to cancel a bug report form, so I can discard the information
		Given Client is on the main page 
		When Clien clicks on the Report New Bug tab
		Then Client is on the on the Report New Bug page
		When Client clicks the cancel bug button
		Then Client is on the main page 

		
		