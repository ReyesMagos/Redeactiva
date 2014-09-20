package co.gov.coldeportes.redeactiva.redapptiva.entity.factory;

import org.json.JSONArray;

import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.interfaces.ICalendarFactory;

public class CalendarFactory  implements ICalendarFactory  {

	private static CalendarFactory instance;

	private CalendarFactory(){

	}

	public static CalendarFactory getInstance() {
		if (instance == null)
			instance = new CalendarFactory();
		return instance;
	}

	@Override
	public void fillCalendar(JSONArray arreglo) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
