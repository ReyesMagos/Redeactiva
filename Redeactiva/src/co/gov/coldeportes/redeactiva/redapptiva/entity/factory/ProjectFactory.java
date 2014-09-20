package co.gov.coldeportes.redeactiva.redapptiva.entity.factory;

public class ProjectFactory {
	
	public static ProjectFactory projectInstance;
	
	private ProjectFactory(){
		
	}
	
	public static ProjectFactory getInstance(){
		if(projectInstance == null){
			projectInstance = new ProjectFactory();
		}
		
		return projectInstance;
	}

}
