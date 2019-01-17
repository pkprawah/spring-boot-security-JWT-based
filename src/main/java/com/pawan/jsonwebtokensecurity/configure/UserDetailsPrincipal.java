package com.pawan.jsonwebtokensecurity.configure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.pawan.jsonwebtokensecurity.model.Role;
import com.pawan.jsonwebtokensecurity.model.User;

public class UserDetailsPrincipal extends User implements UserDetails{

	private String username;
	private Long userId;
	private String token;
	private Collection<? extends GrantedAuthority> authorities;
	
	 private  User user;
	
	public UserDetailsPrincipal(String username, Long userId, String token,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.username = username;
		this.userId = userId;
		this.token = token;
		this.authorities = authorities;
	}

	public UserDetailsPrincipal(User user) {
		
		super(user);
		// System.out.print("call UserDetailsPrincipal -> UserDetailsPrincipal +9 ");
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 //System.out.print("call UserDetailsPrincipal -> getAuthorities +11 ");
		List<Role> roleList=(List)super.getRoles();
		//System.out.print("Role List :::"+roleList);
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority simpleGrantedAuthority=null;
		String roleName=null;
		for(Role role :roleList){
			roleName=role.getRoleName();
			simpleGrantedAuthority=new SimpleGrantedAuthority("ROLE_"+roleName);
			 authorities.add(simpleGrantedAuthority);
			
			
		}
		//System.out.println("role Name:"+roleName);
		  /*List<GrantedAuthority> authorities = Collections.singletonList(
				 new SimpleGrantedAuthority("ROLE_"+roleName));*/
		 System.out.print("Authorities :::"+authorities);
		 return authorities;
	}

	@Override
	public String getPassword() {
		 return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
