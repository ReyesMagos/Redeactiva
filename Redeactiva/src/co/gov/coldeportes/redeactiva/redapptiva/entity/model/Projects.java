package co.gov.coldeportes.redeactiva.redapptiva.entity.model;

public class Projects {

	private String tipo;
	private String nombrePrograma;
	private String descripcionPrograma;
	private String tipoEntidad;
	private String codigoDepartamento;
	private String codigoMunicipio;
	private String personaContacto;
	private String direccionMunicipio;
	private String telefono;
	private String email;
	private String paginaWeb;
	private String partitionKey;
	private String rowKey;

	public Projects() {

	}

	public Projects(String codigoMuni, String codigoDep, String nombreProgram,
			String pagWeb, String tipo) {
		this.setCodigoDepartamento(codigoDep);
		this.setCodigoMunicipio(codigoMuni);
		this.setNombrePrograma(nombreProgram);
		this.setPaginaWeb(pagWeb);
		this.setTipo(tipo);

	}

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombrePrograma() {
		return nombrePrograma;
	}

	public void setNombrePrograma(String nombrePrograma) {
		this.nombrePrograma = nombrePrograma;
	}

	public String getDescripcionPrograma() {
		return descripcionPrograma;
	}

	public void setDescripcionPrograma(String descripcionPrograma) {
		this.descripcionPrograma = descripcionPrograma;
	}

	public String getTipoEntidad() {
		return tipoEntidad;
	}

	public void setTipoEntidad(String tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	public String getDireccionMunicipio() {
		return direccionMunicipio;
	}

	public void setDireccionMunicipio(String direccionMunicipio) {
		this.direccionMunicipio = direccionMunicipio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

}
