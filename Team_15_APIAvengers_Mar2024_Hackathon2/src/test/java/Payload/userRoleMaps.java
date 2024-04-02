package Payload;

public class userRoleMaps {

	String roleId;
	String userRoleStatus;
	
	public userRoleMaps() {
		
	}
	public userRoleMaps(String id, String status) {
		setRoleId(id);
		setUserRoleStatus(status);
	}
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserRoleStatus() {
		return userRoleStatus;
	}
	public void setUserRoleStatus(String userRoleStatus) {
		this.userRoleStatus = userRoleStatus;
	}
	
}
