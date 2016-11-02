package com.catbagan.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.catbagan.datas.HelloDto;
import com.catbagan.datas.UcopiaData;
import com.catbagan.datas.UcopiaResponseDTO;
import com.catbagan.services.UcopiaService;
/**
 * Mock  Ends points Ucopia  
 * @author jenseric.catbagan
 *
 */
@RestController
public class UcopiaController {
	
	@Autowired
	UcopiaService ucopiaService;
	
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
	@RequestMapping(value="/portal_api.php", method = RequestMethod.POST)
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
