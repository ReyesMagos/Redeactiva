package co.gov.coldeportes.redeactiva.redapptiva.entity.factory;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.interfaces.ICalendarFactory;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Calendar;

public class CalendarFactory implements ICalendarFactory {

	private static CalendarFactory instance;
	private List<Calendar> calendarList;

	private CalendarFactory() {

	}

	public static CalendarFactory getInstance() {
		if (instance == null)
			instance = new CalendarFactory();
		return instance;
	}

	@Override
	public void fillCalendar(JSONArray arreglo) {
		// TODO Auto-generated method stub
		calendarList = new ArrayList<Calendar>();
		if (arreglo == null || arreglo.length() == 0) {
			return;
		}

		JSONObject object;
		try {
			for (int i = 0; i < arreglo.length(); i++) {
				object = arreglo.getJSONObject(i);

				Calendar c = new Calendar();
				c.setPartitionKey(object.getString("PartitionKey"));
				c.setRowKey(object.getString("RowKey"));
				c.setEvento(object.getString("evento"));
				c.setTipo(object.getString("tipo"));
				c.setFechaInicio(object.getString("fechainicio"));
				c.setFechaFinal(object.getString("fechafinal"));
				c.setPais(object.getString("pais"));
				c.setTerritorio(object.getString("territorio"));
				c.setEntidad(object.getString("entidad"));
				c.setClaseDeEvento(object.getString("clasedeevento"));

				c.setNivel(object.getString("nivel"));
				c.setDescripcionDelEvento(object
						.getString("descripciondelevento"));
				c.setPaginaWeb(object.getString("paginaweb"));
				c.setContacto(object.getString("contacto"));
				c.setResultados(object.getString("resultados"));

				calendarList.add(c);

			}
		} catch (JSONException e) {

		}
	}

}
