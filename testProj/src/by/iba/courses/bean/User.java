package by.iba.courses.bean;



public class User {
	
		
	
		public User() {
		super();
	}
		public User(String user, String password, Role role) {
		super();
		this.user = user;
		this.password = password;
		this.role = role;
	}
		public enum Role {student,professor,admin}	

		private String user;
		private String password;
		private Role role;
		
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
}
