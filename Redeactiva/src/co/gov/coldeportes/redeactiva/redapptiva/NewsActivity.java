package co.gov.coldeportes.redeactiva.redapptiva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

import co.gov.coldeportes.redeactiva.redapptiva.activities.ProjectSearchActivity;
import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Contents;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Noticia;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.QRCodeEncoder;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.CustomAdapterNews;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.CalendarDAO;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

@SuppressLint("NewApi")
public class NewsActivity extends ActionBarActivity {

	private ListView listViewNews;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		listViewNews = (ListView) findViewById(R.id.lvNews);
		ActionBar action = getActionBar();
		action.setTitle("Noticas");

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
		listViewNews.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if (arg2 == 0) {
					FacadeController.getInstance().setNotice("toronto");
				} else if (arg2 == 1) {
					FacadeController.getInstance().setNotice("china");
				} else {
					FacadeController.getInstance().setNotice("incheon");

				}
				Intent i = new Intent(getApplicationContext(),
						ComentarioActivity.class);
				startActivity(i);

			}
		});

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
			QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(
					"Ola Felipe Eres Lindo", null, Contents.Type.TEXT,
					BarcodeFormat.QR_CODE.toString(), 500);

			try {
				Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();

				save(bitmap);

			} catch (WriterException e) {
				e.printStackTrace();
			}
			return true;
		} else if (id == R.id.botonGrid) {
			startActivity(new Intent(this, PrincipalGridActivity.class));
		}
		return super.onOptionsItemSelected(item);
	}

	public void save(Bitmap bitmap) {
		String file_path = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/QR";
		File dir = new File(file_path);
		if (!dir.exists())
			dir.mkdirs();
		Random r = new Random();
		int x = r.nextInt();
		File file = new File(dir, "QR" + x + ".png");
		FileOutputStream fOut;
		try {
			fOut = new FileOutputStream(file);
			bitmap.compress(Bitmap.CompressFormat.PNG, 85, fOut);
			showAlertMessage("Exito", "Archivo Generado Con Exito. Ruta: "
					+ file_path);
			fOut.flush();
			fOut.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showAlertMessage(String title, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle(title);

		builder.setMessage(message).setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

					}
				});

		AlertDialog dialog = builder.show();
		dialog.show();
	}

}
