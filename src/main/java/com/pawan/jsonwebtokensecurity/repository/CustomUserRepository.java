/**
 * 
 */
package com.pawan.jsonwebtokensecurity.repository;


import com.pawan.jsonwebtokensecurity.model.User;

/**
 * @author Pawan.kumar
 *
 */

public interface CustomUserRepository  {
	
	User getUserByUsername(String username);
	
}
