package com.pawan.jsonwebtokensecurity.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
	    private Long userId;
	 
	 	@Column(name="UserName")
	    private String username;
	 	
	 	@Column(name="FirstName")
	    private String firstName;
	 	
	 	@Column(name="LastName")
	    private String lastName;
	 	
	 	@Column(name="Email")
	    private String email;
	 	
	 	@Column(name="Password")
	    private String password;
	 	
	 	@Column(name="Status")
	    private String status;
	 	
	 	@Column(name="MobileNumber")
	    private String mobileNo;
	 	
	 	@Column(name="CreatedOn")
	    private String createdOn;
	 	
	 	@Column(name="CreatedBy")
	    private String createdBy;
	 	
	 	@Column(name="ModifiedOn")
	 	private String modifiedOn;
	    
	 	@Column(name="ModifiedBy")
	    private String modifiedBy;
	    
	 	
	    
	    
	    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	    @JoinTable( 
	        name = "user_role", 
	        joinColumns = @JoinColumn(
	          name = "userId", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "roleId", referencedColumnName = "id")) 
	    private Collection<Role> roles;
	    
	    public User(){
	    	
	    }
	    
	    
		public User(Long id, String username, String firstName, String lastName, String email, String password,
				String status, String mobileNo, String createdOn, String createdBy, String modifiedOn,
				String modifiedBy, Collection<Role> roles) {
			super();
			this.userId = userId;
			this.username = username;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.status = status;
			this.mobileNo = mobileNo;
			this.createdOn = createdOn;
			this.createdBy = createdBy;
			this.modifiedOn = modifiedOn;
			this.modifiedBy = modifiedBy;
			this.roles = roles;
		}
		
		public User(User user){
			 //System.out.print("call User -> User +10 ");
			this.userId = user.getUserId();
			this.username = user.getUsername();
			this.firstName = user.getFirstName();			
			this.lastName = user.getLastName();
			this.email = user.getEmail();
			this.password = user.getPassword();
			this.status = user.getStatus();
			this.mobileNo = user.getMobileNo();
			this.createdOn = user.getCreatedOn();
			this.createdBy = user.getCreatedBy();
			this.modifiedOn = user.getModifiedOn();
			this.modifiedBy = user.getModifiedBy();
			this.roles = user.getRoles();
		}


		public Long getUserId() {
			return userId;
		}


		public void setUserId(Long userId) {
			this.userId = userId;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public String getMobileNo() {
			return mobileNo;
		}


		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
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
			return "User [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName="
					+ lastName + ", email=" + email + ", password=" + password + ", status=" + status + ", mobileNo="
					+ mobileNo + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", modifiedOn=" + modifiedOn
					+ ", modifiedBy=" + modifiedBy + ", roles=" + roles + "]";
		}
		
		
}
