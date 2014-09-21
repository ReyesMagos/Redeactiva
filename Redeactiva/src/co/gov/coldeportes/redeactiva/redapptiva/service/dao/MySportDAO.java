package co.gov.coldeportes.redeactiva.redapptiva.service.dao;

import org.json.JSONArray;

import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.MySportFactory;

public class MySportDAO extends AbstractDAO {

	public void executeAsyncTaskDAO() {
		// TODO Auto-generated method stub
		super.executeAsyncTaskDAO("http://servicedatosabiertoscolombia."
				+ "cloudapp.net/v1/Coldeportes/rendimientodeportivoparaolimpico?$format=json");
	}
	
	public void fillMySports(JSONArray jsonArray){
		MySportFactory.getInstance().fillMySports(jsonArray);
	}

}
