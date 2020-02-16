Feature: Open Google and Validate Title

Scenario Outline: Open Google And Validate Title
Given user is open browser Page
When title of google page
#Then user enters "<username>" and "<password>"
Then Close the browser of google

Examples:
	| username | password |
	| naveenk  | test@123 |
		