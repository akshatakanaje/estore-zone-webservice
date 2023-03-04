package com.simplilearn.estorezone.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlreadyExistException extends RuntimeException{
	                                 //(Why Runtime means Runtime exceptions are handle dynamically at execution part)

	private static final long serialVersionUID = 2315783994437555895L;
	
	private String message;

}




