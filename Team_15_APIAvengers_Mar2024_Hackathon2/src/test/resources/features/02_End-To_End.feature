Feature: Batch Module

 	Scenario: Check if Admin able to generate token with valid credential
    Given Admin creates request with "valid" credentials
    When Admin calls Post Https method  with "User Sign In"
    Then Admin receives 200 created with auto generated token

  @PostE2ENewProgram
  Scenario: Check if Admin able to create a program with endpoint , request body and Authorization
    Given Admin first creates New Program "Valid Add new program" for the LMS from Excel with request body
    Then Admin makes get program by Id GET Request "Valid GET Program by ProgramId" for the LMS API from Excel
    When Admin updates Program with PUT request "Valid Update Program by ProgramId" from the Excel
    Then Admin makes get program by Id GET Request "Valid GET Program by ProgramId" for the LMS API from Excel
    Then User receives "Status Code" code with response body "Status Message"

  @PostE2ENewBatch
  Scenario: Check if Admin able to create and update a Batch with endpoint , request body and Authorization
    Given Admin first creates New Batch "Valid Create New Batch" for the LMS API From Excel
    Then Admin makes get batch by GET batchId Request "Valid GET Batch by BatchId" for the LMS API From Excel
    When Admin updates Batch with PUT request "Valid Update by Batch Id" from the Excel
    Then Admin makes get batch by GET batchId Request "Valid GET Batch by BatchId" for the LMS API From Excel    
    Then User receives "Status Code" code with response body "Status Message"

 @PostE2EDelete
    Scenario: Check if Admin able to delete batch and program with endpoint, request body and Authorization
    Given Admin Deletes Batch by BatchId with GET request "Valid Delete batch by BatchId" for the LMS API From Excel
        Then Admin makes get batch by GET batchId Request "Valid GET Batch by BatchId" for the LMS API From Excel
        Then Admin Deletes Program by ProgramID with GET request "Valid Delete Program By ProgramID" for the LMS API From Excel
    Then Admin makes get program by Id GET Request "Valid GET Program by ProgramId" for the LMS API from Excel
 
 
 Scenario: Check if Admin able to Log-out from User
    Given Admin RequestLog_out from "User log out" for the LMS API from Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
 

  @PostE2ENewProgram
  Scenario: Check if Admin able to create a program with endpoint , request body and Authorization
    Given Admin first creates New Program "Valid Add new program" for the LMS from Excel with request body
    Then Admin makes get program by Id GET Request "Valid GET Program by ProgramId" for the LMS API from Excel
    When Admin updates Program with PUT request "Valid Update Program by ProgramId" from the Excel
    Then Admin makes get program by Id GET Request "Valid GET Program by ProgramId" for the LMS API from Excel
    Then User receives "Status Code" code with response body "Status Message"
    
    

  @PostE2ENewBatch
  Scenario: Check if Admin able to create and update a Batch with endpoint , request body and Authorization
    Given Admin first creates New Batch "Valid Create New Batch" for the LMS API From Excel
    Then Admin makes get batch by GET batchId Request "Valid GET Batch by BatchId" for the LMS API From Excel
    When Admin updates Batch with PUT request "Valid Update by Batch Id" from the Excel
    Then Admin makes get batch by GET batchId Request "Valid GET Batch by BatchId" for the LMS API From Excel    
    Then User receives "Status Code" code with response body "Status Message"

 @PostE2EDelete
    Scenario: Check if Admin able to delete batch and program with endpoint, request body and Authorization
    Given Admin Deletes Batch by BatchId with GET request "Valid Delete batch by BatchId" for the LMS API From Excel
        Then Admin makes get batch by GET batchId Request "Valid GET Batch by BatchId" for the LMS API From Excel
        Then Admin Deletes Program by ProgramID with GET request "Valid Delete Program By ProgramID" for the LMS API From Excel
    Then Admin makes get program by Id GET Request "Valid GET Program by ProgramId" for the LMS API from Excel