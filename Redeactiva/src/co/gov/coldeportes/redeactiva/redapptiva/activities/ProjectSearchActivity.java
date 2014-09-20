package co.gov.coldeportes.redeactiva.redapptiva.activities;

import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.controladores.ProjectsController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Projects;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProjectSearchActivity extends Activity {

	private ActionBar action;
	private ListView listViewProjects;
	private ProjectsController projectsController;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.project_search_activity);
		action = getActionBar();
		//createComponents();
	}

	public void createComponents() {
		this.listViewProjects = (ListView) super
				.findViewById(R.id.listView_projects);
		projectsController = new ProjectsController(this);
		ArrayAdapter<Projects> arrayAdapter = new ArrayAdapter<Projects>(this,
				android.R.layout.simple_list_item_1,
				projectsController.fillListProjects());
		listViewProjects.setAdapter(arrayAdapter);
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
		
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
