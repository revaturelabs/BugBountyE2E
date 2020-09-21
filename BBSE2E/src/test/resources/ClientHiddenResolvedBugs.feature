Feature: As a client I do not want to see resolved bugs on the main page

	Background: Client logs into their account
		Given Client is on the Login page
		When Client types "mo" into the username field
		When Client types "password" into the password field
		When Client clicks the Login button
		Then Client should be on the main page

	Scenario: The client has logged in
		Given The client is on the main page
		Then The client does not see resolved bugs