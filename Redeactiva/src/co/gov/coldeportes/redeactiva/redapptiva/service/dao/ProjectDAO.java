package co.gov.coldeportes.redeactiva.redapptiva.service.dao;

import org.json.JSONArray;

import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.ProjectFactory;

public class ProjectDAO extends AbstractDAO {

	public void executeAsyncTaskDAO() {
		// TODO Auto-generated method stub
		super.executeAsyncTaskDAO("http://servicedatosabiertoscolombia."
				+ "cloudapp.net/v1/Coldeportes/portafolioproyectos?$format=json");
	}

	public void fillProjects(JSONArray array) {
		ProjectFactory.getInstance().fillProjects(array);
	}

}
