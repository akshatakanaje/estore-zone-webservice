package com.simplilearn.estorezone.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String indexMapping()
	{
		return "server is up and running!";
	}
	
	
	@GetMapping("/messages")//messages?time=morning/noon/night(if we add anything after the ? like 1 or more than one 
	        //query param like this so if we add anything after ? that is called as request param or query param)
	public String messageMapping(@RequestParam("time") String time)	{
		
		if(time.equals("morning")) {
			return "Good Morning! Have a woderful day!";
		} else if(time.equals("noon")) {
			return "Good Noon! Have a woderful day!";
		} else if(time.equals("evening")) {
			return "Good Evening! Have a woderful day!";
		} else {
			return "Have a Good night!";
		}
	}
	
	@GetMapping("/message")
	public String messageMapping()
	{
		return "Today is a woderful day!";
	}
	
	@GetMapping("/users/{userId}")//data/1010293424(whatever we see in the after / it is a path variable
	public String dataMapping(@PathVariable("userId") String userId) {
		return "John has userId : "+userId;
	}

}
