Feature: Login to the opentdb website

	Scenario: Displays error message when trying to log in
		Given that I navigate to the login page of the question bank
		And I type the username
		And I type the password
		When I click the sign in button
		Then I display the error message with the text 'ERROR! You need to verify your e-mail address before you can login.'