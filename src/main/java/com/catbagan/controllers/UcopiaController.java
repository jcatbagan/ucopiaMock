package com.catbagan.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.catbagan.datas.HelloDto;
import com.catbagan.datas.UcopiaData;
import com.catbagan.datas.UcopiaResponseDTO;
import com.catbagan.services.UcopiaService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * Mock  Ends points Ucopia  
 * @author jenseric.catbagan
 *
 */
@RestController
public class UcopiaController {


	@Autowired
	UcopiaService ucopiaService;
	
	@GetMapping("/greeting-javaconfig")
	@RequestMapping(value="/hello", method = RequestMethod.GET)
    public HelloDto greeting(@RequestParam(value="firstname", defaultValue="jenseric") String firstname,
    		@RequestParam(value="name", defaultValue="catbagan") String name) {
        HelloDto hello = new HelloDto();
        hello.setFirstname(firstname);
        hello.setName(name);
        
        return hello;
	}
	
	
	/**
	 * Mock register web service
	 * @return
	 */
	@GetMapping("/greeting-javaconfig")
	@RequestMapping(value="/portal_api.php", method = RequestMethod.POST)
	@ApiOperation(value = "Ucopia authentification", notes = "Ucopia authentification for customer (anonymous or not). Only one client is available login:jenseric, password: jenseric")
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "the authentification is done if no error object is returned.") })

	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "action", value = "subscribe or authenticate", required = true, dataType = "string", paramType = "form"),
		    @ApiImplicitParam(name = "login", value = "maestro login", required = false, dataType = "string", paramType = "form"),
		    @ApiImplicitParam(name = "password", value = "maestro password", required = false, dataType = "string", paramType = "form"),
		    @ApiImplicitParam(name = "type", value = "true if user accept connection term", required = false, dataType = "boolean", paramType = "form")
		  })
	public UcopiaResponseDTO mockAuthenticateOK(@ModelAttribute UcopiaData ucopiaData) {
		 
		if("authenticate".equals(ucopiaData.getAction())) {
			return ucopiaService.authenticate(ucopiaData.getLogin(), ucopiaData.getPassword());
		}
		
		else if("subscribe".equals(ucopiaData.getAction())) {
			return ucopiaService.subscribeOK();
		}
		
		return null;

	}
}
