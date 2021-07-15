@catalogueService 
Feature: Test Catalogue Microservices Integration Test 

#@ignore		
Scenario Outline: Create catalogue in catalogue microservice 
	Given create catalogue data with request body "<body>" 
	When create  catalogues service will be called 
	Then catalogue created with valid HTTP response code 201 
	Examples: 
		| body |
		|    src/test/resources/catalogues/catalogues.json |