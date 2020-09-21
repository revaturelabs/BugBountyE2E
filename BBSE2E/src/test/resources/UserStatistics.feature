Feature: As a Client, I want to see various statistics, so that I can view leaderboard status & my solutions
	
	Background: Client logs into their account
		Given Client is on the Login page
		When Client types "posttest" into the username field
		When Client types "password" into the password field
		When Client clicks the Login button
		Then Client is on the main page

	@UserStory6.1
	Scenario: As a Client, I want to view the leaderboard to see the top devs and their points by rank
		Given Client is on the main page
		Then Leaderboard is displayed 

		
	@UserStory6.3
	Scenario: As a Client, I want to view my profile page to see my solution history, bug reports, & points	
		Given Client is on the main page
		When Client clicks the profile tab
		Then Client is redirected to their profile page
		