package co.gov.coldeportes.redeactiva.redapptiva.entity.model;

public class Calendar {
	private String partitionKey;
	private String rowKey;
	private String evento;
	private String tipo;
	private String fechaInicio;
	private String fechaFinal;
	private String pais;
	private String territorio;
	private String entidad;
	private String claseDeEvento;
	private String nivel;
	private String descripcionDelEvento;
	private String paginaWeb;
	private String contacto;
	private String resultados;
	
	public String getPartitionKey() {
		return partitionKey;
	}
	public void setPartitionKey(String partitionKey) {
		this.partitionKey = partitionKey;
	}
	public String getRowKey() {
		return rowKey;
	}
	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTerritorio() {
		return territorio;
	}
	public void setTerritorio(String territorio) {
		this.territorio = territorio;
	}
	public String getEntidad() {
		return entidad;
	}
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	public String getClaseDeEvento() {
		return claseDeEvento;
	}
	public void setClaseDeEvento(String claseDeEvento) {
		this.claseDeEvento = claseDeEvento;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getDescripcionDelEvento() {
		return descripcionDelEvento;
	}
	public void setDescripcionDelEvento(String descripcionDelEvento) {
		this.descripcionDelEvento = descripcionDelEvento;
	}
	public String getPaginaWeb() {
		return paginaWeb;
	}
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getResultados() {
		return resultados;
	}
	public void setResultados(String resultados) {
		this.resultados = resultados;
	}
	
	
	
}
