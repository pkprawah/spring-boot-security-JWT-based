package com.pawan.jsonwebtokensecurity.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pawan.jsonwebtokensecurity.model.User;

@Repository
@Transactional
//@Component
public class UserRepositoryImpl implements CustomUserRepository {
	
	private static final String getuserQuery ="select user.* from user user where user.UserName=?";

    @PersistenceContext
    EntityManager entityManager;
	
	@Override
	public User getUserByUsername(String userName) {
        
		Query query = entityManager.createNativeQuery(getuserQuery,User.class);
        query.setParameter(1, userName);
        List<User> userList= (List<User>)query.getResultList();
        if(userList==null || userList.isEmpty())
        	return null;
        return userList.get(0);
	}

	
}
