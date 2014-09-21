package co.gov.coldeportes.redeactiva.redapptiva.entity.model;

public class MySport {
	
	private String partitionKey;
	private String rowKey;
	private String tipo;
	private String deporte;
	private String descripcionDeporte;
	private String clasificacionFuncional;
	private String sitioWeb;
	private String discapacidad;
	private String descripcionDiscapacidad;
	private String ranking;
	
	public MySport() {
		
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

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public String getDescripcionDeporte() {
		return descripcionDeporte;
	}

	public void setDescripcionDeporte(String descripcionDeporte) {
		this.descripcionDeporte = descripcionDeporte;
	}

	public String getClasificacionFuncional() {
		return clasificacionFuncional;
	}

	public void setClasificacionFuncional(String clasificacionFuncional) {
		this.clasificacionFuncional = clasificacionFuncional;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getDiscapacidad() {
		return discapacidad;
	}

	public void setDiscapacidad(String discapacidad) {
		this.discapacidad = discapacidad;
	}

	public String getDescripcionDiscapacidad() {
		return descripcionDiscapacidad;
	}

	public void setDescripcionDiscapacidad(String descripcionDiscapacidad) {
		this.descripcionDiscapacidad = descripcionDiscapacidad;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	
	

}
