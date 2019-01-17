package com.pawan.jsonwebtokensecurity.configure;

import java.util.Collections;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import com.pawan.jsonwebtokensecurity.security.JwtAuthenticationEntryPoint;
import com.pawan.jsonwebtokensecurity.security.JwtAuthenticationProvider;
import com.pawan.jsonwebtokensecurity.security.JwtAuthenticationSuccessHandler;
import com.pawan.jsonwebtokensecurity.security.JwtAuthenticationTokenFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackages="com.pawan.jsonwebtokensecurity")
public class JwtWebSecurityConfigure extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private WebApplicationContext applicationContext;
	private UserDetailsServiceCustom userDetailsService;
	private JwtAuthenticationProvider authenticationProvider;
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	
	
   // private CustomSuccessHandler customSuccessHandler;

	 @Bean
	 public JwtAuthenticationTokenFilter authenticationTokenFilter(){
		 
		 JwtAuthenticationTokenFilter filter=new JwtAuthenticationTokenFilter();
		 filter.setAuthenticationManager(authenticationManager());
		 filter.setAuthenticationSuccessHandler(new JwtAuthenticationSuccessHandler());
		 return filter;
	 }
	
	 
	 @Bean
	 public AuthenticationManager authenticationManager(){
		 return new ProviderManager(Collections.singletonList(authenticationProvider));
	 }
	
	@PostConstruct
    public void setupCustomSuccessHandler() {
	 System.out.print("call setupCustomSuccessHandler  ");
		//customSuccessHandler =applicationContext.getBean(CustomSuccessHandler.class);
}
	
	 @PostConstruct
	    public void setupInitialization() {
		 System.out.print("call setupInitialization +1 ");
	        userDetailsService =applicationContext.getBean(UserDetailsServiceCustom.class);
	}
	 	
	 	
	    @Override
	    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	    	 System.out.print("call configure -> AuthenticationManagerBuilder +2 ");
	        auth.userDetailsService(userDetailsService)
	            .passwordEncoder(encoder())
	            .and()
	            .authenticationProvider(authenticationProvider());
	        System.out.print("call configure -> AuthenticationManagerBuilder +2A ");
	    }

	    @Override
	    public void configure(WebSecurity web) throws Exception {
	    	 System.out.print("call configure -> WebSecurity  +3 ");
	        web.ignoring()
	            .antMatchers("/resources/**");
	    }

	    @Override
	    protected void configure(final HttpSecurity http) throws Exception {
	    	System.out.print("call configure -> HttpSecurity +4 ");
	    		http.authorizeRequests()
	           .antMatchers("**/rest/secure/**").authenticated()
	           .and()
	           .formLogin()
	           .permitAll()
	           .and()
	           .csrf().disable().exceptionHandling()
	           .authenticationEntryPoint(authenticationEntryPoint).and()
	           .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	   
	   http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	   
	   http.headers().cacheControl();
	           
	          
	
	    	
	    	/*http.authorizeRequests()
	        .antMatchers("/", "/home").access("hasRole('USER')")
	        .antMatchers("/admin/**").access("hasRole('ADMIN')")
	        .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
	        .and()
	        .formLogin().loginPage("/login")
	        .usernameParameter("username")
            .passwordParameter("password")
            .loginProcessingUrl("/login").successHandler(customSuccessHandler)
	        .and()
	        .exceptionHandling().accessDeniedPage("/Access_Denied")
	        .and()
	        .csrf().disable();*/
	}
	    	
	    	
	    

	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	    	System.out.print("call authenticationProvider -> +5 ");
	        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService);
	        authProvider.setPasswordEncoder(encoder());
	        
	        return authProvider;
	    }

	    @Bean
	    public PasswordEncoder encoder() {
	    	System.out.print("call PasswordEncoder -> +6 ");
	        return new BCryptPasswordEncoder();
	    }
	    
	   

	   
}
