package Payload;

import java.util.List;

public class User {
	String userComments;
	String userEduPg;
	String userEduUg;
	String userFirstName;
	String userLastName;
	String userLinkedinUrl;
	String userLocation;

	String userTimeZone;
	String userVisaStatus;
	
	userLogin userLogin;
	String userMiddleName;
	String userPhoneNumber;
	List<userRoleMaps> userRoleMaps;
	


	public User(String comments,String pg,String UG,String fname,String lname, String lkdin,String loc,userLogin userlogin, 
			String middlename,String phone,List<Payload.userRoleMaps> rolemaps,String timezone,String visa) {
		setUserComments(comments);
		setUserEduPg(pg);
		setUserEduUg(UG);
		setUserFirstName(fname);
		setUserLastName(lname);
		setUserLinkedinUrl(lkdin);
		setUserLocation(loc);
		setUserLogin(userlogin);
		setUserRoleMaps(rolemaps);
		setUserMiddleName(middlename);
		setUserPhoneNumber(phone);
		setUserTimeZone(timezone);
		setUserVisaStatus(visa);
		
	}
	public userLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(userLogin userLogin) {
		this.userLogin = userLogin;
	}

	
	public List<userRoleMaps> getUserRoleMaps() {
		return userRoleMaps;
	}
	public void setUserRoleMaps(List<userRoleMaps> userRoleMaps) {
		this.userRoleMaps = userRoleMaps;
	}
	public String getUserComments() {
		return userComments;
	}
	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}
	public String getUserEduPg() {
		return userEduPg;
	}
	public void setUserEduPg(String userEduPg) {
		this.userEduPg = userEduPg;
	}
	public String getUserEduUg() {
		return userEduUg;
	}
	public void setUserEduUg(String userEduUg) {
		this.userEduUg = userEduUg;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserLinkedinUrl() {
		return userLinkedinUrl;
	}
	public void setUserLinkedinUrl(String userLinkedinUrl) {
		this.userLinkedinUrl = userLinkedinUrl;
	}
	public String getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public String getUserTimeZone() {
		return userTimeZone;
	}
	public void setUserTimeZone(String userTimeZone) {
		this.userTimeZone = userTimeZone;
	}
	public String getUserVisaStatus() {
		return userVisaStatus;
	}
	public void setUserVisaStatus(String userVisaStatus) {
		this.userVisaStatus = userVisaStatus;
	}
	public String getUserMiddleName() {
		return userMiddleName;
	}
	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	
	}

