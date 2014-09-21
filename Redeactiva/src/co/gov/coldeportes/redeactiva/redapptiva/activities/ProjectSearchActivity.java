package co.gov.coldeportes.redeactiva.redapptiva.activities;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.controladores.ProjectsController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.ProjectCustomAdapter;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.ProjectDAO;

public class ProjectSearchActivity extends ActionBarActivity {

	private ActionBar action;
	private ListView listViewProjects;
	private ProjectsController projectsController;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.project_search_activity);
		action = getActionBar();
		createComponents();

		FacadeController.getInstance().registerToController(this);

	}

	public void createComponents() {
		this.listViewProjects = (ListView) super
				.findViewById(R.id.listView_projects);

		// projectsController = new ProjectsController();
		// ProjectCustomAdapter projectCustomAdapter = new ProjectCustomAdapter(
		// this, projectsController.getProListAux());
		// listViewProjects.setAdapter(projectCustomAdapter);
	}

	public void setAction(ActionBar action) {
		this.action = action;
	}

	public ActionBar getAction() {
		return action;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			startActivity(new Intent(this, MySportsActivity.class));
			return true;
		}else if(id == R.id.action_filter){
			FacadeController.getInstance().showFiltersForProjects();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public ListView getListViewProjects() {
		return listViewProjects;
	}
}
