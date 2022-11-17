package Dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseData<response> {
	private boolean status;
	private List<String> messages = new ArrayList<>();
	private response payload;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public response getPayload() {
		return payload;
	}
	public void setPayload(response payload) {
		this.payload = payload;
	}

	
}
