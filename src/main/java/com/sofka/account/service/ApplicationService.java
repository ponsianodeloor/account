/**
 * 
 */
package com.sofka.account.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Ponsiano D Loor
 * @version 1.0 - 04/03/2024
 */
@Service
public class ApplicationService {

	@Value("${server.name}")
	private String serverName;

	@Value("${api.parameter}")
	private String apiParameter;

	/**
	 * @return the serverName
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * @return the apiGetApiParameter
	 */
	public String getApiParameter() {
		return apiParameter;
	}

}
