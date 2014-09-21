package co.gov.coldeportes.redeactiva.redapptiva;

import java.util.ArrayList;
import java.util.List;

import co.gov.coldeportes.redeactiva.redapptiva.entity.model.OpcionesGrid;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.CustomAdapterGridPrincipal;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

public class GridSportActivity extends ActionBarActivity {

	private GridView gridSpoGridView;
	ActionBar action;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_sport);
		gridSpoGridView = (GridView) findViewById(R.id.gridSport);
		action = getActionBar();
		action.setTitle("Seleccion de Deporte");
		CustomAdapterGridPrincipal customAdapterGridPrincipal = new CustomAdapterGridPrincipal(
				this, null);
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

		gridSpoGridView.setAdapter(customAdapterGridPrincipal);

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
