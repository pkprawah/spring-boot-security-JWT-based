package com.pawan.jsonwebtokensecurity.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pawan.jsonwebtokensecurity.model.Privilege;

@Repository
@Component
@Transactional
public class PrivilegeRepositoryImpl implements PrivilegeRepositoryCustom {

	private static final String getprivilegeQuery = "select priv.*  from privilege priv where priv.PrivilegeName=?";

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Privilege getPrivilegeByPrivilegeName(String privilegeName) {

		Query query = entityManager.createNativeQuery(getprivilegeQuery, Privilege.class);
		query.setParameter(1, privilegeName);
		List<Privilege> privilegeList = (List<Privilege>) query.getResultList();
		System.out.println("Privilege ::" + privilegeList);
		if (privilegeList == null || privilegeList.isEmpty())
			return null;
		return privilegeList.get(0);
	}

}
