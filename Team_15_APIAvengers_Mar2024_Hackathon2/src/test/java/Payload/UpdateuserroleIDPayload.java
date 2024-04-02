package Payload;

import java.util.Map;

public class UpdateuserroleIDPayload {
	String userRoleStatus;
 	String roleId;
	public String getUserRoleStatus() {
		return userRoleStatus;
	}
	public void setUserRoleStatus(String userRoleStatus) {
		this.userRoleStatus = userRoleStatus;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public void makeUpdateroleIDPayload(Map<String, String> record) {
		userRoleStatus = record.get("userRoleStatus");
		roleId =  record.get("roleId");
	}
}
