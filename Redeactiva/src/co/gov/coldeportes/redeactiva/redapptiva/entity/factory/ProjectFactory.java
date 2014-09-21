package co.gov.coldeportes.redeactiva.redapptiva.entity.factory;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.gov.coldeportes.redeactiva.redapptiva.controladores.ProjectsController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Projects;

public class ProjectFactory {

	public static ProjectFactory projectInstance;

	private List<Projects> projectsList;
	private ProjectsController projectsController;
	public static int filterOption = 0;

	private List<Projects> proListAux;

	private ProjectFactory() {
	}

	public static ProjectFactory getInstance() {
		if (projectInstance == null) {
			projectInstance = new ProjectFactory();
		}

		return projectInstance;
	}

	public void fillProjects(JSONArray jsonArray) {
		JSONObject jsonObject;
		this.projectsList = new ArrayList<Projects>();

		if (jsonArray == null || jsonArray.length() == 0) {
			return;
		}

		try {
			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObject = jsonArray.getJSONObject(i);
				Projects projects = new Projects();
				projects.setRowKey(jsonObject.getString("RowKey"));
				projects.setPartitionKey((jsonObject.getString("PartitionKey")));
				projects.setTipo((jsonObject.getString("tipo")));
				projects.setNombrePrograma((jsonObject
						.getString("nombreprograma")));
				projects.setDescripcionPrograma((jsonObject
						.getString("descripcionprograma")));
				projects.setTipoEntidad((jsonObject.getString("tipodeentidad")));
				projects.setCodigoDepartamento((jsonObject
						.getString("codigodepartamento")));
				projects.setCodigoMunicipio((jsonObject
						.getString("codigomunicipio")));
				projects.setPersonaContacto(jsonObject
						.getString("personacontacto"));
				projects.setDireccionMunicipio(jsonObject
						.getString("direccionmunicipio"));
				projects.setTelefono(jsonObject.getString("telefono"));
				projects.setEmail(jsonObject.getString("email"));
				projects.setPaginaWeb(jsonObject.getString("paginaweb"));
				this.projectsList.add(projects);
			}
			showProjects(filterOption);

		} catch (JSONException e) {
			// TODO: handle exception
		}
	}

	public List<Projects> getProjectsList() {
		return projectsList;
	}

	public void showProjects(int option) {
		proListAux = new ArrayList<Projects>();
		Projects projectAux;

		for (int i = 0; i < projectsList.size(); i++) {
			if (option == 0
					&& projectsList.get(i).getTipo()
							.equals("Deporte Social Comunitario")) {
				projectAux = new Projects(projectsList.get(i)
						.getCodigoMunicipio(), projectsList.get(i)
						.getCodigoDepartamento(), projectsList.get(i)
						.getNombrePrograma(), projectsList.get(i)
						.getPaginaWeb(), projectsList.get(i).getTipo());
				proListAux.add(projectAux);
			} else if (projectsList.get(i).getTipo().equals("Recreaci�n")) {
				projectAux = new Projects(projectsList.get(i)
						.getCodigoMunicipio(), projectsList.get(i)
						.getCodigoDepartamento(), projectsList.get(i)
						.getNombrePrograma(), projectsList.get(i)
						.getPaginaWeb(), projectsList.get(i).getTipo());
				proListAux.add(projectAux);
			}

		}
	}
	
	public List<Projects> filterProjects(int option){
		proListAux = new ArrayList<Projects>();
		Projects projectAux;

		for (int i = 0; i < projectsList.size(); i++) {
			if (option == 0
					&& projectsList.get(i).getTipo()
							.equals("Deporte Social Comunitario")) {
				projectAux = new Projects(projectsList.get(i)
						.getCodigoMunicipio(), projectsList.get(i)
						.getCodigoDepartamento(), projectsList.get(i)
						.getNombrePrograma(), projectsList.get(i)
						.getPaginaWeb(), projectsList.get(i).getTipo());
				proListAux.add(projectAux);
			} else if (projectsList.get(i).getTipo().equals("Recreacion")) {
				projectAux = new Projects(projectsList.get(i)
						.getCodigoMunicipio(), projectsList.get(i)
						.getCodigoDepartamento(), projectsList.get(i)
						.getNombrePrograma(), projectsList.get(i)
						.getPaginaWeb(), projectsList.get(i).getTipo());
				proListAux.add(projectAux);
			}

		}
		return proListAux;
	}

	public List<Projects> getProListAux() {
		return proListAux;
	}

}
