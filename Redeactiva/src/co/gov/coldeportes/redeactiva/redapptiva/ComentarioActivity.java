package co.gov.coldeportes.redeactiva.redapptiva;

import java.util.ArrayList;
import java.util.List;

import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Comentario;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ComentarioActivity extends ActionBarActivity {

	List<Comentario> listaComentario;
	private ListView listaView;
	private TextView txtComentario;
	List<Comentario> lista2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comentario);
		listaView = (ListView) findViewById(R.id.listComentarios);
		txtComentario = (TextView) findViewById(R.id.txtComent);
		createComents();
		getComentarios(FacadeController.getInstance().getNotice());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comentario, menu);
		return true;
	}

	public void Comentar(View v) {
		String come = txtComentario.getText().toString();
		Comentario c = new Comentario();
		c.setAutor(FacadeController.getInstance().getLoggedUser().getUsername());
		c.setComentario(come);
		c.setNotice(FacadeController.getInstance().getNotice());
		lista2.add(c);

		String x[] = new String[lista2.size()];
		int i = 0;
		for (Comentario xs : lista2) {
			x[i] = xs.getAutor() + "--" + xs.getComentario();
			i++;

		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, x);
		listaView.setAdapter(adapter);

	}

	public void createComents() {
		listaComentario = new ArrayList<Comentario>();
		Comentario c = new Comentario();
		c.setAutor("Oscarg798");
		c.setComentario("Excelente que ya esten cerca de cumplir el Sueño");
		c.setNotice("china");
		listaComentario.add(c);

		c = new Comentario();
		c.setAutor("MarioJ");
		c.setComentario("Muchos Exitos para Los muchachos de la seleccion");
		c.setNotice("china");
		listaComentario.add(c);

		c = new Comentario();
		c.setAutor("yefry15");
		c.setComentario("Cada nuevo Reto es un peldaño que se alcanza en la vida");
		c.setNotice("china");
		listaComentario.add(c);

		c = new Comentario();
		c.setAutor("Yenis14");
		c.setComentario("Juegos Paramericanos de toronto una oportunidad para todos los colombianos");
		c.setNotice("toronto");
		listaComentario.add(c);

		c = new Comentario();
		c.setAutor("Capitan yepes");
		c.setComentario("Como desearia estar con ustedes compitiendo");
		c.setNotice("china");
		listaComentario.add(c);

		c = new Comentario();
		c.setAutor("Aura");
		c.setComentario("Nuevas Oportunidades para todos");
		c.setNotice("incheon");
		listaComentario.add(c);

		c = new Comentario();
		c.setAutor("Aura22");
		c.setComentario("Definitivamente mi Seleccion de Basket si es la mejor");
		c.setNotice("incheon");
		listaComentario.add(c);

		c = new Comentario();
		c.setAutor("Aura22");
		c.setComentario("Vamos mis Muchachos");
		c.setNotice("incheon");
		listaComentario.add(c);
	}

	public void getComentarios(String notice) {
		lista2 = new ArrayList<Comentario>();
		for (Comentario c : listaComentario) {
			if (c.getNotice().equals(notice)) {
				lista2.add(c);
			}
		}

		String x[] = new String[lista2.size()];
		int i = 0;
		for (Comentario c : lista2) {
			x[i] = c.getAutor() + "--" + c.getComentario();
			i++;

		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, x);
		listaView.setAdapter(adapter);
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
