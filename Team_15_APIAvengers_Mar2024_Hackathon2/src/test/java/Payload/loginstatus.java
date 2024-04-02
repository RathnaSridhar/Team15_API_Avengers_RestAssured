package Payload;

public class loginstatus {

	String loginStatus;
	String password;
	String status;
	String userLoginEmail;
	roleId roleId;
	
	public loginstatus(String login, String pwd, String status, String email, roleId id) {
		setLoginStatus(login);
		setPassword(pwd);
		setStatus(status);
		setUserLoginEmail(email);
		setRoleId(id);
	}
	
	public roleId getRoleId() {
		return roleId;
	}
	public void setRoleId(roleId roleId) {
		this.roleId = roleId;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserLoginEmail() {
		return userLoginEmail;
	}
	public void setUserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}
	
	
}
