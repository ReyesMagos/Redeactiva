package co.gov.coldeportes.redeactiva.redapptiva.service.asynctask;

import co.gov.coldeportes.redeactiva.redapptiva.service.dao.AbstractDAO;
import android.os.AsyncTask;

public class AsyncTaskDAO extends AsyncTask<String, Integer, Boolean> {

	private AbstractDAO abstractDAO;
	
	public AsyncTaskDAO (AbstractDAO ownerDAO){
		super();
		this.abstractDAO = ownerDAO;
	}
	
	@Override
	protected Boolean doInBackground(String... params) {
		
		return null;
	}

}
