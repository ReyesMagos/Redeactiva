package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import co.gov.coldeportes.redeactiva.redapptiva.MainActivity;
import android.app.Activity;

public class FacadeController {

	private static FacadeController instance;
	private LoginController loginController;

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
	}

}
