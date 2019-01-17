package com.pawan.jsonwebtokensecurity.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="role")
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="RoleName")
    private String roleName;
   
	@Column(name="Status")
    private String status;
   
	@Column(name="Description")
    private String description;
   
	@Column(name="CreatedOn")
    private String createdOn;
 	
	@Column(name="CreatedBy")
    private String createdBy;
 	
	@Column(name="ModifiedOn")
 	private String modifiedOn;
    
	@Column(name="ModifiedBy")
    private String modifiedBy;
    
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;
 
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
        name = "role_privilege", 
        joinColumns = @JoinColumn(
          name = "roleId", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "privilegeId", referencedColumnName = "id"))
    private Collection<Privilege> privileges;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}

	
    

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", status=" + status + ", description=" + description+ "]";
	}
   
    

}
