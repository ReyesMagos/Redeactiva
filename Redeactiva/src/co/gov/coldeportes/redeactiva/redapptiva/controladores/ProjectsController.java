package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.ProjectFactory;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Projects;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.ProjectDAO;

public class ProjectsController {

	private ProjectFactory projectFactory;
	private final int LIMIT_MAX = 10;
	private Activity activity;
	public static List<Projects> proListAux;
	

	public ProjectsController(Activity activity) {
		super();
		this.activity = activity;
		ProjectDAO projectDAO = new ProjectDAO();
		projectDAO.executeAsyncTaskDAO();
	}

	public List<Projects> fillListProjects() {
		proListAux = new ArrayList<Projects>();

		this.projectFactory = ProjectFactory.getInstance();

		Projects auxProjects = new Projects();
		proListAux = projectFactory.getProjectsList();
		for(int i = 0; i < LIMIT_MAX; i++){
			proListAux.add(proListAux.get(i));
		}
		
		return proListAux;
	}
	
	

}
