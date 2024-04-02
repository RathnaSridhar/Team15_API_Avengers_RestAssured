Feature: User Logout

Background: Check if Admin able to generate token with valid credential
    Given Admin creates request with "valid" credentials
    When  Admin calls Post Https method  with "User Sign In"
    Then  Admin receives 200 created with auto generated token
    
     Scenario: Check if Admin able to Log-out from User
    Given Admin RequestLog_out from "User log out" for the LMS API from Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
