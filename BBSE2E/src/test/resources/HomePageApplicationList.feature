Feature: Inspect and resolve bugs on Home page

	Background: Client logs in
		Given Client is on the Login page
		When Client types "Emailman" into the username field
		When Client types "password" into the password field
		When Client clicks the Login button
		Then Client should be on the main page
		
#	Scenario: Client expands and shrinks application
#		When Client clicks on an application
#		Then The application's bugs are shown
#		When Client clicks on the application
#		Then The application's bugs are not shown
		
	Scenario: Client clicks on bug and submits solution
		When Client clicks on a bug link
		Then The Bug's page is shown
		When Client enters "This is a great solution" into the title input
		When Client enters "It is actually not that great." into the solution input
		When Client clicks the submit button
		Then The solution is added under Posted Solution(s)
		
	Scenario: Client clicks on bug and cancels submission
		When Client clicks on a bug link
		Then The Bug's page is shown
		When Client enters "This is a great solution" into the title input
		When Client enters "It is actually not that great." into the solution input
		When Client clicks the cancel button
		Then The title input is cleared
		Then The solution input is cleared
		

		