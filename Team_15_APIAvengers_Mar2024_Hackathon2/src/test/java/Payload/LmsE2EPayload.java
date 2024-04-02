package Payload;

import java.util.Map;

public class LmsE2EPayload {
	static ProgramPayload program = new ProgramPayload();
	static BatchPayload batch = new BatchPayload();
	
	public static ProgramPayload getProgram() {
		return program;
	}
	public static void setProgram(ProgramPayload program) {
		LmsE2EPayload.program = program;
	}
	public static BatchPayload getBatch() {
		return batch;
	}
	public static void setBatch(BatchPayload batch) {
		LmsE2EPayload.batch = batch;
	}
	
}
