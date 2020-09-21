Feature: Client registers for the Bugs Bounty System

	Scenario Outline: Client registers with valid input
		Given Client is on the Login page
		When Client clicks the register tab
		Then Client is on the Registration page
		When Client types "<firstName>" into first name field
		When Client types "<lastName>" into last name field 
		When Client types "<username>" into the register username field
		When Client Types "<email>" into the email field
		When Client types "<password>" into the password field
		When Client types "<password>" into the confirm password field
		When Client clicks the register button
		Then Client should be on the login page
		
		Examples:
		|firstName|lastName|username|email|password|
		|ArthurF|MorganF|AMorganF|AMorganF@gmail.com|a2Morgan|
		