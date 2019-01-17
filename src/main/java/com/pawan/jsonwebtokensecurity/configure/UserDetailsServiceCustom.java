package com.pawan.jsonwebtokensecurity.configure;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.pawan.jsonwebtokensecurity.model.User;
import com.pawan.jsonwebtokensecurity.repository.UserRepository;


@Service
public class UserDetailsServiceCustom implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	/*@Override
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepository.getUserByUsername(username);
		UserBuilder builder = null;
	    if (user != null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(username);
	      builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
	      List<Role> userRole=(List<Role>)user.getRoles();
	      System.out.println("role for the given username is ::"+userRole);
	      builder.roles(userRole.get(0).toString());
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }

	    return builder.build();
	  }*/
	
	
	@Override
    public UserDetails loadUserByUsername(final String username) {
		 System.out.print("call UserDetailsServiceCustom -> loadUserByUsername +8 ");
		 System.out.println(":User details for loadUserByUsername :::"+username);
         User applicationUser = userRepository.getUserByUsername(username);
       System.out.println(":User details for loadUserByUsername :::"+applicationUser);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsPrincipal(applicationUser);
}


}
