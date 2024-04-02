package StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import Payload.ProgramPayload;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import utilities.ExcelReaderData;
import utilities.ReusableMethods;
import utilities.ReusableVariables;

public class ProgramModuleSD {
	ReusableMethods reuseMethods=new ReusableMethods();
	ReusableVariables reuseVariables=new ReusableVariables();
	
	//ExcelReaderData read = ExcelReaderData.getInstance();
	String reqBody;
	Response programResponse;
	ValidatableResponse valid_resp;
	
	@Given("Admin creates New Program {string} from {string} sheet for the LMS from Excel with request body")
	public void admin_creates_new_program_from_sheet_for_the_lms_from_excel_with_request_body(String feature, String sheetname) throws IOException {
		List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 // create batch Pojo
			 ProgramPayload programReqbody=new  ProgramPayload();
			 programReqbody.makeProgramPayloadByMap(recordMap);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 System.out.println("Excel Row S.No: "+recordMap.get("Program ID-endpoint"));
			 
			 System.out.println("New Program creatin  i ----"+i);
			try {
				this.programResponse = RestAssured.given()
						.header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").body(programReqbody).when()
						.post(ReusableVariables.baseURL+recordMap.get("End Point"));
					valid_resp = programResponse.then().log().all()
						.assertThat()
						.statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) { 
				// TODO Auto-generated catch block
				System.out.println(" AssertionError  New program  ---"+ e.getLocalizedMessage());
				//e.printStackTrace();
			}
		 }
	}
	// Get all programs
	@Given("User creates GET Request {string} from {string} sheet for the LMS API from Excel")
	public void user_creates_get_request_from_sheet_for_the_lms_api_from_excel(String feature, String sheetname) throws IOException {
		List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 System.out.println("Excel Row S.No: "+recordMap.get("Program ID-endpoint"));
			 try {
			 this.programResponse = RestAssured.given()
						.header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").when()
						.get(ReusableVariables.baseURL+recordMap.get("End Point"));
					valid_resp = programResponse.then().log().all()
						.assertThat()
						.statusCode(Integer.parseInt(recordMap.get("Status Code")));
			 } catch (AssertionError  e) { 
					// TODO Auto-generated catch block
					System.out.println(" AssertionError  Get Program by Batch ID ---"+ e.getLocalizedMessage());
					//e.printStackTrace();
				}
			 }
			 
	}
	// GET ALL PROGRAMS BY USERS
	@Given("Admin creates GET Request {string} from {string} for the LMS API from Excel")
	public void admin_creates_get_request_from_for_the_lms_api_from_excel(String feature, String string2) throws IOException {
		user_creates_get_request_from_sheet_for_the_lms_api_from_excel(feature, string2);
	}
	
	// get program by Id 
	@Given("User creates GET program by Id Request {string} from {string} sheet for the LMS API from Excel")
	public void user_creates_get_program_by_id_request_from_sheet_for_the_lms_api_from_excel(String feature, String string2) throws IOException {
		List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 System.out.println("Excel Row S.No: "+recordMap.get("Program ID-endpoint"));
			 try {
			 this.programResponse = RestAssured.given()
						.header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").when()
						.get(ReusableVariables.baseURL+recordMap.get("End Point")+recordMap.get("Program ID-endpoint"));
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

	@Given("User creates PUT Request {string} from {string} from tthe Excel")
	public void user_creates_put_request_from_from_tthe_excel(String feature, String sheetname) throws IOException {
		List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 // create batch Pojo
			 
			 ProgramPayload programPutReqbody=new  ProgramPayload();
			 programPutReqbody.makeProgramPayloadByMap(recordMap);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 System.out.println("Update Program  i ----"+i);
			 System.out.println("Update by Program ID - "+ReusableVariables.baseURL+recordMap.get("End Point") + 
					 recordMap.get("Program ID-endpoint")); 
			 
			 
			try {
				this.programResponse = RestAssured.given()
						.header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").body(programPutReqbody).when()
						.put(ReusableVariables.baseURL+recordMap
						.get("End Point")+recordMap.get("Program ID-endpoint"));
					valid_resp = programResponse.then().log().all()
						.assertThat()
						.statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) { 
				// TODO Auto-generated catch block
				System.out.println(" AssertionError  Update program by Id  ---"+ e.getLocalizedMessage());
				//e.printStackTrace();
			}
		 }
	}

	@Given("Admin creates PUT Request {string} from {string} sheet from the Excel")
	public void admin_creates_put_request_from_sheet_from_the_excel(String feature, String sheetname) throws IOException {
		List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 // create batch Pojo
			 
			 ProgramPayload programPutReqbody=new  ProgramPayload();
			 programPutReqbody.makeProgramPayloadByMap(recordMap);
			 
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 System.out.println("Update Program  i ----"+i);
			 System.out.println("Update by Program Name - "+ReusableVariables.baseURL+recordMap.get("End Point") + 
					 recordMap.get("Program ID-endpoint")); 

			 try {
				this.programResponse = RestAssured.given()
						.header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").body(programPutReqbody).when()
						.put(ReusableVariables.baseURL+recordMap
						.get("End Point")+recordMap.get("programName-Endpoint"));
					valid_resp = programResponse.then().log().all()
						.assertThat()
						.statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) { 
				// TODO Auto-generated catch block
				System.out.println(" AssertionError  User Login ---"+ e.getLocalizedMessage());
				//e.printStackTrace();
			}
		 }
	}

	@Given("Admin creates DELETE Request {string} from {string} sheet from the Excel")
	public void admin_creates_delete_request_from_sheet_from_the_excel(String feature, String sheename) throws IOException {
		List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 this.programResponse = RestAssured.given()
						.header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").when()
						.get(ReusableVariables.baseURL+recordMap.get("End Point")+ recordMap.get("Program ID-endpoint"));
					valid_resp = programResponse.then().log().all()
						.assertThat()
						.statusCode(Integer.parseInt(recordMap.get("Status Code")));
		 }
			 
	}



}