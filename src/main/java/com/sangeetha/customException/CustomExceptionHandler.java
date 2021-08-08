package com.sangeetha.customException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
// 8. here control verify if any method matches with exception class name, then forward that error request to that method 
// 9. and finally this method process and display the message to end user

//Step 1 : we are handling the exception by using @ControllerAdvice
//So design a class which is annotated with @@ControllerAdvice
@ControllerAdvice
public class CustomExceptionHandler  
{
	//Step 2: design own method to returning error code as well as msg
	//ErrorDetails class contains error code and msg so taking this class arguments ,and method name(recordNotFound) will take 2 arguments
	//1st argument is user-defined exception that is RecordNotFoundException
	//2nd argument is WebRequest to capture where is the request come from
	//step 3 : RecordNotFoundException class mapped here by using @ExceptionHandler
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ErrorDetails> recordNotFOund(RecordNotFoundException ex, WebRequest re){
		//step 4: create a object for errorDetails class
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),"404",new Date());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
