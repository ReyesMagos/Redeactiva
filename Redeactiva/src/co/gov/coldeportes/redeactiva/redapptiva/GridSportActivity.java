package co.gov.coldeportes.redeactiva.redapptiva;

import java.util.ArrayList;
import java.util.List;

import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.OpcionesGrid;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.CustomAdapterGridPrincipal;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

@SuppressLint("NewApi")
public class GridSportActivity extends ActionBarActivity {

	private GridView gridSpoGridView;
	ActionBar action;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_sport);
		gridSpoGridView = (GridView) findViewById(R.id.gridSport);
		action = getActionBar();
		action.setTitle("Seleccion de Deporte");
		action.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.barra));

		// action.setBackgroundDrawable(d)
		List<OpcionesGrid> lista = new ArrayList<OpcionesGrid>();

		OpcionesGrid opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_arco));
		opcionesGrid.setOptionName("Arco");
		lista.add(opcionesGrid);

		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_atletismo));
		opcionesGrid.setOptionName("Atletismo");
		lista.add(opcionesGrid);

		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_baloncesto));
		opcionesGrid.setOptionName("Baloncesto");
		lista.add(opcionesGrid);

		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_ciclismo));
		opcionesGrid.setOptionName("Ciclismo");
		lista.add(opcionesGrid);

		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_esgrima));
		opcionesGrid.setOptionName("Esgrima");
		lista.add(opcionesGrid);
		CustomAdapterGridPrincipal customAdapterGridPrincipal = new CustomAdapterGridPrincipal(
				this, lista);
		gridSpoGridView.setAdapter(customAdapterGridPrincipal);

		gridSpoGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent i;
				switch (arg2) {
				case 0:
					FacadeController.getInstance().setSportSelected("Arco");
					break;
				case 1:
					FacadeController.getInstance()
							.setSportSelected("Atletismo");
					break;
				case 2:
					FacadeController.getInstance().setSportSelected(
							"Baloncesto");
					break;
				case 3:
					FacadeController.getInstance().setSportSelected("Ciclismo");
					break;
				case 4:
					FacadeController.getInstance().setSportSelected("Esgrima");
					break;

				}

				if (FacadeController.getInstance()
						.getActivitySelectedFromGrid()
						.equals("Busqueda_Evento")) {
					i = new Intent(getApplicationContext(),
							EventsActivity.class);
					startActivity(i);

				} else if (FacadeController.getInstance()
						.getActivitySelectedFromGrid()
						.equals("Publicacion_Evento")) {
					i = new Intent(getApplicationContext(),
							CreateEventActivity.class);
					startActivity(i);

				} else {

				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid_sport, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
