package co.gov.coldeportes.redeactiva.redapptiva.entity.factory;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Multimedia;

public class MultimediaFactory {
	private static MultimediaFactory instance;
	private List<Multimedia> listaMultimedia;

	private MultimediaFactory() {

	}

	public static MultimediaFactory getInstance() {
		if (instance == null)
			instance = new MultimediaFactory();
		return instance;
	}

	public void fillMultimedia(JSONArray arreglo) {
		listaMultimedia = new ArrayList<Multimedia>();
		if (arreglo == null || arreglo.length() == 0) {
			return;
		}

		JSONObject object;
		try {
			for (int i = 0; i < arreglo.length(); i++) {
				object = arreglo.getJSONObject(i);
				Multimedia m = new Multimedia();
				m.setNombre(object.getString("nombre"));
				m.setDescripcion(object.getString("descripcion"));
				m.setLink(object.getString("linkvideoimagen"));
				listaMultimedia.add(m);
			}
		} catch (Exception e) {

		}
	}

}
