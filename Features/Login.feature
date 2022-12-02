Feature: Login

  @SmokeTest1
  Scenario: Login to account with valid details
    Given I open Login page 'https://thepenworld.com/my-account/'
    
    When I provide the valid details
    
		|email		| vicky								| abc |
		|password	| Password!@#123			| xyz |
		
		And I check Remember me
		
		And I click on LoginButton
		
		Then I should get successfully Logged in
		
	@SmokeTest2
	Scenario: Login to account with invalid details
    Given I open Login page 'https://thepenworld.com/my-account/'
    
    When I provide the invalid details 'wrong' and 'wrong'
    
		And I check Remember me
		And I click on LoginButton
		Then I should not get Logged in
    
