package com.pawan.jsonwebtokensecurity.serviceImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.pawan.jsonwebtokensecurity.configure.CustomSuccessHandler;
import com.pawan.jsonwebtokensecurity.model.Privilege;
import com.pawan.jsonwebtokensecurity.model.Role;
import com.pawan.jsonwebtokensecurity.model.User;
import com.pawan.jsonwebtokensecurity.repository.PrivilegeRepository;
import com.pawan.jsonwebtokensecurity.repository.RoleRepository;
import com.pawan.jsonwebtokensecurity.repository.UserRepository;
import com.pawan.jsonwebtokensecurity.service.RecordLoaderService;

@Service
@Transactional
public class RecordLoaderServiceImpl implements RecordLoaderService {

	@Autowired
	EntityManager entitymanager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//@Autowired
	//CustomSuccessHandler customSuccessHandler;

	@Override
	public void insertRecord() {
		
		System.out.println(" ::: calling RecordLoaderServiceImpl :::");

		Privilege readPrivilege = createPrivilege("READ");
		Privilege writePrivilege = createPrivilege("WRITE");

		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		Role roleAdmin=createRole("ADMIN", adminPrivileges);
		Role roleUser=createRole("USER", Arrays.asList(readPrivilege));

		Role adminRole = roleRepository.getRoleByRoleName("ADMIN");
		Role userRole = roleRepository.getRoleByRoleName("USER");
		//List<Role> roleAdminUserList = Arrays.asList(adminRole, userRole);
		List<Role> roleAdminUserList = Arrays.asList(userRole);
		System.out.println("adminRole ::" + adminRole);
		if(adminRole!=null)
		createUser(roleAdminUserList);
		

	}

	private void createUser(List<Role> roleAdminUserList) {
		
		User user = new User();
		user.setUsername("pawanhm");
		User usr=userRepository.getUserByUsername(user.getUsername());
		if(usr!=null){
			user.setUsername("saroj");
		}
		
		user.setFirstName("Saroj");
		user.setLastName("Kumar");
		user.setPassword(passwordEncoder.encode("saroj"));
		user.setRoles(roleAdminUserList);
		user.setStatus("Enable");
		user.setEmail("test@testmail.com");
		user.setMobileNo("9999999999");
		user.setCreatedBy("1");
		user.setModifiedBy("1");
		userRepository.save(user);
	}

	private Privilege createPrivilege(String name) {

		Privilege privilege = null;
		privilege = privilegeRepository.getPrivilegeByPrivilegeName(name);
		System.out.println("services ::" + privilege);
		if (privilege == null) {
			privilege = new Privilege();
			privilege.setPrivilegeName(name);
			privilege.setStatus("Enable");
			privilege.setDescription(name.toUpperCase() + "_PRIVILEGE");
			privilege.setCreatedBy("1");
			privilege.setModifiedBy("1");
			privilegeRepository.save(privilege);
		}
		return privilege;
	}

	private Role createRole(String name, Collection<Privilege> privileges) {
		System.out.println(" :: Calling createRoleIfNotFound ::");
		Role  role = new Role();
		Role rolevalue = roleRepository.getRoleByRoleName(name);
		System.out.println("In Services Role::" + role);
		if (rolevalue == null) {
		role.setRoleName(name);
		System.out.println("role name ::: "+role.getRoleName());
			role.setStatus("Enable");
			role.setDescription("ROLE_" + name.toUpperCase());
			role.setPrivileges(privileges);
			role.setCreatedBy("1");
			role.setModifiedBy("1");
			roleRepository.save(role);

		}
		return role;
	}
	 

}
