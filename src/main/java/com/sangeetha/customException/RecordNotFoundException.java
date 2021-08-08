package com.sangeetha.customException;

public class RecordNotFoundException extends Exception{
	
	// 6. control comes here, check and substitute msg and call super class constructor
	// 7. super class constructor will verify whether dev handles any custom exception, if yes go to corresponding class that is customExceptionHandler class
	public RecordNotFoundException(String msg) {
		super(msg);
	}

}
