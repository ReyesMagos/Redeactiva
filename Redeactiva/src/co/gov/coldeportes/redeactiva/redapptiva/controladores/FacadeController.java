package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.activities.MainActivity;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Usuario;
import android.app.Activity;

public class FacadeController {

	private static FacadeController instance;
	private LoginController loginController;
	private Usuario loggedUser;

	private FacadeController() {

	}

	public static FacadeController getInstance() {
		if (instance == null)
			instance = new FacadeController();
		return instance;
	}

	public void registerToController(Activity activity) {
		if (activity instanceof MainActivity) {
			loginController = new LoginController(activity);
		}
	}

	public void login(String username, String password) {
		loginController.longIn(username, password);
		loginController.showProgressDialog(
				loginController.getActivity().getResources()
						.getString(R.string.alert_label),
				loginController.getActivity().getResources()
						.getString(R.string.log_in_process_label));
	}

	public void singUp(String username, String password, String email,
			String name, String discapacity) {
		loginController.showProgressDialog(
				loginController.getActivity().getResources()
						.getString(R.string.alert_label),
				loginController.getActivity().getResources()
						.getString(R.string.sing_up_process_label));
		loginController.SingUp(username, password, name, discapacity, email);
	}

	public Usuario getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(Usuario loggedUser) {
		this.loggedUser = loggedUser;
	}
	
	
}
