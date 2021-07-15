@orderService 
Feature: Test Order, Catalogue, customer management Microservices Integration Test 

#@ignore
Scenario: Fetch order 
	Given I Set GET order service api endpoint
	When fetch order service will be called 
	Then receive valid HTTP response code 200