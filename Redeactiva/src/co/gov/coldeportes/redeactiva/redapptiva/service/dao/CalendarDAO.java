package co.gov.coldeportes.redeactiva.redapptiva.service.dao;

import org.json.JSONArray;

import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.CalendarFactory;

public class CalendarDAO extends AbstractDAO {

	public void executeAsyncTaskDAO() {
		// TODO Auto-generated method stub
		super.executeAsyncTaskDAO("http://servicedatosabiertoscolombia."
				+ "cloudapp.net/v1/Coldeportes/calendario?$format=json");
	}

	public void fillCalendar(JSONArray array) {
		CalendarFactory.getInstance().fillCalendar(array);
	}

}
