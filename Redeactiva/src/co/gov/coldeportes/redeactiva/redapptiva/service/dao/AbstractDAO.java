package co.gov.coldeportes.redeactiva.redapptiva.service.dao;

import co.gov.coldeportes.redeactiva.redapptiva.service.asynctask.AsyncTaskDAO;
import co.gov.coldeportes.redeactiva.redapptiva.service.asynctask.ParseAsyncTask;

import com.parse.ParseQuery;

public abstract class AbstractDAO {

	public void executeAsyncTaskDAO(String url) {
		AsyncTaskDAO asyncTaskDAO = new AsyncTaskDAO(this);
		asyncTaskDAO.execute(url);
	}

	public void executeAsyncTaskParse(ParseQuery parsequery) {
		ParseAsyncTask parceAsyncTask = new ParseAsyncTask(this);
		parceAsyncTask.execute(parsequery);
	}
}
