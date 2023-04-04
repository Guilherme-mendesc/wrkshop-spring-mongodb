package com.guilhermemc.wrkshopmongo.service.exception;

public class ObjectNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	

}
