package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import co.gov.coldeportes.redeactiva.redapptiva.R;

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

	public void SingUp(String username, String password, String name,
			String sport, String discapacity, String email) {
		ParseUser user = new ParseUser();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.put("name", name);
		user.put("sport", sport);
		user.put("discapacity", discapacity);

		user.signUpInBackground(new SignUpCallback() {

			@Override
			public void done(com.parse.ParseException arg0) {
				// TODO Auto-generated method stub
				if (arg0 == null) {
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
									R.string.sing_up_wrong_label));
				}

			}
		});
	}

}
