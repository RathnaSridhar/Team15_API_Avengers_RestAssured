package StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import utilities.ExcelReaderData;
import utilities.ReusableVariables;


public class UserRoleProgramBatchmapSD extends ReusableVariables{
		
		RequestSpecification request;
		Response response;
		ValidatableResponse valid_resp;

	
	
		@Given("User Get request from {string} From Excel of LMS API")
		public void user_get_request_from_from_excel_of_lms_api(String feature) throws IOException {
		
		
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			 List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
			 for(int i=0;i<featureRowsMap.size();i++) {
				 Map<String, String> recordMap = featureRowsMap.get(i);
				 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
				try {
					this.response = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
							.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End Point"));
						valid_resp = response.then().log().all()
							.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
				} catch (AssertionError  e) { 
					// TODO Auto-generated catch block
					System.out.println(" AssertionError  Get all Batches ---"+ e.getLocalizedMessage());
					//e.printStackTrace();
				}

			 }
		}
		
		@Given("User Get request from {string} From Excel LMS API")
		public void user_get_request_from_from_excel_lms_api(String feature) throws IOException {
			
			// Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			 List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
			 for(int i=0;i<featureRowsMap.size();i++) {
				 Map<String, String> recordMap = featureRowsMap.get(i);
				 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
				try {
					this.response = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
							.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End Point"));
						valid_resp = response.then().log().all()
							.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
				} catch (AssertionError  e) { 
					// TODO Auto-generated catch block
					System.out.println(" AssertionError  Get all Batches ---"+ e.getLocalizedMessage());
					//e.printStackTrace();
				}

			 }
		}
		@Given("User Deletes request from {string} From Excel LMS API")
		public void user_deletes_request_from_from_excel_lms_api(String feature) throws IOException {
			List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
			 for(int i=0;i<featureRowsMap.size();i++) {
				 Map<String, String> recordMap = featureRowsMap.get(i);
				 // create batch Pojo
				// BatchPayload batchPojo = new BatchPayload();
				//batchPojo.makeBatchPayloadByMap(recordMap);
				 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
				 
				 System.out.println("Delete Batch  i ----"+i);
				 System.out.println("Delete Batch - "+recordMap.get("UserID-endpoint")+" Batch Name: "+recordMap.get("batchName")); 
				try {
					this.response = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
							.header("Content-Type","application/json").
							when().delete(ReusableVariables.baseURL+recordMap.get("End Point")+recordMap.get("UserID-endpoint"));
						valid_resp = response.then().log().all()
							.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
				} catch (AssertionError  e) { 
					// TODO Auto-generated catch block
					System.out.println(" AssertionError  user_Deletes ---"+ e.getLocalizedMessage());
					//e.printStackTrace();
					//getAssertionErrorMessage(e);
				} // catch

			 } //for
		  
		} // method
			
		}
	    

	
	


