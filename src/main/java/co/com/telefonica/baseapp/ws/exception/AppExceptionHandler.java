package co.com.telefonica.baseapp.ws.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.telefonica.baseapp.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * 	This also can be changed by an especific exception like NullPointerException.class , if you want to handle more than one 
	 *	exception use it like this  	@ExceptionHandler(value= {Exception.class,UserServiceException.class}) and also you have to change
	 *	the entry parameter for superclass Exception
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex,WebRequest request){
		
		String errorMessage=ex.getLocalizedMessage();
		
		if (errorMessage==null)errorMessage=ex.toString();
		
		ErrorMessage message=new ErrorMessage(new Date(),errorMessage);
		
		
		return new ResponseEntity<>(
				message,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	
	
	/**
	 * This also can be changed by an especific exception like NullPointerException.class
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value= {EntityServiceException.class})
	public ResponseEntity<Object> handleAnyException(EntityServiceException ex,WebRequest request){
		
		String errorMessage=ex.getLocalizedMessage();
		
		if (errorMessage==null)errorMessage=ex.toString();
		
		ErrorMessage message=new ErrorMessage(new Date(),errorMessage);
		
		
		return new ResponseEntity<>(
				message,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	
	
}
