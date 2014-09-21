package co.gov.coldeportes.redeactiva.redapptiva.service.dao;

import org.json.JSONArray;

import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.MultimediaFactory;

public class MultimediaDAO extends AbstractDAO {

	public void executeAsyncTaskDAO() {
		// TODO Auto-generated method stub
		super.executeAsyncTaskDAO("http://servicedatosabiertoscolombia.cloudapp.net/v1/Coldeportes/multimedia?$format=json");
	}

	public void fillMultimediaObjects(JSONArray arreglo) {
		MultimediaFactory.getInstance().fillMultimedia(arreglo);
	}

}
