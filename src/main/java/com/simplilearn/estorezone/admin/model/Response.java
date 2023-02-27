package com.simplilearn.estorezone.admin.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
	        
	private String status;
	private String message;
	private Date timestamp = new Date();
	private Object data;
}
