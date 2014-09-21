package co.gov.coldeportes.redeactiva.redapptiva.service.asynctask;

import java.util.List;

import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.AbstractDAO;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.EventoDAO;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.os.AsyncTask;

public class ParseAsyncTask extends AsyncTask<ParseQuery, String, Boolean> {

	private AbstractDAO ownerDAO;
	private List daoResults;

	public ParseAsyncTask(AbstractDAO ownerDAO) {
		super();
		this.ownerDAO = ownerDAO;
	}

	@Override
	protected Boolean doInBackground(ParseQuery... queries) {
		// TODO Auto-generated method stub
		ParseQuery query = queries[0];
		try {
			daoResults = query.find();

			return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if (result) {
			if (ownerDAO instanceof EventoDAO) {
				EventoDAO e = (EventoDAO) ownerDAO;
				e.createAndShowEvents(daoResults);
				FacadeController.getInstance().dissmissEVentsActivityProgress();

			}

		}
	}

}
