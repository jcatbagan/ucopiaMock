package com.catbagan.services;

import com.catbagan.datas.UcopiaResponseDTO;

/**
 * 
 * @author jerom
 *
 */
public interface UcopiaService {

	UcopiaResponseDTO authenticate(final String login, final String password);

	UcopiaResponseDTO subscribeOK();
}
