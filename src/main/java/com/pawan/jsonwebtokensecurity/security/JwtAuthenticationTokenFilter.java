package com.pawan.jsonwebtokensecurity.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.pawan.jsonwebtokensecurity.model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

	/*private AuthenticationManager authenticationManager;
	private JwtAuthenticationSuccessHandler jwtAuthenticationSuccessHandler;*/

	/*public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		
		this.authenticationManager=authenticationManager;
		
	}

	public void setAuthenticationSuccessHandler(JwtAuthenticationSuccessHandler jwtAuthenticationSuccessHandler) {
		
		this.jwtAuthenticationSuccessHandler=jwtAuthenticationSuccessHandler;
	}*/

	// This will authenticate the token for all the url.
	public JwtAuthenticationTokenFilter() {
		super("/rest/secure/**");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AuthenticationException, IOException, ServletException {
		
		String header=httpServletRequest.getHeader("authorization");
		
		if(header==null || !header.startsWith("Token")){
			throw new RuntimeException("Token is missing please provide the correct token");
		}
		
		String authenticationToken=header.substring(6);
		
		JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
		
		return getAuthenticationManager().authenticate(token);
	}
	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
		}

}
