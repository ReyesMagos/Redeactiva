package co.gov.coldeportes.redeactiva.redapptiva.entity.factory;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.MySport;

public class MySportFactory {

	public static MySportFactory mySportInstance;
	private final String DEPORTE = "Atletismo";
	private final String DISCAPACIDAD = "Fisica";
	private List<MySport> mySportList;

	private MySportFactory() {

	}

	public static MySportFactory getInstance() {
		if (mySportInstance == null) {
			mySportInstance = new MySportFactory();
		}
		return mySportInstance;
	}

	public void fillMySports(JSONArray jsonArray) {
		JSONObject jsonObject = new JSONObject();
		mySportList = new ArrayList<MySport>();

		if (jsonArray == null || jsonArray.length() == 0) {
			return;
		}

		try {
			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObject = jsonArray.getJSONObject(i);
				MySport mySportObject = new MySport();

				mySportObject.setPartitionKey(jsonObject
						.getString("PartitionKey"));
				mySportObject.setRowKey(jsonObject.getString("RowKey"));
				mySportObject.setTipo(jsonObject.getString("tipo"));
				mySportObject.setDeporte(jsonObject.getString("deporte"));
				mySportObject.setDescripcionDeporte(jsonObject
						.getString("descripciondeldeporte"));
				mySportObject.setClasificacionFuncional(jsonObject
						.getString("clasificacionfuncional"));
				mySportObject.setSitioWeb(jsonObject.getString("sitioweb"));
				mySportObject.setDiscapacidad(jsonObject
						.getString("discapacidad"));
				mySportObject.setDescripcionDiscapacidad(jsonObject
						.getString("descripciondiscapacidad"));
				mySportObject.setRanking(jsonObject.getString("ranking"));
				mySportList.add(mySportObject);
			}
		} catch (JSONException e) {
			// TODO: handle exception
		}
	}

	public List<MySport> getMySportList() {
		return mySportList;
	}

	public List<MySport> filterSports() {
		List<MySport> mySportsAux = new ArrayList<MySport>();
		MySport aux = new MySport();
		for (int i = 0; i < getMySportList().size(); i++) {
			if (FacadeController.getInstance().getSportSelected().equals(getMySportList().get(i).getDeporte())
					&& FacadeController.getInstance().getLoggedUser().getDiscapacity().equals(getMySportList().get(i)
							.getDiscapacidad())) {
				aux.setTipo(getMySportList().get(i).getTipo());
				aux.setClasificacionFuncional(getMySportList().get(i)
						.getClasificacionFuncional());
				aux.setDescripcionDiscapacidad(getMySportList().get(i)
						.getDescripcionDiscapacidad());
				mySportsAux.add(aux);
			}
		}

		return mySportsAux;
	}

}
