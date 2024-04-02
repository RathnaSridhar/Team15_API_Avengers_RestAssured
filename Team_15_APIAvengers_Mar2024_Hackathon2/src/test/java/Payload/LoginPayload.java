package Payload;

import java.util.Map;

public class LoginPayload {

	private String password;
	private String userLoginEmailId;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserLoginEmailId() {
		return userLoginEmailId;
	}
	public void setUserLoginEmailId(String userLoginEmailId) {
		this.userLoginEmailId = userLoginEmailId; 
	}
	public void makeLoginPayloadByMap(Map<String, String> record) {
		userLoginEmailId = record.get("userLoginEmailId");
		password = record.get("password");

		
	}
}
