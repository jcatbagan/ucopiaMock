package com.catbagan.datas;

import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * 
 * @author jenseric.catbagan
 *
 */
public class InfoDto {
	
	private String code;
	@JsonProperty("subscribe")
	private UserDto userDTO;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public UserDto getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDto userDTO) {
		this.userDTO = userDTO;
	}
	
}
 