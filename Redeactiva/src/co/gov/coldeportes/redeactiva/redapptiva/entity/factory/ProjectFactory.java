package co.gov.coldeportes.redeactiva.redapptiva.entity.factory;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Projects;

public class ProjectFactory {
	
	public static ProjectFactory projectInstance;
	
	private List<Projects>projectsList;
	
	private ProjectFactory(){
		
	}
	
	public static ProjectFactory getInstance(){
		if(projectInstance == null){
			projectInstance = new ProjectFactory();
		}
		
		return projectInstance;
	}
	
	public void fillProjects(JSONArray jsonArray){
		JSONObject jsonObject;
		this.projectsList = new ArrayList<Projects>();
		
		if(jsonArray == null){
			return;
		}
		
		try {
			for(int i = 0; i < jsonArray.length(); i++){
				jsonObject = jsonArray.getJSONObject(i);
				Projects projects = new Projects();
				projects.setRowKey(jsonObject.getString("RowKey"));
				projects.setPartitionKey((jsonObject.getString("PartitionKey")));
				projects.setTipo((jsonObject.getString("tipo")));
				projects.setNombrePrograma((jsonObject.getString("nombreprograma")));
				projects.setDescripcionPrograma((jsonObject.getString("descripcionprograma")));
				projects.setTipoEntidad((jsonObject.getString("tipodeentidad")));
				projects.setCodigoDepartamento((jsonObject.getString("codigodepartamento")));
				projects.setCodigoMunicipio((jsonObject.getString("codigomunicipio")));
				projects.setPersonaContacto(jsonObject.getString("personacontacto"));
				projects.setDireccionMunicipio(jsonObject.getString("direccionmunicipio"));
				projects.setTelefono(jsonObject.getString("telefono"));
				projects.setEmail(jsonObject.getString("email"));
				projects.setPaginaWeb(jsonObject.getString("paginaweb"));
				
				
			}
		} catch (JSONException e) {
			// TODO: handle exception
		}
	}
	
	

}
