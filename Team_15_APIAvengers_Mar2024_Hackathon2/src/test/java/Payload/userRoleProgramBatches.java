package Payload;

public class userRoleProgramBatches {
	String batchId;
	String userRoleProgramBatches;
	
	public userRoleProgramBatches(String id, String pbatch) {
		setBatchId(id);
		setUserRoleProgramBatches(pbatch);
	}
			
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getUserRoleProgramBatches() {
		return userRoleProgramBatches;
	}
	public void setUserRoleProgramBatches(String userRoleProgramBatches) {
		this.userRoleProgramBatches = userRoleProgramBatches;
	}

}
