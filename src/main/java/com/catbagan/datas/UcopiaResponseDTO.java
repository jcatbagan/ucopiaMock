package com.catbagan.datas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Response DTO when an API is called
 * @author jenseric.catbagan
 *
 */
@JsonInclude(Include.NON_NULL)
public class UcopiaResponseDTO {

	private InfoDto info;
	private ErrorDto error;

	
	public InfoDto getInfo() {
		return info;
	}

	public void setInfo(InfoDto info) {
		this.info = info;
	}

	public ErrorDto getError() {
		return error;
	}

	public void setError(ErrorDto error) {
		this.error = error;
	}
	
	
	
	
}
