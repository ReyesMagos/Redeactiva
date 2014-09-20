package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import co.gov.coldeportes.redeactiva.redapptiva.CreateEventActivity;
import co.gov.coldeportes.redeactiva.redapptiva.NewsActivity;
import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Usuario;

import com.parse.LogInCallback;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.ParseException;
import android.util.Log;

public class LoginController extends AbstractController {

	public LoginController(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showAlertMessage(String title, String message) {
		// TODO Auto-generated method stub
		super.showAlertMessage(title, message);
	}

	@Override
	public void showProgressDialog(String title, String message) {
		// TODO Auto-generated method stub
		super.showProgressDialog(title, message);
	}

	@Override
	public void dissmissProgressDialog() {
		// TODO Auto-generated method stub
		super.dissmissProgressDialog();
	}

	@Override
	public void setProgressDialog(ProgressDialog progressDialog) {
		// TODO Auto-generated method stub
		super.setProgressDialog(progressDialog);
	}

	@Override
	public void changeActivity(Class<?> destinyClass) {
		// TODO Auto-generated method stub
		super.changeActivity(destinyClass);
	}

	public void longIn(String username, String password) {
		ParseUser.logInInBackground(username, password, new LogInCallback() {

			@Override
			public void done(ParseUser arg0, com.parse.ParseException arg1) {
				// TODO Auto-generated method stub
				if (arg1 == null) {
					Usuario loggedUser = new Usuario();
					loggedUser.setNombre(arg0.getString("name"));
					loggedUser.setEmail(arg0.getEmail());
					loggedUser.setUsername(arg0.getUsername());
					loggedUser.setUserType(arg0.getInt("userType"));
					if (loggedUser.getUserType() == 1) {
						loggedUser.setDiscapacity(arg0.getString("discapacity"));
					}
					Log.i("User", "REgistrado");
					FacadeController.getInstance().setLoggedUser(loggedUser);
					changeActivity(CreateEventActivity.class);
				}
				dissmissProgressDialog();
			}

		});
	}

	public void SingUp(String username, String password, String name,
			String discapacity, String email) {
		ParseUser user = new ParseUser();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.put("name", name);
		if (discapacity != null) {
			user.put("discapacity", discapacity);
			user.put("userType", 1);
		} else {
			user.put("userType", 2);
		}

		user.signUpInBackground(new SignUpCallback() {

			@Override
			public void done(com.parse.ParseException arg0) {
				// TODO Auto-generated method stub
				if (arg0 == null) {
					// showProgressDialog(
					// getActivity().getResources().getString(
					// R.string.alert_label),
					// getActivity().getResources().getString(
					// R.string.login_process_ongoing));
					showAlertMessage(
							getActivity().getResources().getString(
									R.string.alert_label),
							getActivity().getResources().getString(
									R.string.sing_up_success_label));
				} else {
					showAlertMessage(
							getActivity().getResources().getString(
									R.string.alert_label),
							getActivity().getResources().getString(
									R.string.sing_up_wrong_label)
									+ arg0.getMessage().toString());
				}
				dissmissProgressDialog();

			}
		});
	}

}
