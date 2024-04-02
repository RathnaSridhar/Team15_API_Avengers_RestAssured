package StepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Payload.BatchPayload;
import Payload.LoginPayload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import utilities.ExcelReaderData;
import utilities.ReusableMethods;
import utilities.ReusableVariables;

public class userLoginSD extends ReusableVariables{
	ReusableMethods reuseMethods=new ReusableMethods();
	ReusableVariables reuseVariables=new ReusableVariables();
	//LoginRequestBody loginReqbody=new  LoginRequestBody();
	//ExcelReaderData read = ExcelReaderData.getInstance();
	String reqBody;
	Response loginResponse;
	ValidatableResponse valid_resp;
	//CommonValidation cv=new CommonValidation();
	
	
	@When("Admin calls Post Https method  with {string}")
	public void admin_calls_post_https_method_with(String feature) throws IOException { 

		 List<Map<String, String>> featureRowsMap = ExcelReaderData.getInstance().getRowsListByFeatureKey(feature);
		 for(int i=0;i<featureRowsMap.size();i++) {
			 Map<String, String> recordMap = featureRowsMap.get(i);
			 // create batch Pojo
			 LoginPayload loginPojo = new LoginPayload();
			 loginPojo.makeLoginPayloadByMap(recordMap);
			 
			 System.out.println("User Login  i ----"+i);
			 System.out.println("User Login - "+recordMap.get("userLoginEmailId")); 
			try {
				this.loginResponse = RestAssured.given().header("Authorization","Bearer "+ ReusableVariables.bearerToken)
						.header("Content-Type","application/json").body(loginPojo).
						when().post(ReusableVariables.baseURL+recordMap.get("End Point"));
					valid_resp = loginResponse.then().log().all()
						.assertThat().statusCode(Integer.parseInt(recordMap.get("Status Code")));
					ReusableVariables.bearerToken = loginResponse.jsonPath().get("token");
			} catch (AssertionError  e) { 
				// TODO Auto-generated catch block
				System.out.println(" AssertionError  User Login ---"+ e.getLocalizedMessage());
				//e.printStackTrace();
			}
			
		 }
		
	}

	@Given("Admin creates request with {string} credentials")
	public void admin_creates_request_with_credentials(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Admin receives {int} created with auto generated token")
	public void admin_receives_created_with_auto_generated_token(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}


}
