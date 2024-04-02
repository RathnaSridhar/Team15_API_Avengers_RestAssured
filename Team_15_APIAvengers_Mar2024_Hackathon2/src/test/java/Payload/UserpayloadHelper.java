package Payload;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.RequestPayload;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserpayloadHelper{
	
	public String makeUserPayloadByMap(Map<String, String> record) throws JsonProcessingException {
        userLogin userLogin = new userLogin(record.get("LoginStatus"), record.get("password"), record.get("userLoginEmailId"));
        userRoleMaps userRoleMaps = new userRoleMaps(record.get("roleId"), record.get("userRoleStatus"));
        List<userRoleMaps> userRoleMapsList = Arrays.asList(userRoleMaps);
        User userpayload = new User(record.get("userComments"), record.get("userEduPg"), record.get("userEduUg"), record.get("userFirstName"),
        		record.get("userLastName"), record.get("userLinkedinUrl"), 
        		record.get("userLocation"), userLogin,
        		record.get("userMiddleName"), 
        		record.get("userPhoneNumber"), userRoleMapsList,record.get("userTimeZone"),record.get("userVisaStatus"));
//		S

    	
    	
		
    	ObjectMapper mapper = new ObjectMapper();
    	String payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userpayload);
    	
    	return payload;
    	
//         ObjectMapper objectmapper = new ObjectMapper();
//         String payload = null;
//         try {
//			payload = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(userpayload);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
 
    }

	}

