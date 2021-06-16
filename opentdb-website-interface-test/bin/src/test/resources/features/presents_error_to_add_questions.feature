Feature: Add new questions to the question bank

  Scenario: Adding question to the bank without having logged in to the site
    Given that I access the question bank page
    When I click the Add New Questions button 
    Then I display error message with the text 'ERROR! You must be logged in to submit a trivia question.'.


