package Payload;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class userRoleBatchStatusPayload {
	public String makeUserRoleBatchStatusPayload( Map<String, String> record) {
		
		String payload = null;
		userRoleProgramBatches userRoleProgram = new userRoleProgramBatches(record.get("Batch Id"), record.get("UserRoleProgramBatchStatus"));
		List<userRoleProgramBatches> userRoleProgramBatches = Arrays.asList(userRoleProgram);
		RoleprogramBatchStatusPayload RoleprogramBatchStatusPayload = new RoleprogramBatchStatusPayload(record.get("ProgramId"), record.get("roleId"), userRoleProgramBatches);
	
		ObjectMapper mapper = new ObjectMapper();
    	try {
			payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(RoleprogramBatchStatusPayload);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return payload;
	}

}
