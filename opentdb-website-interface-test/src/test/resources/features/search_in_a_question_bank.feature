@search
Feature: Search in a question bank

	Background:
		Given that I navigate to the search page of the question bank
		And type 'Science: Computers' in the search field
	
	@negative
	Scenario: Search for a nonexistent question
		When I click the search button
		Then I visualize an error message with the text 'No questions found.'.
	
	@positive
	Scenario: Search by Science: Computers with Category parameter 
		And select as search parameter the category
		When I click the page search button
		Then I check if the listing of questions is with 25 items 
		And what if the page control appears
