
Feature: UserRoleProgramBatchmap

Background: Check if Admin able to generate token with valid credential
    Given Admin creates request with "valid" credentials
    When Admin calls Post Https method  with "User Sign In"
    Then Admin receives 200 created with auto generated token

    @GetAssignedProgram/Batch(es)ofAllUsers
	Scenario: Check if user able to retrieve all batches  with valid LMS API
    Given User Get request from "Get Assigned Program/Batch(es) of All Users" From Excel of LMS API
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
    
     #@GetAssignedProgram/Batch(es)ofUserByUserId
#	Scenario: Check if user able to retrieve all batches  with valid LMS API
    #Given User Get request from "Get Assigned Program/Batch of a User By User Id" From Excel LMS API
    #When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    #Then User receives "Status Code" code with response body "Status Message"
    
     #@GetAssignedProgram/Batch(es)ofUserByUserId
#	Scenario: Check if user able to retrieve all batches  with valid LMS API
    #Given User Deletes request from "Delete All Programs/Batches assigned to the User By UserId" From Excel LMS API
    #When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    #Then User receives "Status Code" code with response body "Status Message"