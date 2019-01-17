package com.pawan.jsonwebtokensecurity.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authenticationException)
			throws IOException, ServletException {
		
		// Nothing to implements here because we are not handling any error msg or working on it.
		
		httpServletResponse.sendError(httpServletResponse.SC_UNAUTHORIZED,"UNAUTHORIZED");
		
	}

}
