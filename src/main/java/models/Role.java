package models;

public class Role {

	////// VARIABLES/////
	private int user_role_id;
	private String user_role;

	///// CONSTRUCTOR///////
	public Role() {
		super();

	}

	public Role(int user_role_id, String user_role) {
		super();
		this.user_role_id = user_role_id;
		this.user_role = user_role;
	}

	///// SWITCH CASES///////

	public Role(int user_role_id) {
		this.user_role_id = user_role_id;

		switch (user_role_id) {
		case 1:
			this.user_role = "Manager";
			break;
		case 2:
			this.user_role = "Employee";
			break;
		default:
		}
	}

	public Role(String role_name) {
		this.user_role = role_name;

		switch (role_name) {

		case "Manager":
			this.user_role_id = 1;
			break;
		case "Employee":
			this.user_role_id = 2;
			break;
		default:

		}
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_role == null) ? 0 : user_role.hashCode());
		result = prime * result + user_role_id;
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
		Role other = (Role) obj;
		if (user_role == null) {
			if (other.user_role != null)
				return false;
		} else if (!user_role.equals(other.user_role))
			return false;
		if (user_role_id != other.user_role_id)
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Role [user_role_id=" + user_role_id + ", user_role=" + user_role + "]";
	}
}
