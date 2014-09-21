package co.gov.coldeportes.redeactiva.redapptiva;

import java.util.ArrayList;
import java.util.List;

import co.gov.coldeportes.redeactiva.redapptiva.activities.ProjectSearchActivity;
import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.OpcionesGrid;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.CustomAdapterGridPrincipal;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

@SuppressLint("NewApi")
public class PrincipalGridActivity extends ActionBarActivity {

	private GridView gridPrincipal;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal_grid);
		gridPrincipal = (GridView) findViewById(R.id.gridPrincipal);
		android.app.ActionBar action = getActionBar();
		action.setTitle("Pantalla de Opciones Principales");

		// 0
		List<OpcionesGrid> lista = new ArrayList<OpcionesGrid>();
		OpcionesGrid opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_busqueda_eventos));
		opcionesGrid
				.setOptionName("Busqueda de eventos. Eligiendo esta opcion puedes buscar eventos Tanto Nacionales como Internacionales. Los eventos pueden ser Creados por Coldeportes, El comite ParaOlimpico u Otro Usuario de la aplicacion");
		lista.add(opcionesGrid);

		// 1
		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_publicar_evento));
		opcionesGrid
				.setOptionName("Publicacion evento, pulsando esta opcion deportivos recreativos, en esta opcion puedes encontrar con quien practicar tu deporte favorito, formar un equipo y entrenar");
		lista.add(opcionesGrid);

		// 2
		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_perfil));
		opcionesGrid
				.setOptionName("Perfil, Pulsando esta opciones puedes ver tu perfil de usuario, editarlo, Admintrar los eventos que tienes creados y ver las personas que siguen tu progreso dentro de la red");
		lista.add(opcionesGrid);

		// 3
		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_portafolio));
		opcionesGrid
				.setOptionName("Portafolio de Servicios, pulsando esta opcion puedes encontrar, los programas con los cuales cuentan las entidades del pais, para el deporte social comunitario y recreativo.");
		lista.add(opcionesGrid);

		// 4
		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_experiencias));
		opcionesGrid
				.setOptionName("Experiencias, Pulsando esta opcion puedes ver las experiencias de los demas usuarios, que al igual que tu encuentran en el deporte una oportunidad de vida.");
		lista.add(opcionesGrid);

		// 5
		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_misdeportes));
		opcionesGrid
				.setOptionName("Mis Deportes, Pulsando esta opcion podras encontrar los deportes a los que tu puedes acceder");
		lista.add(opcionesGrid);

		// 6
		CustomAdapterGridPrincipal adapterGridPrincipal = new CustomAdapterGridPrincipal(
				this, lista);
		gridPrincipal.setAdapter(adapterGridPrincipal);

		gridPrincipal.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				switch (arg2) {
				case 0:
					FacadeController.getInstance().setActivitySelectedFromGrid(
							"Busqueda_Evento");
					Intent i = new Intent(getApplicationContext(),
							GridSportActivity.class);
					startActivity(i);
					break;
				case 1:
					FacadeController.getInstance().setActivitySelectedFromGrid(
							"Publicacion_Evento");
					Intent i1 = new Intent(getApplicationContext(),
							GridSportActivity.class);
					startActivity(i1);
					break;
				case 2:
					FacadeController.getInstance().setActivitySelectedFromGrid(
							"Perfil");
					break;
				case 3:
					FacadeController.getInstance().setActivitySelectedFromGrid(
							"Portafolio");
				
					FacadeController.getInstance().setNotice("china");
					startActivity(new Intent(getApplicationContext(), ProjectSearchActivity.class));
					break;
				case 4:
					FacadeController.getInstance().setActivitySelectedFromGrid(
							"Experiencias");
					Intent i44 = new Intent(getApplicationContext(),
							MultimediaActivity.class);
					startActivity(i44);
					break;
				case 5:
					FacadeController.getInstance().setActivitySelectedFromGrid(
							"Mis_Deportes");
					Intent i2 = new Intent(getApplicationContext(),
							GridSportActivity.class);
					startActivity(i2);
					break;
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal_grid, menu);
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
