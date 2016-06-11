package model.beans;

import java.util.Date;

public class User {
	private int id;
	private int adminLvl;
	private String username = null;
	private String password = null;
	private String name = null;
	private String firstname = null;
	private String lastname = null;
	private String email = null;
	Date f_nacimiento = null;

	public User(int id, int adminLvl, String username, String password,
			String nombre, String apellido1) {
		this.id = id;
		this.adminLvl = adminLvl;
		this.username = username;
		this.password = password;
		this.name = nombre;
		this.firstname = apellido1;
	}

	public User(int id, int adminLvl, String username, String password,
			String nombre, String apellido1, String apellido2, String email) {
		super();
		this.id = id;
		this.adminLvl = adminLvl;
		this.username = username;
		this.password = password;
		this.name = nombre;
		this.firstname = apellido1;
		this.lastname = apellido2;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return name;
	}

	public void setNombre(String nombre) {
		this.name = nombre;
	}

	public String getApellido1() {
		return firstname;
	}

	public void setApellido1(String apellido1) {
		this.firstname = apellido1;
	}

	public String getApellido2() {
		return lastname;
	}

	public void setApellido2(String apellido2) {
		this.lastname = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getF_nacimiento() {
		return f_nacimiento;
	}

	public void setF_nacimiento(Date f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}

	public int getAdminLvl() {
		return adminLvl;
	}

	public void setAdminLvl(int adminLvl) {
		this.adminLvl = adminLvl;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", adminLvl=" + adminLvl + ", username="
				+ username + ", password=" + password + ", name=" + name
				+ ", firstname=" + firstname + "]";
	}
	
	

}
