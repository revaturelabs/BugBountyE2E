@UserStory11
Feature: Filter and sort bugs on View Bugs page
		
	@11.1
	Scenario: Client goes to View Bugs Page
		Given Client is on the Login page
		When Client types "Emailman" into the username field
		When Client types "password" into the password field
		When Client clicks the Login button
		Then Client should be on the main page
		When Client clicks on view bugs button
		Then Client should be on view bugs page

	Scenario Outline: Client filters bugs by status
		Given Client is on view bugs page
		When Client clicks on the <bugType> bugs tab
		Then <bugType> table is displayed
		When Client clicks on inspect button
		Then Bug report view is displayed
		When Client clicks on return to view bugs button
		Then "resolved" table is displayed
		
	Examples:
		| bugType |
		| "requested" |
		| "unresolved" |
		| "resolved" |
	
	@11.2
	Scenario: Client searches bug by location
		Given Client is on view bugs page
		When Client types location into search bar
		Then Only bugs from that location should be visible
		When Client clears search bar
		
	Scenario Outline: Client filters bugs by application, severity, priority
		Given Client is on view bugs page
		When Client clicks <filterType> filter select
		When Client clicks an option
		Then Bugs of that <filterType> should be shown
		When Client clicks <filterType> filter select
		When Client clicks all
		
	Examples:
		| filterType |
		| "application" |
		| "severity" |
		| "priority" | 
		
	@11.3
	Scenario Outline: Client sorts bugs by title, application, location, severity, priority, date, developer
		Given Client is on view bugs page
		When Client clicks on <sortType> sort button
		Then Bugs should be sorted by <sortType>
		When Client clicks on <sortType> sort button
		Then Bugs should be sorted reverse by <sortType>
		
	Examples:
		| sortType |
		| "title" |
		| "location" |
		| "severity" |
		| "priority" |
		| "date" |
		| "developer" |
	