Feature: User Module CRUD Operations


 	Background: Check if Admin able to generate token with valid credential
    Given Admin creates request with "valid" credentials
    When Admin calls Post Https method  with "User Sign In"
    Then Admin receives 200 created with auto generated token
    
 @POST_CreateNewUserWithRole
Scenario: Check if user able to create new user with role with valid LMS API
    Given Admin creates New User "Create User Login with Role" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"


@GetAllUsers
Scenario: Check if user able retrieve all users along with role with valid LMS API
    Given User creates Get request to "Get All Users" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
    
@GetUsersWithUserID
Scenario: Check if user able retrieve all users along with their user ID with valid LMS API
    Given User creates Get request to get user by UserID with "Get User information by UserId" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
    
@GetAllUsersWithRoles
Scenario: Check if user able retrieve all users along with roles and with valid LMS API
    Given User creates Get request to get user with roles with "Get all Users with roles" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
    
@GetTheCountOfActiveAndInactiveUsers
Scenario: Check if user able retrieve the count of all active and inactive users unless roleID is specified,get all the type of users with valid LMS API
    Given User created get request to "Gets count of active and inactive users" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"			
    Then User receives "Status Code" code with response body "Status Message"
        
@GetUserbyprogrambatches
Scenario: Check if user able retrieve all the users by the program batch with valid LMS API
    Given User creates Get request to get all the users with program batch "Gets User by Program Batches " from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
    
@GetAllUserwithProgramID
Scenario: Check if user able retrieve all the users for the program ID with valid LMS API
    Given User creates Get request to retrieve the users for program with program ID "Gets Users for Program" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
    
@GetAllUserwithRoleID
Scenario: Check if user able retrieve all the users by role ID with valid LMS API
    Given User creates Get request to retrieve the users by roleID "Gets Users by roleId" sheet for the LMS API From "batches" Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
    
@GetAllActiveUsers
Scenario: Check if user able retrieve all the active users with valid LMS API
    Given User creates Get request to retrieve all the active users "Get All active users" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
    
@GetUsersbyroleIDV2
Scenario: Check if user able retrieve users by role ID V2 with valid LMS API
    Given User creates Get request to retrieve users by role ID V2 "Gets Users by roleId V2" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
    
@UpdateUser
Scenario: Check if user able update users by userID with valid LMS API
    Given User creates Put request to update user by userID "Update User" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
    
@UpdateUserRoleStatus
Scenario: Check if user able update users role status by user ID with  valid LMS API
    Given User creates Put request to update users RoleStatus by UserID "Update User Role Status" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
    
@UpdateUserRoleID
Scenario: Check if user able update users role ID by user ID with  valid LMS API
    Given User creates Put request to update users role ID by UserID "Update User RoleID" from "batches" for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
    
@UpdateUserRoleProgramBatchStatus
Scenario: Check if user able assign the user role program batch status using userID with  valid LMS API
    Given User creates Put request to assign the user role program batch status using userID "Assign Update User Role Program Batch Status" from "batches" for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"  
    
@UpdateUserLoginStatus
Scenario: Check if user able to update user login status with  valid LMS API
    Given User creates Put request to update user login status "Update User Login Status" from "batches" for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"  

@DeleteUser
Scenario: Check if user able to delete the user valid LMS API
    Given User creates Delete reuest to delet th using "Delete User" from "batches" for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
   Then User receives "Status Code" code with response body "Status Message"   
    