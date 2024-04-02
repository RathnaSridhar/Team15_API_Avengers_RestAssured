package StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
import com.jayway.jsonpath.JsonPath;

import Payload.BatchPayload;
import Payload.UpdateUserLoginStatusPayload;
import Payload.UpdateuserroleIDPayload;
import Payload.User;
import Payload.UserpayloadHelper;
import Payload.updateUserPayload;
import Payload.userRoleBatchStatusPayload;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import utilities.CommonValidation;
import utilities.ExcelReaderData;
import utilities.ReusableMethods;
import utilities.ReusableVariables;

public class UserModuleStepDefinition extends ReusableVariables {
	ReusableMethods reuseMethods=new ReusableMethods();
	ReusableVariables reuseVariables=new ReusableVariables();
	CommonValidation cv=new CommonValidation();
	Response UserResponse;
	ValidatableResponse valid_resp;
	 List<Map<String, String>> featureRowsMap;
	 UserpayloadHelper userpayload = new UserpayloadHelper();
	String reqbody;
	 
	@Given("Admin creates New User {string} from {string} sheet for the LMS API From Excel")
	public void admin_creates_new_user_from_sheet_for_the_lms_api_from_excel(String feature, String sheetname) {

		 List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 // create batch Pojo
			 
			 try {
				 
				 reqbody = userpayload.makeUserPayloadByMap(recordMap);
				
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 System.out.println("Create User i ----"+i);
			 System.out.println("Create User - "+recordMap.get("roleId")); 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").body(reqbody).
						when().post(ReusableVariables.baseURL+recordMap.get("End Point"));
					valid_resp = UserResponse.then()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			
					
			} catch (AssertionError  e) { 
				// TODO Auto-generated catch block
				System.out.println(" AssertionError  Get all Batches ---"+ e.getLocalizedMessage());
				e.printStackTrace();
			}

		 }
		
	}

	@Given("User creates Get request to {string} from {string} sheet for the LMS API From Excel")
	public void user_creates_get_request_to_from_sheet_for_the_lms_api_from_excel(String feature, String sheetname) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 System.out.println("i ----"+i);
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 System.out.println("Get All users - ");
			 System.out.println("Get All users - "+ReusableVariables.baseURL+recordMap.get("End Point")
				+recordMap.get("userFirstName"));
			 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End Point"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) {
				// TODO Auto-generated catch block
				System.out.println("AssertionError get by Batch ID: "+ e.getLocalizedMessage());
			}

		 }
		
	}

	@Given("User creates Get request to get user by UserID with {string} from {string} sheet for the LMS API From Excel")
	public void user_creates_get_request_to_get_user_by_user_id_with_from_sheet_for_the_lms_api_from_excel(String feature, String sheetname) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 System.out.println("i ----"+i);
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 System.out.println("Get user by ID  - "+recordMap.get("UserID-endpoint"));
			 System.out.println("Get users by ID - "+ReusableVariables.baseURL+recordMap.get("End Point")
				+recordMap.get("UserID-endpoint")); // C.ERR
			 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End Point")+recordMap.get("UserID-endpoint"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) {
				// TODO Auto-generated catch block
				System.out.println("AssertionError get by Batch ID: "+ e.getLocalizedMessage());
			}

		 }
	}

	@Given("User creates Get request to get user with roles with {string} from {string} sheet for the LMS API From Excel")
	public void user_creates_get_request_to_get_user_with_roles_with_from_sheet_for_the_lms_api_from_excel(String feature, String sheetname) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 System.out.println("i ----"+i);
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 System.out.println("Get All users with roles - "+recordMap.get("batchID-Endpoint"));
			 System.out.println("Get All users with roles - "+ReusableVariables.baseURL+recordMap.get("End Point"));
			 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End Point"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) {
				// TODO Auto-generated catch block
				System.out.println("AssertionError get by Batch ID: "+ e.getLocalizedMessage());
			}

		 }
	}

	@Given("User created get request to {string} from {string} sheet for the LMS API From Excel")
	public void user_created_get_request_to_from_sheet_for_the_lms_api_from_excel(String feature, String batches) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 System.out.println("i ----"+i);
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 System.out.println("Get count of active and inactive users - "+recordMap.get("batchID-Endpoint"));
			 System.out.println("Get count of active and inactive users - "+ReusableVariables.baseURL+recordMap.get("End Point"));
			 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End point"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) {
				// TODO Auto-generated catch block
				System.out.println("AssertionError get by Batch ID: "+ e.getLocalizedMessage());
			}

		 }
	}

	@Given("User creates Get request to get all the users with program batch {string} from {string} sheet for the LMS API From Excel")
	public void user_creates_get_request_to_get_all_the_users_with_program_batch_from_sheet_for_the_lms_api_from_excel(String feature, String sheetname) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 System.out.println("i ----"+i);
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 System.out.println("Get users by program batches - "+recordMap.get("batchID-Endpoint"));
			 System.out.println("Get users by program batches - "+ReusableVariables.baseURL+recordMap.get("End Point"));
			 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End point")+recordMap.get("batchID-Endpoint"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) {
				// TODO Auto-generated catch block
				System.out.println("AssertionError get by Batch ID: "+ e.getLocalizedMessage());
			}

		 }
	}

	@Given("User creates Get request to retrieve the users for program with program ID {string} from {string} sheet for the LMS API From Excel")
	public void user_creates_get_request_to_retrieve_the_users_for_program_with_program_id_from_sheet_for_the_lms_api_from_excel(String feature, String batches) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 System.out.println("i ----"+i);
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 System.out.println("Get users for program with program id - "+recordMap.get("batchID-Endpoint"));
			 System.out.println("Get users by program with program id - "+ReusableVariables.baseURL+recordMap.get("End Point"));
			 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End point"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) {
				// TODO Auto-generated catch block
				System.out.println("AssertionError get by Batch ID: "+ e.getLocalizedMessage());
			}

		 }
	}

	@Given("User creates Get request to retrieve the users by roleID {string} sheet for the LMS API From {string} Excel")
	public void user_creates_get_request_to_retrieve_the_users_by_role_id_sheet_for_the_lms_api_from_excel(String feature, String batches) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 System.out.println("i ----"+i);
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 System.out.println("Get user by Role ID - "+recordMap.get("batchID-Endpoint"));
			 System.out.println("Get users by Role ID - "+ReusableVariables.baseURL+recordMap.get("End Point"));
			 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End point")+recordMap.get("roleId"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) {
				// TODO Auto-generated catch block
				System.out.println("AssertionError get by Batch ID: "+ e.getLocalizedMessage());
			}

		 }
	}

	@Given("User creates Get request to retrieve all the active users {string} from {string} sheet for the LMS API From Excel")
	public void user_creates_get_request_to_retrieve_all_the_active_users_from_sheet_for_the_lms_api_from_excel(String feature, String batches) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 System.out.println("i ----"+i);
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 System.out.println("Get all active users- ");
			 System.out.println("Get all active users - "+ReusableVariables.baseURL+recordMap.get("End Point"));
			 										
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End point"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) {
				// TODO Auto-generated catch block
				System.out.println("AssertionError get by Batch ID: "+ e.getLocalizedMessage());
			}

		 }
	}


	@Given("User creates Get request to retrieve users by role ID V2 {string} from {string} sheet for the LMS API From Excel")
	public void user_creates_get_request_to_retrieve_users_by_role_id_v2_from_sheet_for_the_lms_api_from_excel(String feature, String batches) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 System.out.println("i ----"+i);
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 System.out.println("Get all active users- ");
			 System.out.println("Get all active users - "+ReusableVariables.baseURL+recordMap.get("End Point"));
			 										
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").when().get(ReusableVariables.baseURL+recordMap.get("End point"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) {
				// TODO Auto-generated catch block
				System.out.println("AssertionError get by Batch ID: "+ e.getLocalizedMessage());
			}

		 }
	}

	@Given("User creates Put request to update user by userID {string} from {string} sheet for the LMS API From Excel")
	public void user_creates_put_request_to_update_user_by_user_id_from_sheet_for_the_lms_api_from_excel(String feature, String batches) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 // create batch Pojo
			 updateUserPayload putpayload = new updateUserPayload();
			 putpayload.makeUpdateUserPayLoad(recordMap);
			 
			 System.out.println("Create Batch i ----"+i);
			 System.out.println("Create Batch name - "+recordMap.get("batchName")); 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").body(putpayload).
						when().put(ReusableVariables.baseURL+recordMap.get("End Point")+recordMap.get("UserID-endpoint"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) { 
				// TODO Auto-generated catch block
				System.out.println(" AssertionError  Get all Batches ---"+ e.getLocalizedMessage());
				//e.printStackTrace();
			}

		 }
		
	}

	@Given("User creates Put request to update users RoleStatus by UserID {string} from {string} sheet for the LMS API From Excel")
	public void user_creates_put_request_to_update_users_role_status_by_user_id_from_sheet_for_the_lms_api_from_excel(String feature, String batches) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 // create batch Pojo
			 UpdateuserroleIDPayload putpayload = new UpdateuserroleIDPayload();
			 putpayload.makeUpdateroleIDPayload(recordMap);
			 
			 System.out.println("Update user role status i ----"+i);
			 System.out.println("Update user role status- "); 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").body(putpayload).
						when().put(ReusableVariables.baseURL+recordMap.get("End Point")+recordMap.get("UserID-endpoint"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) { 
				// TODO Auto-generated catch block
				System.out.println(" AssertionError  Get all Batches ---"+ e.getLocalizedMessage());
				//e.printStackTrace();
			}

		 }
		
	}

	@Given("User creates Put request to update users role ID by UserID {string} from {string} for the LMS API From Excel")
	public void user_creates_put_request_to_update_users_role_id_by_user_id_from_for_the_lms_api_from_excel(String feature, String batches) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 // create batch Pojo
			 UpdateuserroleIDPayload putpayload = new UpdateuserroleIDPayload();
			 putpayload.makeUpdateroleIDPayload(recordMap);
			 
			 System.out.println("Update roleID i ----"+i);
			 System.out.println("Update role ID - "); 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").body(putpayload).
						when().put(ReusableVariables.baseURL+recordMap.get("End Point")+recordMap.get("UserID-endpoint"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) { 
				// TODO Auto-generated catch block
				System.out.println(" AssertionError  Get all Batches ---"+ e.getLocalizedMessage());
				//e.printStackTrace();
			}

		 }
	}

	@Given("User creates Put request to assign the user role program batch status using userID {string} from {string} for the LMS API From Excel")
	public void user_creates_put_request_to_assign_the_user_role_program_batch_status_using_user_id_from_for_the_lms_api_from_excel(String feature, String batches) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 // create batch Pojo
			 userRoleBatchStatusPayload putpayload = new userRoleBatchStatusPayload();
			 reqbody = putpayload.makeUserRoleBatchStatusPayload(recordMap);
			System.out.println( reqbody);
			 System.out.println("Update roleID i ----"+i);
			 System.out.println("Update role ID - "); 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").body(reqbody).
						when().put(ReusableVariables.baseURL+recordMap.get("End Point")+recordMap.get("UserID-endpoint"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) { 
				// TODO Auto-generated catch block
				System.out.println(" AssertionError  Get all Batches ---"+ e.getLocalizedMessage());
				//e.printStackTrace();
			}

		 }
	}

	@Given("User creates Put request to update user login status {string} from {string} for the LMS API From Excel")
	public void user_creates_put_request_to_update_user_login_status_from_for_the_lms_api_from_excel(String feature, String batches) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 // create batch Pojo
			 UpdateUserLoginStatusPayload putpayload = new UpdateUserLoginStatusPayload();
			 reqbody = putpayload.makeUpdateUserLoginStatusPayload(recordMap);
			System.out.println( reqbody);
			 System.out.println("Update login status i ----"+i);
			 System.out.println("Update login status- "); 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").body(reqbody).
						when().put(ReusableVariables.baseURL+recordMap.get("End Point")+recordMap.get("UserID-endpoint"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) { 
				// TODO Auto-generated catch block
				System.out.println(" AssertionError  Get all Batches ---"+ e.getLocalizedMessage());
				//e.printStackTrace();
			}

		 }
	}

	@Given("User creates Delete reuest to delet th using {string} from {string} for the LMS API From Excel")
	public void user_creates_delete_reuest_to_delet_th_using_from_for_the_lms_api_from_excel(String feature, String batches) {
		List<Map<String, String>> featureRowsMap = null;
		try {
			featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 // create batch Pojo
			// BatchPayload batchPojo = new BatchPayload();
			//batchPojo.makeBatchPayloadByMap(recordMap);
			 System.out.println("Excel Row S.No: "+recordMap.get("S.no"));
			 
			 System.out.println("Delete User  i ----"+i);
			 System.out.println("Delete User - "+recordMap.get("userID-Endpoint")); 
			try {
				this.UserResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").
						when().delete(ReusableVariables.baseURL+recordMap.get("End Point")+recordMap.get("userID-Endpoint"));
					valid_resp = UserResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
			} catch (AssertionError  e) { 
				// TODO Auto-generated catch block
				System.out.println(" AssertionError  user_Deletes ---"+ e.getLocalizedMessage());
				//e.printStackTrace();
				//getAssertionErrorMessage(e);
			} // catch

		 } //for
	  
	}



}
