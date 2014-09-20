package co.gov.coldeportes.redeactiva.redapptiva.entity.model;

public class Evento {
	
	private String deporte;
	private String fecha;
	private int maximoNumeroParticipantes;
	private int minimoNumeroParticipantes;
	private String departamento;
	private String municipio;
	private String direccion;
	private Usuario creador;
	
	
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getMaximoNumeroParticipantes() {
		return maximoNumeroParticipantes;
	}
	public void setMaximoNumeroParticipantes(int maximoNumeroParticipantes) {
		this.maximoNumeroParticipantes = maximoNumeroParticipantes;
	}
	public int getMinimoNumeroParticipantes() {
		return minimoNumeroParticipantes;
	}
	public void setMinimoNumeroParticipantes(int minimoNumeroParticipantes) {
		this.minimoNumeroParticipantes = minimoNumeroParticipantes;
	}
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	
	
	
	

}
