package StepDefinition;


import java.io.IOException;
import java.util.List;
import java.util.Map;

//import Endpoints.Routes;
import Payload.BatchPayload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import utilities.ExcelReaderData;
import utilities.ReusableVariables;

	public class BatchSD extends ReusableVariables{
		
		RequestSpecification request;
		Response response;
		ValidatableResponse valid_resp;
	

@Given("User creates request for the LMS API endpoint")
public void user_creates_request_for_the_lms_api_endpoint() {
	
	
}

@When("User creates GET Request for the LMS API endpoint")
public void user_creates_get_request_for_the_lms_api_endpoint() {
	//RestAssured.baseURI = Routes.get_AllBatches; 
	this.response = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
			.header("Content-Type","application/json").when().get(ReusableVariables.get_AllBatches);
}

@Then("User receives {int} status code with response body")
public void user_receives_status_code_with_response_body(Integer int1) {
	
	valid_resp = response.then().log().all()
			.assertThat().statusCode(200);
	
}
@Given("User creates New Batch {string} from {string} sheet for the LMS API From Excel")
public void user_creates_New_Batch_from_sheet_for_the_lms_api_from_excel(String feature, String sheetName) throws IOException {
	
	 List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
	 for(int i=0;i<featureRowsMap.size();i++) {
		 Map<String, String> recordMap = featureRowsMap.get(i);
		 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
		 
		 // create batch Pojo
		 BatchPayload batchPojo = new BatchPayload();
		 batchPojo.makeBatchPayloadByMap(recordMap);
		 
		 System.out.println("Create Batch i ----"+i);
		 System.out.println("Create Batch name - "+recordMap.get("batchName")); 
		try {
			this.response = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
					.header("Content-Type","application/json").body(batchPojo).
					when().post(ReusableVariables.baseURL+recordMap.get("End Point"));
				valid_resp = response.then().log().all()
					.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
		} catch (AssertionError  e) { 
			// TODO Auto-generated catch block
			System.out.println(" AssertionError  Get all Batches ---"+ e.getLocalizedMessage());
			//e.printStackTrace();
		}
	 }
}

@Given("User creates get request for {string} from {string} sheet for the LMS API From Excel")
public void user_creates_get_request_for_from_sheet_for_the_lms_api_from_excel(String feature, String sheetName) throws IOException {
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

@Given("User get request from batch get by batchId {string} from {string} sheet for the LMS API From Excel")
public void user_creates_request_get_by_batch_id_from_sheet_for_the_lms_api_from_excel(String feature, String sheetName) throws IOException {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	
	 List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
	 for(int i=0;i<featureRowsMap.size();i++) {
		 System.out.println("i ----"+i);
		 Map<String, String> recordMap = featureRowsMap.get(i);
		 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
		 
		 System.out.println("Get By Batch ID - "+recordMap.get("batchID-Endpoint"));
		 System.out.println("Get By Batch ID URL - "+ReusableVariables.baseURL+recordMap.get("End Point")
			+recordMap.get("batchID-Endpoint"));
		 
		try {
			this.response = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
					.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End Point")
					+recordMap.get("batchID-Endpoint"));
				valid_resp = response.then().log().all()
					.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
		} catch (AssertionError  e) {
			// TODO Auto-generated catch block
			System.out.println("AssertionError get by Batch ID: "+ e.getLocalizedMessage());
		}

	 }
	
}

@When("User requests to Get {string} Request for the LMS API {string}")
public void user_requests_to_get_request_for_the_lms_api(String string, String string2) {
    
}

@Then("User receives {string} code with response body {string}")
public void user_receives_code_with_response_body(String string, String string2) {
  
}


@Given("User get request from batch get by BatchName {string} from {string} sheet for the LMS API From Excel")
public void user_get_request_from_batch_get_by_batch_name_from_sheet_for_the_lms_api_from_excel(String feature, String sheetName) throws IOException {
	
	 List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
	 for(int i=0;i<featureRowsMap.size();i++) {
		 Map<String, String> recordMap = featureRowsMap.get(i);
		 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
		 
		 System.out.println("Get By Batch ID - "+recordMap.get("batchID-Endpoint"));
		try {
			this.response = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
					.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End Point")
					+recordMap.get("batchName-Endpoint"));
				valid_resp = response.then().log().all()
					.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
		} catch (AssertionError  e) { 
			// TODO Auto-generated catch block
			System.out.println(" AssertionError  get_by_batch_name ---"+ e.getLocalizedMessage());
			//e.printStackTrace();
		} // 
	
	 }
		
}
@Given("User Updates Batch by BatchId {string} from {string} sheet for the LMS API From Excel")
public void user_updates_batch_by_batch_id_from_sheet_for_the_lms_api_from_excel(String feature, String sheetName) throws IOException {
			
			List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
			 for(int i=0;i<featureRowsMap.size();i++) {
				 Map<String, String> recordMap = featureRowsMap.get(i);
				 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
				 
				 // create batch Pojo
				 BatchPayload batchPojo = new BatchPayload();
				 batchPojo.makeBatchPayloadByMap(recordMap);
				 
				 System.out.println("Update Batch Put i ----"+i);
				 System.out.println("Update Batch Put - "+recordMap.get("batchID-Endpoint")+" Batch Name: "+recordMap.get("batchName")); 
				try {
					this.response = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
							.header("Content-Type","application/json").body(batchPojo).
							when().put(ReusableVariables.baseURL+recordMap.get("End Point")+recordMap.get("batchID-Endpoint"));
						valid_resp = response.then().log().all()
							.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
				} catch (AssertionError  e) { 
					// TODO Auto-generated catch block
					System.out.println(" AssertionError  user_updates put ---"+ e.getLocalizedMessage());
					//e.printStackTrace();
				} // catch

			 } //for
		   
		} // method



@Given("User Deletes Batch by BatchId {string} from {string} sheet for the LMS API From Excel")
public void user_deletes_batch_by_batch_id_from_sheet_for_the_lms_api_from_excel(String feature, String sheetName) throws IOException {
	
	List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
	 for(int i=0;i<featureRowsMap.size();i++) {
		 Map<String, String> recordMap = featureRowsMap.get(i);
		 // create batch Pojo
		// BatchPayload batchPojo = new BatchPayload();
		//batchPojo.makeBatchPayloadByMap(recordMap);
		 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
		 
		 System.out.println("Delete Batch  i ----"+i);
		 System.out.println("Delete Batch - "+recordMap.get("batchID-Endpoint")+" Batch Name: "+recordMap.get("batchName")); 
		try {
			this.response = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
					.header("Content-Type","application/json").
					when().delete(ReusableVariables.baseURL+recordMap.get("End Point")+recordMap.get("batchID-Endpoint"));
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

public String getAssertionErrorMessage(AssertionError e) {
	String str = "";
	StackTraceElement[] st = e.getStackTrace();
	if(st == null) return str;
	for(int i=0;i<st.length;i++) {
		System.out.println("for i "+i+"\tLine Number:"+ st[i].getLineNumber()+" TOSTR: "+st[i].toString());
	}// for
	
	return str;
}
  
}


  
