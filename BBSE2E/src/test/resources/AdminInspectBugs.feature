Feature: Admin views and inspects submitted bugs

	Background: Client logs in
		Given Client is on the Login page
		When Client types "Emailman" into the username field
		When Client types "password" into the password field
		When Client clicks the Login button
		Then Client should be on the main page
		When Client clicks on view bugs button
		Then Client should be on view bugs page
		
	Scenario: Admin approves bug report 
		When Client clicks on requested bugs tab
		When Client clicks on inspect button
		Then The Bug's page is shown
		When Client updates priority with "Low"
		When Client updates severity with "Low"
		When Client updates points with "50"
		When Client clicks on the approve button
		Then status should be set to unresolved
		Then priority should be "Low"
		Then severity should be "Low"
		Then points should be "50"
		
	Scenario: Admin rejects bug report
		When Client clicks on requested bugs tab
		When Client clicks on inspect button
		Then The Bug's page is shown
		When Client clicks on the reject button
		Then status should be set to Denied
		
	