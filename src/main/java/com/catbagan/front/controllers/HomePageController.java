package com.catbagan.front.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
	
	@RequestMapping("/")
	public String home() {
	    return "Hello Word!<br/><br/><a href=\"swagger-ui.html\">Swagger Documentation</a>!";
	}
	
}
 
