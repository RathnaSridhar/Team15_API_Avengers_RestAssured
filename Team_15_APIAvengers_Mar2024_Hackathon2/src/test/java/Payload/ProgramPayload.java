package Payload;

import java.util.Map;

public class ProgramPayload {
	int programId;
	String programName;
	String programDescription;
	String programStatus;
	
	
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
	public String getProgramStatus() {
		return programStatus;
	}
	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}
	
	public void makeProgramPayloadByMap(Map<String, String> record) {
		programName = record.get("Program Name");
		programName = programName + System.currentTimeMillis(); // keeping a random value to make it unique
		programStatus = record.get("Program Status");
		programDescription = record.get("Program Description");
		
		if(!"".equals(record.get("Program ID-endpoint"))){
			try {
				programId = Integer.parseInt(record.get("Program ID-endpoint"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
	
	}
	}
}
