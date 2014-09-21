package co.gov.coldeportes.redeactiva.redapptiva.activities;

import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;

import com.parse.Parse;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {

	private EditText editTextUsername;
	private EditText editTextPassword;
	private FacadeController facadeController;
	private String discapacitySelected;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Parse.initialize(this, "yEffMfmOm0QYmydHzPdFiYWgXWkRm2lYao0ueSkJ",
				"ln1rfhkJO3Twdbh8fmmG08xYZlpH63MLJPF6PSTo");
		init();

		facadeController.registerToController(this);

	}

	public void init() {

		facadeController = FacadeController.getInstance();
		editTextUsername = (EditText) findViewById(R.id.edittext_username1);

		editTextPassword = (EditText) findViewById(R.id.edittext_password1);
	}
	
	public void btnInvitado_Click(View v){
		facadeController.login("invitado", "invitado");	
	}

	public void btnLogin_Click(View v) {
		String username = editTextUsername.getText().toString();
		String password = editTextPassword.getText().toString();

		facadeController.login(username, password);
	}

	public void showSingUpDialog() {

		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		LayoutInflater inflater = LayoutInflater.from(this);

		View dialogview = inflater.inflate(R.layout.sing_up_layout, null);

		dialog.setView(dialogview);
		dialog.setTitle(getResources().getString(R.string.alert_label));

		// set the custom dialog components - text, image and button
		final EditText txtUsername = (EditText) dialogview
				.findViewById(R.id.txtusername);
		final EditText txtPassword = (EditText) dialogview
				.findViewById(R.id.txtpassword);
		final EditText txtEmail = (EditText) dialogview
				.findViewById(R.id.txtemail);
		final EditText txtName = (EditText) dialogview
				.findViewById(R.id.txtname);
		Spinner spDiscapacidad = (Spinner) dialogview
				.findViewById(R.id.spdiscapacity);
		final String[] discapacityOptions = new String[] { "Seleccionar",
				"Vision" };
		ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, discapacityOptions);
		spDiscapacidad.setAdapter(spinnerArrayAdapter);
		spDiscapacidad.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				if (arg2 > 0) {
					discapacitySelected = discapacityOptions[arg2];
				} else {
					discapacitySelected = null;
				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});
		dialog.setPositiveButton(R.string.sing_up_button_label,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						String username = txtUsername.getText().toString();
						String password = txtPassword.getText().toString();
						String email = txtEmail.getText().toString();
						String name = txtName.getText().toString();
						facadeController.singUp(username, password, email,
								username, discapacitySelected);
					}
				});
		
		dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});

		dialog.show();
	}

	public void btnSingUp_Click(View v) {
		showSingUpDialog();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
