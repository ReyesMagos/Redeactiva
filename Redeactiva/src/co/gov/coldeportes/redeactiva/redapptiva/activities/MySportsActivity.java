package co.gov.coldeportes.redeactiva.redapptiva.activities;

import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Usuario;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

public class MySportsActivity extends ActionBarActivity {

	private String discapacity;
	private Usuario usuario;
	private ListView listViewMySport;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_sports_activity);
		initComponents();
		FacadeController.getInstance().registerToController(this);
		
		usuario = FacadeController.getInstance().getLoggedUser();
		discapacity = usuario.getDiscapacity();

	}

	public void initComponents() {
		this.listViewMySport = (ListView) super
				.findViewById(R.id.listView_mysports);
	}
	
	public ListView getListViewMySport() {
		return listViewMySport;
	}
	
	public void setListViewMySport(ListView listViewMySport) {
		this.listViewMySport = listViewMySport;
	}

}
