package Payload;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UpdateUserLoginStatusPayload {
	
	public String makeUpdateUserLoginStatusPayload(Map<String, String> record) {
		String payload = null;
		roleId roleIds = new roleId(record.get("Role Ids"));
		loginstatus loginStatus = new loginstatus(record.get("LoginStatus"), record.get("password"), record.get("Status"), record.get("userLoginEmailId"), roleIds);
		ObjectMapper mapper = new ObjectMapper();
		try {
			payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(loginStatus);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return payload;
	}
	
}
