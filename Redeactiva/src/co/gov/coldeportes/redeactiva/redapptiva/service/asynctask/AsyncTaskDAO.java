package co.gov.coldeportes.redeactiva.redapptiva.service.asynctask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.AbstractDAO;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.CalendarDAO;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.MultimediaDAO;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.MySportDAO;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.ProjectDAO;

public class AsyncTaskDAO extends AsyncTask<String, Integer, Boolean> {

	private AbstractDAO abstractDAO;
	private JSONArray restFulResponseArray;

	public AsyncTaskDAO(AbstractDAO ownerDAO) {
		super();
		this.abstractDAO = ownerDAO;
	}

	@Override
	protected Boolean doInBackground(String... params) {
		HttpClient cliente = new DefaultHttpClient();
		HttpGet del = new HttpGet(params[0]);
		String stringResp;
		try {

			HttpResponse resp = cliente.execute(del);
			HttpEntity entity = resp.getEntity();
			stringResp = EntityUtils.toString(entity);
			JSONObject respJSON = new JSONObject(stringResp);
			JSONArray arregloJSON = respJSON.getJSONArray("d");
			restFulResponseArray = arregloJSON;

		} catch (Exception e) {

			return false;

		}
		return true;

	}

	@Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
		if (result) {
			if (abstractDAO instanceof CalendarDAO) {
				CalendarDAO calendarDAO = (CalendarDAO) abstractDAO;
				calendarDAO.fillCalendar(restFulResponseArray);
				// FacadeController.getInstance().dissmissEVentsActivityProgress();
				FacadeController.getInstance().showCalendarEvents();

			} else if (abstractDAO instanceof ProjectDAO) {
				ProjectDAO projectDAO = (ProjectDAO) abstractDAO;
				projectDAO.fillProjects(restFulResponseArray);
				FacadeController.getInstance().dissmissProgressDialogProject();
				FacadeController.getInstance().showProjects();
			} else if (abstractDAO instanceof MultimediaDAO) {
				MultimediaDAO multimediaDAO = new MultimediaDAO();
				//
				multimediaDAO.fillMultimediaObjects(restFulResponseArray);
				FacadeController.getInstance().showMultimediaThings();
				FacadeController.getInstance().dissmissDialogMultimedia();
			}else if(abstractDAO instanceof MySportDAO){
				MySportDAO mySportDAO = (MySportDAO)abstractDAO;
				mySportDAO.fillMySports(restFulResponseArray);
				FacadeController.getInstance().dissmissProgressDialogMySport();
				FacadeController.getInstance().fillMySports();
			}
		} else {
			if (abstractDAO instanceof CalendarDAO) {

				// FacadeController.getInstance().dissmissEVentsActivityProgress();

			} else if (abstractDAO instanceof MultimediaDAO) {

				FacadeController.getInstance().dissmissDialogMultimedia();
			}
		}

	}

}
