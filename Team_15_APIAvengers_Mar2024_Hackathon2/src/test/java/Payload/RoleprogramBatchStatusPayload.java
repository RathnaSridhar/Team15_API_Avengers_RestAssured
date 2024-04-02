package Payload;

import java.util.List;

public class RoleprogramBatchStatusPayload {
	String programId;
	String roleId;
	List<userRoleProgramBatches> userRoleProgramBatches;
	
	public RoleprogramBatchStatusPayload(String id, String role,List<userRoleProgramBatches> userroleprogram) {
		setProgramId(id);
		setRoleId(role);
		setUserRoleProgramBatches(userroleprogram);
	}
	
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public List<userRoleProgramBatches> getUserRoleProgramBatches() {
		return userRoleProgramBatches;
	}
	public void setUserRoleProgramBatches(List<userRoleProgramBatches> userRoleProgramBatches) {
		this.userRoleProgramBatches = userRoleProgramBatches;
	}

}
