package com.pawan.jsonwebtokensecurity.service;

import com.pawan.jsonwebtokensecurity.util.APIResponse;

public interface LoginService {
	
	public APIResponse signIn(String username,String password);

}
