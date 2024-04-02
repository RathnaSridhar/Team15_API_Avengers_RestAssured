package StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;



import Payload.BatchPayload;
import Payload.LmsE2EPayload;
import Payload.ProgramPayload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import utilities.ExcelReaderData;
import utilities.ReusableMethods;
import utilities.ReusableVariables;

public class End_To_EndSD {
	
	
	ReusableMethods reuseMethods=new ReusableMethods();
	ReusableVariables reuseVariables=new ReusableVariables();
	
	//ExcelReaderData read = ExcelReaderData.getInstance();
	String programReqBody;
	Response programResponse;
	String batchReqBody;
	Response batchResponse;
	ValidatableResponse valid_resp;
	
		
		@Given("Admin first creates New Program {string} for the LMS from Excel with request body")
		public void admin_first_creates_new_program_for_the_lms_from_excel_with_request_body(String feature) throws IOException {
			
			List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
			 for(int i=0;i<featureRowsMap.size();i++) {
				 Map<String, String> recordMap = featureRowsMap.get(i);
				 // create batch Pojo
				 ProgramPayload programReqbody=new  ProgramPayload();
				 programReqbody.makeProgramPayloadByMap(recordMap);
				 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
				 //System.out.println("Excel Row S.No: "+recordMap.get("Program ID-endpoint"));
				 utilities.LoggerLoad.info("Create New Program - Excel Row S.No: "+recordMap.get("S.no"));
				 System.out.println("New Program creatin  i ----"+i);
				try {
					this.programResponse = RestAssured.given()
							.header("Authorization","Bearer "+ ReusableVariables.bearerToken)
							.header("Content-Type","application/json").body(programReqbody).when()
							.post(ReusableVariables.baseURL+recordMap.get("End Point"));
						valid_resp = programResponse.then().log().all()
							.assertThat()
							.statusCode(Integer.parseInt(recordMap.get("Status Code")));
						
						System.out.println("---- Created Program Id - " +programResponse.jsonPath().getInt("programId"));
						LmsE2EPayload.getProgram().setProgramId(programResponse.jsonPath().getInt("programId"));
						utilities.LoggerLoad.info("New Program Created. Program Id : "+programResponse.jsonPath().getInt("programId"));
						
				} catch (AssertionError  e) { 
					// TODO Auto-generated catch block
					System.out.println(" AssertionError  Valid New program  ---"+ e.getLocalizedMessage());
					//e.printStackTrace();
				}
			 }
			
		}
		
		@Then("Admin makes get program by Id GET Request {string} for the LMS API from Excel")
		public void admin_makes_get_program_by_id_get_request_for_the_lms_api_from_excel(String feature) throws IOException {
			List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
			 for(int i=0;i<featureRowsMap.size();i++) {
				 Map<String, String> recordMap = featureRowsMap.get(i);
				 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
				 System.out.println("Excel Row S.No: "+recordMap.get("Program ID-endpoint"));
				 try {
				 this.programResponse = RestAssured.given()
							.header("Authorization","Bearer "+ ReusableVariables.bearerToken)
							.header("Content-Type","application/json").when()
							.get(ReusableVariables.baseURL+recordMap.get("End Point")+
									LmsE2EPayload.getProgram().getProgramId());
						valid_resp = programResponse.then().log().all()
							.assertThat()
							.statusCode(Integer.parseInt(recordMap.get("Status Code")));
						utilities.LoggerLoad.info("New Program Created get by Id: "+LmsE2EPayload.getProgram().getProgramId());
				 } catch (AssertionError  e) { 
						// TODO Auto-generated catch block
						System.out.println(" AssertionError  Get Program by ID ---"+ e.getLocalizedMessage());
						//e.printStackTrace();
					}
			 }
			
			
		 }
		
		
		
		
		@When("Admin updates Program with PUT request {string} from the Excel")
		public void admin_updates_program_with_put_request_from_the_excel(String feature) throws IOException {
			List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
			 for(int i=0;i<featureRowsMap.size();i++) {
				 Map<String, String> recordMap = featureRowsMap.get(i);
				 // create batch Pojo
				 
				 ProgramPayload programPutReqbody=new  ProgramPayload();
				 programPutReqbody.makeProgramPayloadByMap(recordMap);
				 programPutReqbody.setProgramDescription("E2E_PRG_"+programPutReqbody.getProgramDescription());
				 programPutReqbody.setProgramId(LmsE2EPayload.getProgram().getProgramId());
				 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
				 System.out.println("Update Program  i ----"+i);
				 System.out.println("E2E Valid Update by Program ID - "+ReusableVariables.baseURL+recordMap.get("End Point") + 
						 LmsE2EPayload.getProgram().getProgramId()); 
				 
				 
				try {
					this.programResponse = RestAssured.given()
							.header("Authorization","Bearer "+ ReusableVariables.bearerToken)
							.header("Content-Type","application/json").body(programPutReqbody).when()
							.put(ReusableVariables.baseURL+recordMap
							.get("End Point")+LmsE2EPayload.getProgram().getProgramId());
						valid_resp = programResponse.then().log().all()
							.assertThat()
							.statusCode(Integer.parseInt(recordMap.get("Status Code")));
				} catch (AssertionError  e) { 
					// TODO Auto-generated catch block
					System.out.println(" AssertionError  E2E valid Update program by Id  ---"+ e.getLocalizedMessage());
					//e.printStackTrace();
				}
			 }

		}
		
		@Given("Admin first creates New Batch {string} for the LMS API From Excel")
		public void admin_first_creates_new_batch_for_the_lms_api_from_excel(String feature) throws IOException {
			 List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
			 for(int i=0;i<featureRowsMap.size();i++) {
				 Map<String, String> recordMap = featureRowsMap.get(i);
				 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
				 
				 // create batch Pojo
				 BatchPayload batchPojo = new BatchPayload();
				 batchPojo.makeBatchPayloadByMap(recordMap);
				 batchPojo.setBatchName(batchPojo.getBatchName()+System.currentTimeMillis());
				 batchPojo.setProgramId(LmsE2EPayload.getProgram().getProgramId());
				 
				 System.out.println("Create Batch i ----"+i);
				 System.out.println("Create Batch name - "+recordMap.get("batchName")); 
				try {
					this.batchResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
							.header("Content-Type","application/json").body(batchPojo).
							when().post(ReusableVariables.baseURL+recordMap.get("End Point"));
						valid_resp = batchResponse.then().log().all()
							.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
						
						LmsE2EPayload.getBatch().setBatchId(batchResponse.jsonPath().getInt("batchId"));
						System.out.println("---- E2E Created Batch Id - " +LmsE2EPayload.getBatch().getBatchId());
						
				} catch (AssertionError  e) { 
					// TODO Auto-generated catch block
					System.out.println(" AssertionError  Get all Batches ---"+ e.getLocalizedMessage());
					//e.printStackTrace();
				}
			 }
		}
		
		@Then("Admin makes get batch by GET batchId Request {string} for the LMS API From Excel")
		public void admin_makes_get_batch_by_get_batch_id_request_for_the_lms_api_from_excel(String feature) throws IOException {
			 List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
			 for(int i=0;i<featureRowsMap.size();i++) {
				 Map<String, String> recordMap = featureRowsMap.get(i);
				 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
				 System.out.println("E2E Valid Get by Batch ID - "+ReusableVariables.baseURL+ recordMap.get("End Point")+
						 LmsE2EPayload.getBatch().getBatchId());				 
				try {
					this.batchResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
							.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End Point")+
									LmsE2EPayload.getBatch().getBatchId());
						valid_resp = batchResponse.then().log().all()
							.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
				} catch (AssertionError  e) { 
					// TODO Auto-generated catch block
					System.out.println(" AssertionError  Get all Batches ---"+ e.getLocalizedMessage());
					//e.printStackTrace();
				}

			 }			
		}
		
		@When("Admin updates Batch with PUT request {string} from the Excel")
		public void admin_updates_batch_with_put_request_from_the_excel(String feature) throws IOException {
			
			List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
			 for(int i=0;i<featureRowsMap.size();i++) {
				 Map<String, String> recordMap = featureRowsMap.get(i);
				 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
				 
				 // create batch Pojo
				 BatchPayload batchPojo = new BatchPayload();
				 batchPojo.makeBatchPayloadByMap(recordMap);
				 batchPojo.setBatchDescription("E2E_BCH_"+batchPojo.getBatchDescription());
				 batchPojo.setBatchId(LmsE2EPayload.getBatch().getBatchId());
				 batchPojo.setProgramId(LmsE2EPayload.getProgram().getProgramId());
				 System.out.println("Update E2E Batch Put i ----"+i);
				 System.out.println("Update E2E Batch Put - "+LmsE2EPayload.getBatch().getBatchId()+" Batch Name: "+
						 batchPojo.getBatchName()); 
				try {
					this.batchResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
							.header("Content-Type","application/json").body(batchPojo).
							when().put(ReusableVariables.baseURL+recordMap.get("End Point")+LmsE2EPayload.getBatch().getBatchId());
						valid_resp = batchResponse.then().log().all()
							.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
				} catch (AssertionError  e) { 
					// TODO Auto-generated catch block
					System.out.println(" AssertionError  user_updates put ---"+ e.getLocalizedMessage());
					//e.printStackTrace();
				} // catch

			 } //for
		   
		 
		}
		
		@Given("Admin Deletes Batch by BatchId with GET request {string} for the LMS API From Excel")
		public void admin_deletes_batch_by_batch_id_with_get_request_for_the_lms_api_from_excel(String feature) throws IOException {
			List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
			 for(int i=0;i<featureRowsMap.size();i++) {
				 Map<String, String> recordMap = featureRowsMap.get(i);
				 // create batch Pojo
				// BatchPayload batchPojo = new BatchPayload();
				//batchPojo.makeBatchPayloadByMap(recordMap);
				 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
				 
				 System.out.println("Delete Batch  i ----"+i);
				 System.out.println("Delete Batch - "+LmsE2EPayload.getBatch().getBatchId()); 
				try {
					this.batchResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
							.header("Content-Type","application/json").
							when().delete(ReusableVariables.baseURL+recordMap.get("End Point")+
									LmsE2EPayload.getBatch().getBatchId());
						valid_resp = batchResponse.then().log().all()
							.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
				} catch (AssertionError  e) { 
					// TODO Auto-generated catch block
					System.out.println(" AssertionError  user_Deletes ---"+ e.getLocalizedMessage());
					//e.printStackTrace();
					//getAssertionErrorMessage(e);
				} // catch

			 } //for

		}
		
		@Then("Admin Deletes Program by ProgramID with GET request {string} for the LMS API From Excel")
		public void admin_deletes_program_by_program_id_with_get_request_for_the_lms_api_from_excel(String feature) throws IOException {
			List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
			 for(int i=0;i<featureRowsMap.size();i++) {
				 Map<String, String> recordMap = featureRowsMap.get(i);
				 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
				 
				 System.out.println("Delete Program  i ----"+i);
				 System.out.println("Delete program- "+LmsE2EPayload.getProgram().getProgramId()); 
				 System.out.println("E2E Valid delete program by Id - "+ReusableVariables.baseURL+ recordMap.get("End Point")+
						 LmsE2EPayload.getProgram().getProgramId());				 
				 
				 try {
				 this.programResponse = RestAssured.given()
							.header("Authorization","Bearer "+ ReusableVariables.bearerToken)
							.header("Content-Type","application/json").when()
							.delete(ReusableVariables.baseURL+recordMap.get("End Point")+ LmsE2EPayload.getProgram().getProgramId());
						valid_resp = programResponse.then().log().all()
							.assertThat()
							.statusCode(Integer.parseInt(recordMap.get("Status Code")));
						
			 } catch (AssertionError  e) { 
					// TODO Auto-generated catch block
					System.out.println(" AssertionError  Get Program by ID ---"+ e.getLocalizedMessage());
					//e.printStackTrace();
				}
			 }

			
		}
	
	
	
}
	

