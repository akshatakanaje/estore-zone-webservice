package com.simplilearn.estorezone.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.simplilearn.estorezone.admin.dto.ResponseDto;
import com.simplilearn.estorezone.exceptions.AlreadyExistException;
import com.simplilearn.estorezone.exceptions.NotFoundException;

@ControllerAdvice //To handle an exception globally inside an spring boot we use this annotation
public class GlobalExceptionHandler {
         //this class suppose to handle an exception and return an appropriate response
	
	
	ResponseDto responseDto;

	@ExceptionHandler(value = AlreadyExistException.class)
	public ResponseEntity<ResponseDto> alreadyExistException(AlreadyExistException ex) {
		responseDto = new ResponseDto(HttpStatus.BAD_REQUEST.toString(), ex.getMessage(),new Date(), null );
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<ResponseDto> notFoundException(NotFoundException ex) {
		responseDto = new ResponseDto(HttpStatus.NOT_FOUND.toString(), ex.getMessage(),new Date(), null );
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.NOT_FOUND);
	}
}
