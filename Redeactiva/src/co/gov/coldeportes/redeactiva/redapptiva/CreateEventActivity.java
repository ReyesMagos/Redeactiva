package co.gov.coldeportes.redeactiva.redapptiva;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.ProjectDAO;

public class CreateEventActivity extends Activity {

	private EditText txtNumMaxParticipantes;
	private EditText txtNumMinParticipantes;
	private EditText txtLugar;
	private DatePicker fechaPicker;
	private TimePicker hourPicker;
	private TextView txtSport;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_event);
		init();
		FacadeController.getInstance().registerToController(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_event, menu);
		return true;

	}

	public void btnCreateEvent_Click(View v) {
		String fecha = fechaPicker.getDayOfMonth() + "/"
				+ Integer.toString(fechaPicker.getMonth() + 1) + "/"
				+ fechaPicker.getYear();
		String numMax = txtNumMaxParticipantes.getText().toString();
		String numMin = txtNumMinParticipantes.getText().toString();
		String lugar = txtLugar.getText().toString();
		String hora = hourPicker.getCurrentHour() + ":"
				+ hourPicker.getCurrentMinute();
		FacadeController.getInstance().createEvent(
				fecha,
				numMax,
				numMin,
				lugar,
				FacadeController.getInstance().getLoggedUser()
						.getDepartamento(),
				FacadeController.getInstance().getLoggedUser().getMunicipio(),
				hora);
	}

	public void init() {

		fechaPicker = (DatePicker) findViewById(R.id.fechapicker);
		txtNumMaxParticipantes = (EditText) findViewById(R.id.txtmaxnumparticipantntes);
		txtNumMinParticipantes = (EditText) findViewById(R.id.txtminnumparticipantes);
		txtLugar = (EditText) findViewById(R.id.txtLugar);
		hourPicker = (TimePicker) findViewById(R.id.horapicker);
		txtSport = (TextView) findViewById(R.id.txtsport2);
		txtSport.setText(FacadeController.getInstance().getSportSelected());
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
