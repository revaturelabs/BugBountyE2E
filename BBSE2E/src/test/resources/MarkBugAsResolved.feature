Feature: As an Admin, I want to mark a bug as resolved, so that I can update the bug board and reward points

	Background: Admin logs into their account
		Given Admin is on the Login page
		When Admin types "TheRaidman" into the username field
		When Admin types "password" into the password field
		When Admin clicks the Login button
		Then Admin is on the main page
		
	@UserStory5.1
	Scenario: As an Admin, I want to view all solutions of a bug, so I can evaluate the solutions and possibly resolve it
		Given Admin is on the main page
		When Admin clicks on view bugs button
		Given Admin is on the view bugs tab
		When Admin clicks on an unresolved bug tab
		When Admin clicks the inspect button
		Then Admin is on to the Bug Report Details page
		When Admin scroll down
		Then Admin is able to see all Solutions for this bug

	
	@UserStory5.2
	Scenario: As an Admin, I want to reject a solution, so I can mark a solution as rejected
			Given Admin is on the main page
		When Admin clicks on view bugs button
		Given Admin is on the view bugs tab
		When Admin clicks on an unresolved bug tab
		When Admin clicks the inspect button
		Then Admin is on to the Bug Report Details page
		When Admin scroll down
		Then Admin is able to see all Solutions for this bug
		When Admin clicks solution four
		When Admin change the status to rejected
		Then Solution status is changed
	
	@UserStory5.3
	Scenario: As an Admin, I want to choose the correct solution, to mark the bug as resolved & reward points
			Given Admin is on the main page
		When Admin clicks on view bugs button
		Given Admin is on the view bugs tab
		When Admin clicks on an unresolved bug tab
		When Admin clicks the inspect button
		Then Admin is on to the Bug Report Details page
		When Admin scroll down
		Then Admin is able to see all Solutions for this bug
		When Admin clicks solution six
		When Admin change the status to accepted
		Then Solution status is changed 

