Feature: Inspect and resolve bugs on view bugs page

	Background: Client logs in
		Given Client is on the Login page
		When Client types "Emailman" into the username field
		When Client types "password" into the password field
		When Client clicks the Login button
		Then Client should be on the main page
		
	Scenario: Client marks bug as resolved
		Given Client is on the main page
		When Client clicks on view bugs button
		Then Client should be on view bugs page
		When Client clicks on unresolved bugs button
		When Client clicks on inspect button
		Then The Bug's page is shown
		When Client clicks the mark as resolved button
		Then status should be set to resolved
		When Client clicks on the return to view bugs button
		Then Client should be on view bugs page
		