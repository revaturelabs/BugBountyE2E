Feature: As a client I want to view resolved bugs

	Scenario: Client viewing resolved bugs
		Given The user is on the home page
		When The user signs in as a client
		When The client clicks view bugs
		Then The client is on the bug page viewing resolved bugs