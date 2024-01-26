
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Log in with username <name> and password <pwd>
    Then "Incorrect email or password." message is displayed 

    Examples: 
		Examples:
		| name										|	pwd				|
		| shravangundu@gmail.com	| Test@123	|