package co.gov.coldeportes.redeactiva.redapptiva;

import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MultimediaActivity extends ActionBarActivity {

	private ListView listaMultimedia;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multimedia);
		init();
		FacadeController.getInstance().registerToController(this);
	}

	public void init() {
		listaMultimedia = (ListView) findViewById(R.id.listMultimedia1);
	}

	public ListView getListaMultimedia() {
		return listaMultimedia;
	}

	public void setListaMultimedia(ListView listaMultimedia) {
		this.listaMultimedia = listaMultimedia;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.multimedia, menu);
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
