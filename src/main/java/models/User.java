package models;

public class User {

	private int users_id;
	private String username;
	private String u_password;
	private String u_firstname;
	private String u_lastname;
	private String u_email;
	private int u_roleid;

	public User( ) {
	}
	
	public User(int users_id, String username, String u_password, String u_firstname, String u_lastname, String u_email,
			int u_roleid) {
		super();
		this.users_id = users_id;
		this.username = username;
		this.u_password = u_password;
		this.u_firstname = u_firstname;
		this.u_lastname = u_lastname;
		this.u_email = u_email;
		this.u_roleid = u_roleid;
	}
	
	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_firstname() {
		return u_firstname;
	}

	public void setU_firstname(String u_firstname) {
		this.u_firstname = u_firstname;
	}

	public String getU_lastname() {
		return u_lastname;
	}

	public void setU_lastname(String u_lastname) {
		this.u_lastname = u_lastname;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public int getU_roleid() {
		return u_roleid;
	}

	public void setU_roleid(int u_roleid) {
		this.u_roleid = u_roleid;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((u_email == null) ? 0 : u_email.hashCode());
		result = prime * result + ((u_firstname == null) ? 0 : u_firstname.hashCode());
		result = prime * result + ((u_lastname == null) ? 0 : u_lastname.hashCode());
		result = prime * result + ((u_password == null) ? 0 : u_password.hashCode());
		result = prime * result + u_roleid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + users_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (u_email == null) {
			if (other.u_email != null)
				return false;
		} else if (!u_email.equals(other.u_email))
			return false;
		if (u_firstname == null) {
			if (other.u_firstname != null)
				return false;
		} else if (!u_firstname.equals(other.u_firstname))
			return false;
		if (u_lastname == null) {
			if (other.u_lastname != null)
				return false;
		} else if (!u_lastname.equals(other.u_lastname))
			return false;
		if (u_password == null) {
			if (other.u_password != null)
				return false;
		} else if (!u_password.equals(other.u_password))
			return false;
		if (u_roleid != other.u_roleid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (users_id != other.users_id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [users_id=" + users_id + ", username=" + username + ", u_password=" + u_password + ", u_firstname="
				+ u_firstname + ", u_lastname=" + u_lastname + ", u_email=" + u_email + ", u_roleid=" + u_roleid + "]";
	}

	
}