Feature: Log in to Bug Bounty System

	Scenario Outline: Client logs into their account
		Given Client is on the Login page
		When Client types "<username>" into the username field
		When Client types "<password>" into the password field
		When Client clicks the Login button
		Then Client should be on the main page
		
		Examples:
		|username|password|
		|Emailman|password|
		|mo|password|
		
	Scenario: Client logs out of their account
		Given Client is on the main page
		When Client clicks the log out button
		Then Client should be on the login page
		
		
	Scenario Outline: Client logs in with invalid credentials
		Given Client is on the Login page
		When Client types "<username>" into the username field
		When Client types "<password>" into the password field
		When Client clicks the Login button
		Then Login Error Message is Displayed
		
		Examples:
		|username|password|
		|probablyNotAUsername|probablyNotAPassword|
		|notAnAdminUsername|notAnAdminPassword|
		
	Scenario: Admin logs into their account
		Given Admin is on the Login page
		When Admin types "TheRaidman" into the username field
		When Admin types "password" into the password field
		When Admin clicks the Login button
		Then Admin is on the main page
		#Then Admin is logged in the system