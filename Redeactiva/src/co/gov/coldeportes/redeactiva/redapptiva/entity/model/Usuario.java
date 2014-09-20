package co.gov.coldeportes.redeactiva.redapptiva.entity.model;

import com.parse.ParseUser;

public class Usuario {

	private String nombre;
	private String email;
	private String username;
	private String discapacity;
	private ParseUser useR;
	private int userType;
	private String departamento;
	private String municipio;

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public ParseUser getUseR() {
		return useR;
	}

	public void setUseR(ParseUser useR) {
		this.useR = useR;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDiscapacity() {
		return discapacity;
	}

	public void setDiscapacity(String discapacity) {
		this.discapacity = discapacity;
	}

}
