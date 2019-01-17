package com.pawan.jsonwebtokensecurity.security;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.pawan.jsonwebtokensecurity.configure.UserDetailsPrincipal;
import com.pawan.jsonwebtokensecurity.model.JwtAuthenticationToken;
import com.pawan.jsonwebtokensecurity.model.Role;
import com.pawan.jsonwebtokensecurity.model.User;


@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JwtTokenValidator jwtTokenValidator;
	
	
	
	@Override
	public boolean supports(Class<?> authentication) {
		//This is JwtAuthenticationToken the model class which extends the usernamepasswordauthenticationtoken
		//which is used by the other class as model.
		
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
			throws AuthenticationException {
		
		JwtAuthenticationToken jwtAuthenticationToken =(JwtAuthenticationToken)usernamePasswordAuthenticationToken;
		String token=jwtAuthenticationToken.getToken();
		User user=jwtTokenValidator.validate(token);
		
		if(user==null){
			throw new RuntimeException("JWT token is incorrect");
		}
				System.out.print("call UserDetailsPrincipal -> getAuthorities +11 ");
				List<Role> roleList=(List<Role>)user.getRoles();
				System.out.print("Role List :::"+roleList);
				List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
				SimpleGrantedAuthority simpleGrantedAuthority=null;
				String roleName=null;
				for(Role role :roleList){
					roleName=role.getRoleName();
					simpleGrantedAuthority=new SimpleGrantedAuthority("ROLE_"+roleName);
					 authorities.add(simpleGrantedAuthority);
					
					
				}

		
		
		UserDetailsPrincipal userDetailsPrincipal=
				new UserDetailsPrincipal(user.getUsername(),user.getUserId(),token,authorities);
		return userDetailsPrincipal;
	}

}
