   
      
Feature: Incidents 

	Background: List of steps run before each of the scenarios
		Given Set Base URI
		And Set Auth
	
	
	Scenario: Create Incident with String Body
		When Create incident with body '{"short_description": "First incident create via cucumber Rest assured"}'
		Then Validate response code as 201
		
		
	Scenario: Get all Incident wih QueryParam
		When  get incidents with queryparam "sysparam_fiels" and "sys_id,urgency"
		Then Validate response code as 200
		
	Scenario: Get all Incident wih QueryParam sysparamlimit
		When  get incidents with queryparam "sysparam_limit" and "1"
		Then Validate response code as 200
		
		
	Scenario Outline: Create Incident  with multiple files
	When create incident with '<fileName>'
	Then Validate response code as 201
	Examples:
	|fileName|
	|Createincident.json|
	|Createincident1.json|
	

	Scenario: Update Incident
	When update incident with body '{"short_description": "updated via RA using Cucumber"}'
	Then Validate response code as 200