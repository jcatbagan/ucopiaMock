package com.catbagan.services.impl;

import org.springframework.stereotype.Service;

import com.catbagan.datas.ErrorDto;
import com.catbagan.datas.InfoDto;
import com.catbagan.datas.UcopiaResponseDTO;
import com.catbagan.datas.UserDto;
import com.catbagan.services.UcopiaService;

@Service("ucopiaService")
public class UcopiaServiceImpl implements UcopiaService {
	
	

	private static final String LOGIN = "jenseric";
	private static final String PASSWORD = LOGIN;

	@Override
	public UcopiaResponseDTO authenticate(String login, String password) {
		if(LOGIN.equals(login) && PASSWORD.equals(password)) {
			//don't know the structure when it's OK
			return new UcopiaResponseDTO();
		}
	
		UcopiaResponseDTO response = new UcopiaResponseDTO();
		ErrorDto error = new ErrorDto();
		error.setCode("error_logon_bad-login-or-password");
		response.setError(error);
		
		return response;
	}

	@Override
	public UcopiaResponseDTO subscribeOK() {
		
		UcopiaResponseDTO responseDTO = new UcopiaResponseDTO();
		InfoDto info = new InfoDto();
		info.setCode("info_one-subscribe_success");
		UserDto user = new UserDto();
		user.setLogin(LOGIN);
		user.setPassword(PASSWORD);
		info.setUserDTO(user);
		responseDTO.setInfo(info);
		return responseDTO;
	}

}
