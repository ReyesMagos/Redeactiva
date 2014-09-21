package co.gov.coldeportes.redeactiva.redapptiva.service.dao;

public class MultimediaDAO extends AbstractDAO {

	public void executeAsyncTaskDAO() {
		// TODO Auto-generated method stub
		super.executeAsyncTaskDAO("http://servicedatosabiertoscolombia.cloudapp.net/v1/Coldeportes/multimedia?$format=json");
	}

}
