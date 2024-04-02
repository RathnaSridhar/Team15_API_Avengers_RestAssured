package Payload;



public class userLogin {
	String loginStatus;
	String password;
	String userLoginEmail;
	
	public userLogin(){
		
	}
	
	public userLogin(String ls, String psswd, String email) {
		setLoginStatus(ls);
		setPassword(psswd);
		setUserLoginEmail(email);
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
	public String getUserLoginEmail() {
		return userLoginEmail;
	}
	public void setUserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}
	
	
}
