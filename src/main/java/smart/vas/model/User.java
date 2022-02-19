package smart.vas.model;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



	@Entity
	@Table(name = "Users")
	public class User  {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int UserKy;
		
		@Column(name = "User_Name",nullable=false, length=50)
		private String UserName;
		
		@Column(name = "User_Email",nullable=false, length=50)
		private String email;
		
		@Column(name = "User_Password",nullable=false, length=50)
		private String password;
		
		@Column(name = "User_Activate", columnDefinition = "BOOLEAN")
		private boolean UserActivate;
		
		@Column(name = "User_Tscr", columnDefinition = "Timestamp")
		private Timestamp UserTsCr;
		
		@Column(name = "User_Tsup", columnDefinition = "Timestamp")
		private Timestamp UserTsUp;
		
		@ManyToMany(fetch =FetchType.EAGER)
		@JoinTable(
				name ="Users_Roles",
				joinColumns = @JoinColumn(name = " User_Ky"),
				inverseJoinColumns = @JoinColumn(name = "Role_Ky")
				)			
		
		
		private Set<Role> roles = new HashSet<>();

		@OneToMany(mappedBy= "PrntlnUser")
		private Set <ServiceLink> Servicelink = new  HashSet<>();
		
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getUserKy() {
			return UserKy;
		}

		public void setUserKy(int userKy) {
			UserKy = userKy;
		}

		public String getUserName() {
			return UserName;
		}

		public void setUserName(String userName) {
			UserName = userName;
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

		public Set<ServiceLink> getServicelink() {
			return Servicelink;
		}

		public void setServicelink(Set<ServiceLink> servicelink) {
			Servicelink = servicelink;
		}

		public boolean isUserActivate() {
			return UserActivate;
		}

		public void setUserActivate(boolean userActivate) {
			UserActivate = userActivate;
		}

		public Timestamp getUserTsCr() {
			return UserTsCr;
		}

		public void setUserTsCr(Timestamp userTsCr) {
			UserTsCr = userTsCr;
		}

		public Timestamp getUserTsUp() {
			return UserTsUp;
		}

		public void setUserTsUp(Timestamp userTsUp) {
			UserTsUp = userTsUp;
		}
		
		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
		 
		public void addRole(Role role) {
			this.roles.add(role);
		}	
		
	/*	public String getPermissions() {
	        return permissions;
	    }

	    public List<String> getRoleList(){
	        if(this.roles.length() > 0){
	            return Arrays.asList(this.roles.split(","));
	        }
	        return new ArrayList<>();
	    }*/

	/*    public List<String> getPermissionList(){
	        if(this.permissions.length() > 0){
	            return Arrays.asList(this.permissions.split(","));
	        }
	        return new ArrayList<>();
	    }*/
	
}
