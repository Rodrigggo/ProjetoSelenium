Feature: Search the Bank of Questions 

@StartScenarios 
@FinishScenarios 
Scenario: Search question nonexistent 
	Given I navigate to the question bank search page 
	And   I digit "Science: Computers" in the search field 
	When  I click on the search button 
	Then  I see an error message with the text "No questions found." 
	
@StartScenarios 
@FinishScenarios 
Scenario: Search question existent 
	Given I navigate to the question bank search page 
	And   I select "Category" in the search field 
	And   I digit "Science: Computers" in the search field 
	When  I click on the search button 
	Then  I check if the list of questions has 25 items 
	And   I check if paging control has been displayed 
	
@StartScenarios 
@FinishScenarios 
Scenario: Search user nonexistent 
	Given I navigate to the question bank search page 
	And   I select "User" in the search field 
	And   I digit "Test User" in the search field 
	When  I click on the search button 
	Then  I see an error message with the text "No User Found!" 
	