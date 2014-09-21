package co.gov.coldeportes.redeactiva.redapptiva;

import java.util.ArrayList;
import java.util.List;

import co.gov.coldeportes.redeactiva.redapptiva.activities.ProjectSearchActivity;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Noticia;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.CustomAdapterNews;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.CalendarDAO;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class NewsActivity extends Activity {

	private ListView listViewNews;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		listViewNews = (ListView) findViewById(R.id.lvNews);
		
		List<Noticia> newss = new ArrayList<Noticia>();
		
		Noticia n = new Noticia();
		n.setTitulo("ELECCIÓN COLOMBIA DE RUGBY EN SILLA DE RUEDAS CLASIFICÓ A "
				+ "LOS JUEGOS PARAPANAMERICANOS DE TORONTO 2015");
		n.setContenido("El equipo Colombiano de Rugby en silla de ruedas "
				+ "logra su clasificación a los Juegos Parapanamericanos "
				+ "Toronto 2015, tras ocupar el tercer lugar en el pasado Campeonato"
				+ " Sudamericano de esta disciplina ");
		newss.add(n);

		n = new Noticia();
		n.setTitulo("COLOMBIA TIENE CAMPEÓN EN LA CATEGORÍA C2 DEL UCI PARACYCLING "
				+ "ROAD WORLD CHAMPIONSHIPS IN GREENVILLE SC ");
		n.setContenido("En la tarde de ayer, durante su practica deportiva, "
				+ "se realizó el abanderamiento del equipo de Judo Paralímpico Colombiano");
		newss.add(n);

		n = new Noticia();
		n.setTitulo("ABANDERAMIENTO JUDO PARALÍMPICO ");
		n.setContenido("El Ciclista Paralimpico Santandereano Alvaro Galvis, también nos "
				+ "llena gloria trayendo medalla de Oro, en el mundial 2014");
		newss.add(n);

		CustomAdapterNews customAdapterNews = new CustomAdapterNews(this, newss);
		listViewNews.setAdapter(customAdapterNews);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			startActivity(new Intent(this, ProjectSearchActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
