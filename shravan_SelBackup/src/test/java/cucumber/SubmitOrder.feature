@tag
Feature: Purchase the Order from Ecommerce Website
	I want to use this template for my feature file
	
	Background: 
	
	Given I landed on Ecommerce Page
	
	@Regression
	Scenario Outline: Positive Test of Submitting the Order
		Given Log in with username <name> and password <pwd>
		When I add product <productName> to Cart
		And Checkout <productName> and submit order
		Then "THAKYOU FOR THE ORDER." message is displayed on the confirmation page
		
		Examples:
		| name											|	pwd				| productName | countryName |
		| shravangundu231@gmail.com	| Test@123	| ZARA COAT 3 | India       |