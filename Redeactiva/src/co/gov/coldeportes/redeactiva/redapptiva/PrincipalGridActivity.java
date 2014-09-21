package co.gov.coldeportes.redeactiva.redapptiva;

import java.util.ArrayList;
import java.util.List;

import co.gov.coldeportes.redeactiva.redapptiva.entity.model.OpcionesGrid;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.CustomAdapterGridPrincipal;
import android.support.v7.app.ActionBarActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;

public class PrincipalGridActivity extends ActionBarActivity {

	private GridView gridPrincipal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal_grid);
		gridPrincipal = (GridView) findViewById(R.id.gridPrincipal);
		List<OpcionesGrid> lista = new ArrayList<OpcionesGrid>();
		OpcionesGrid opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_busqueda_eventos));
		opcionesGrid
				.setOptionName("Busqueda de eventos. Eligiendo esta opciones puedes buscar eventos Tanto Nacionales como Internacionales. Los eventos pueden ser Creados por Coldeportes, El comite ParaOlimpico u Otro Usuario de la aplicacion");
		lista.add(opcionesGrid);

		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_perfil));
		opcionesGrid
				.setOptionName("Perfil, Pulsando esta opciones puedes ver tu perfil de usuario, editarlo, Admintrar los eventos que tienes creados y ver las personas que siguen tu progreso dentro de la red");
		lista.add(opcionesGrid);

		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_publicar_evento));
		opcionesGrid
				.setOptionName("Publicacion evento, pulsando esta opcion deportivos recreativos, en esta opcion puedes encontrar con quien practicar tu deporte favorito, formar un equipo y entrenar");
		lista.add(opcionesGrid);

		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_portafolio));
		opcionesGrid
				.setOptionName("Portafolio de Servicios, pulsando esta opcion puedes encontrar, buscar, y filtrar los programas con los cuales cuentan las entidades del pais, para el deporte social comunitario y recreativo. Puedes buscar la que mas se ajuste a tus necesidades, de ubicacion o accesibilidad");
		lista.add(opcionesGrid);

		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_experiencias));
		opcionesGrid
				.setOptionName("Experiencias, Pulsando esta opcion puedes ver las experiencias de los demas usuarios, que al igual que tu encuentran en el deporte una oportunidad de vida. Puedes comentar las experiencias de los demas para que ellos las vean y publicar las tuyas");
		lista.add(opcionesGrid);

		opcionesGrid = new OpcionesGrid();
		opcionesGrid.setImageSource(BitmapFactory.decodeResource(
				getResources(), R.drawable.boton_misdeportes));
		opcionesGrid
				.setOptionName("Mis Deportes, Pulsando esta opcion podras encontrar los deportes a los que tu puedes acceder, y no te desanimes que en cada uno de ellos te indicaremos el sector en el que te encuntras y cual es tu competencia para que comprendas a fondo el deporte de tu interes y puedad obtener un buen desempeño");
		lista.add(opcionesGrid);

		CustomAdapterGridPrincipal adapterGridPrincipal = new CustomAdapterGridPrincipal(
				this, lista);
		gridPrincipal.setAdapter(adapterGridPrincipal);

		gridPrincipal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), GridSportActivity.class);
				startActivity(i);

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
