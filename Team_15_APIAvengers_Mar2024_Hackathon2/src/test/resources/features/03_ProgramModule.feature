Feature: Program Module CRUD Opertaions
  
 	Background: Check if Admin able to generate token with valid credential
    Given Admin creates request with "valid" credentials
    When Admin calls Post Https method  with "User Sign In"
    Then Admin receives 200 created with auto generated token
  
    
#@PostNewProgram
#Scenario: Check if Admin able to create a program with endpoint , request body and Authorization
#Given Admin creates New Program "Add new program" from "batches" sheet for the LMS from Excel with request body
#When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
#Then User receives "Status Code" code with response body "Status Message"
#
#@GetAllRequestProgram
#Scenario: Check if Admin able to retrieve all programs with valid Endpoint
#Given User creates GET Request "GET All Programs" from "batches" sheet for the LMS API from Excel
#When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
#Then User receives "Status Code" code with response body "Status Message"  
#
#@GetRequestByProgramID
#Scenario: Check if Admin able to retrieve a program with valid program ID
#Given User creates GET program by Id Request "GET Program by ProgramId" from "batches" sheet for the LMS API from Excel
#When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
#Then User receives "Status Code" code with response body "Status Message" 


@GetAllProgramsWithAdmins
Scenario: Check if Admin able to retrieve all programs with Admins
Given Admin creates GET Request "GET All Programs with Users" from "batches" for the LMS API from Excel
When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
Then User receives "Status Code" code with response body "Status Message"   

#
#@PutRequestbyProgramID
#Scenario: Check if Admin able to update a program with valid programID endpoint and valid request body
#Given User creates PUT Request "Update Program by ProgramId" from "batches" from tthe Excel
#When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
#Then User receives "Status Code" code with response body "Status Message"     
#
#
#@PutRequestbyProgramName
#Scenario: Check if Admin able to update a program with  Valid program Name and request body
#Given Admin creates PUT Request "Update Program by ProgramName" from "batches" sheet from the Excel  
#When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
#Then User receives "Status Code" code with response body "Status Message" 
#
#@DeleteRequestbyprogramName
#Scenario: Check if Admin able to delete a program with valid programName
#Given Admin creates DELETE Request "Delete Program By ProgramName" from "batches" sheet from the Excel
#When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
#Then User receives "Status Code" code with response body "Status Message" 
#
#@DeleteRequestbyprogramID
#Scenario: Check if Admin able to delete a program with valid program ID
#Given Admin creates DELETE Request "Delete Program By ProgramID" from "batches" sheet from the Excel
#When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
#Then User receives "Status Code" code with response body "Status Message"
