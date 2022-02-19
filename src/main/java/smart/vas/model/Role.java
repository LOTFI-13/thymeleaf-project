package smart.vas.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role 
{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "Role_Ky")
		private int RoleKy;
		
		@Column(name = "Role_Name", length=50)
		private String RoleName;
		
		@Column(name = "Role_Description")
		private String Role_Description;
		
		@Column(name = "Role_Tscr", columnDefinition = "Timestamp")
		private Timestamp RoleTsCr;
		
		@Column(name = "Role_Tsup", columnDefinition = "Timestamp")
		private Timestamp RoleTsUp;
		
		public Role() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Role(int RoleKy, String RoleName, String Role_Description) {
			super();
			this.RoleKy = RoleKy;
			this.RoleName = RoleName;
			this.Role_Description=Role_Description;
		}

		public int getRoleKy() {
			return RoleKy;
		}

		public void setRoleKy(int roleKy) {
			RoleKy = roleKy;
		}

		public String getRoleName() {
			return RoleName;
		}

		public void setRoleValue(String roleName) {
			RoleName = roleName;
		}

		public String getRole_Description() {
			return Role_Description;
		}

		public void setRole_Description(String role_Description) {
			Role_Description = role_Description;
		}

		public Timestamp getRoleTsCr() {
			return RoleTsCr;
		}

		public void setRoleTsCr(Timestamp roleTsCr) {
			RoleTsCr = roleTsCr;
		}

		public Timestamp getRoleTsUp() {
			return RoleTsUp;
		}

		public void setRoleTsUp(Timestamp roleTsUp) {
			RoleTsUp = roleTsUp;
		}
		
		@Override
		public String toString() {
			return this.RoleName;
		}
		
}
