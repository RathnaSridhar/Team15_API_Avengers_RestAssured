package Payload;

import java.util.Map; 

public class BatchPayload {
	int batchId;
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	String batchDescription;
	String batchName;
	int  batchNoOfClasses;
	String batchStatus;
	int programId;

public String getBatchDescription() {
		return batchDescription;
	}
	public void setBatchDescription(String batchDescription) {
		this.batchDescription = batchDescription;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public int getBatchNoOfClasses() {
		return batchNoOfClasses;
	}
	public void setBatchNoOfClasses(int batchNoOfClasses) {
		this.batchNoOfClasses = batchNoOfClasses;
	}
	public String getBatchStatus() {
		return batchStatus;
	}
	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public void makeBatchPayloadByMap(Map<String, String> record) {
		batchDescription = record.get("batchDescription");
		batchName = record.get("batchName");
		
		//batchNoOfClasses = 0;
		if(!"".equals(record.get("batchID-Endpoint"))){
			try {
				batchId = Integer.parseInt(record.get("batchID-Endpoint"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
		//batchNoOfClasses = 0;
		if(!"".equals(record.get("batchNoOfClasses"))){
			try {
				batchNoOfClasses = Integer.parseInt(record.get("batchNoOfClasses"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
		batchStatus = record.get("batchStatus");

		//programId = 0;
		if(!"".equals(record.get("Batch-ProgramId"))){
			try {
				programId = Integer.parseInt(record.get("Batch-ProgramId"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
	}
	

}
