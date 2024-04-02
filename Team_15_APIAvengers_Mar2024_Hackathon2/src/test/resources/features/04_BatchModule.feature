Feature: Batch Module

  Background: Check if Admin able to generate token with valid credential
    Given Admin creates request with "valid" credentials
    When Admin calls Post Https method  with "User Sign In"
    Then Admin receives 200 created with auto generated token

  @CreateNewBatch
  Scenario: Check if user able to retrieve all batches  with valid LMS API
    Given User creates New Batch "Create New Batch" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"

  @05GetAllBatches
  Scenario: Check if user able to retrieve all batches  with valid LMS API
    Given User creates get request for "GET All Batches" from "<batches>" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"

  @05GetBatchById
  Scenario: Check if user able to retrieve all batches  with valid LMS API
    Given User get request from batch get by batchId "GET Batch by BatchId" from "<batches>" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"

  @05GetBatchByName
  Scenario: Check if user able to retrieve all batches  with valid LMS API
    Given User get request from batch get by BatchName "GET Batch by BatchName" from "<batches>" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"

  @PutRequestUpdateBybatchId
  Scenario: Check if user able to retrieve all batches  with valid LMS API
    Given User Updates Batch by BatchId "Update by Batch Id" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"

  @PutRequestUpdateBybatchId
  Scenario: Check if user able to retrieve all batches  with valid LMS API
    Given User Deletes Batch by BatchId "Delete batch by BatchId" from "batches" sheet for the LMS API From Excel
    When User requests to Get "CRUD Operation" Request for the LMS API "End Point"
    Then User receives "Status Code" code with response body "Status Message"
