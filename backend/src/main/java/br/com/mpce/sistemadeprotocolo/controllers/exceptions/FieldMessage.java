package br.com.mpce.sistemadeprotocolo.controllers.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String fieldmessage;
	private String message;
	
	public FieldMessage() {
		// TODO Auto-generated constructor stub
	}

	public FieldMessage(String fieldmessage, String message) {
		super();
		this.fieldmessage = fieldmessage;
		this.message = message;
	}

	public String getFieldmessage() {
		return fieldmessage;
	}

	public void setFieldmessage(String fieldmessage) {
		this.fieldmessage = fieldmessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
