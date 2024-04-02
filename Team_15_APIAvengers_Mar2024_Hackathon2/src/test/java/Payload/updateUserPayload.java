package Payload;

import java.util.Map;

public class updateUserPayload {
	String userComments;
	String userEduPg;
	String userEduUg;
	String userFirstName;
	String userLastName;
	String userLinkedinUrl;
	String userLocation;

	String userTimeZone;
	String userVisaStatus;
	String userMiddleName;
	String userPhoneNumber; 
	
//	public updateUserPayload(String comments, String pg, String ug, String fname, String lname, String lkdin,
//			String loc, String timezone, String visa, String mname, String phone) {
//		setUserComments(comments);
//		setUserEduPg(pg);
//		setUserEduUg(ug);
//		setUserFirstName(fname);
//		setUserLastName(lname);
//		setUserLinkedinUrl(lkdin);
//		setUserLocation(loc);
//		setUserTimeZone(timezone);
//		setUserVisaStatus(visa);
//		setUserMiddleName(mname);
//		setUserPhoneNumber(phone);
//	}
	
	
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
	
	public void makeUpdateUserPayLoad(Map<String, String> record) {
		userComments = record.get("userComments");
		userEduPg = record.get("userEduPg");
		userEduUg = record.get("userEduUg");
		userFirstName = record.get("userFirstName");
		userLastName = record.get("userLastName");
		userLinkedinUrl = record.get("userLinkedinUrl");
		userLocation = record.get("userLocation");
		userMiddleName = record.get("userMiddleName");
		userPhoneNumber = record.get("userPhoneNumber");
		userTimeZone = record.get("userTimeZone");
		userVisaStatus = record.get("userVisaStatus");
	}
}
