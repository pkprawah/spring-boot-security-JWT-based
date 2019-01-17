package com.pawan.jsonwebtokensecurity.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="privilege")
public class Privilege {
	  
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    @Column(name="PrivilegeName")
	    private String privilegeName;
	    
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
	    
	 
	    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	    private Collection<Role> roles;


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getPrivilegeName() {
			return privilegeName;
		}


		public void setPrivilegeName(String privilegeName) {
			this.privilegeName = privilegeName;
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


		public Collection<Role> getRoles() {
			return roles;
		}


		public void setRoles(Collection<Role> roles) {
			this.roles = roles;
		}


		@Override
		public String toString() {
			return "Privilege [id=" + id + ", privilegeName=" + privilegeName + ", status=" + status + ", description="
					+ description + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", modifiedOn="
					+ modifiedOn + ", modifiedBy=" + modifiedBy + ", roles=" + roles + "]";
		}


		
	    
	    
}
