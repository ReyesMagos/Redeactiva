package co.gov.coldeportes.redeactiva.redapptiva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Contents;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.QRCodeEncoder;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class CrearGrupoActivity extends ActionBarActivity {

	private ImageView qrCode;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar action = getActionBar();
		action.setTitle("Crear Grupo");
		setContentView(R.layout.activity_crear_grupo);
		qrCode = (ImageView) findViewById(R.id.qrCode);
		QRCodeEncoder qrCodeEncoder = new QRCodeEncoder("Nombre de Usuario: "
				+ FacadeController.getInstance().getLoggedUser().getUsername()
				+ " Discapcidad: "
				+ FacadeController.getInstance().getLoggedUser()
						.getDiscapacity(), null, Contents.Type.TEXT,
				BarcodeFormat.QR_CODE.toString(), 500);

		try {
			Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
			qrCode.setImageBitmap(bitmap);
			save(bitmap);

		} catch (WriterException e) {
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.crear_grupo, menu);
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
