Feature: As admin I want to create an application

	Background: Admin logs into their account
		Given Admin is on the Login page
		When Admin types "TheRaidman" into the username field
		When Admin types "password" into the password field
		When Admin clicks the Login button
		Then Admin is on the main page

	@UserStory7
	Scenario: Admin creates a new application
		Given Admin is on the main page
		When Admin clicks on the applications tab
		Then Application modal is displayed
		When Admin adds "NewCucTest222" in the Application Title 
		When Admin adds "NewGitCucLink221" Github Link
		When Admin clicks the save button
		Then Application is added
		
	@UserStory7.1	
	Scenario: Admin creates a new application with partial info
	Given Admin is on the main page
	When Admin clicks on the applications tab
	Then Application modal is displayed
	When Admin adds "NewCucTest221" in the Application Title 
	When Admin clicks the save button
	Then Missing field will display an error
	Then Application will not be submitted
	
	
	@UserStory7.2
	Scenario: Admin creates a new application and press cancel
	Given Admin is on the main page
	When Admin clicks on the applications tab
	Then Application modal is displayed
	When Admin adds "NewCucTest221" in the Application Title 
	When Admin adds "NewGitCucLink101" Github Link
	When Admin clicks the cancel button
	Then Application will not be submitted
