package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import co.gov.coldeportes.redeactiva.redapptiva.CreateEventActivity;
import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.activities.MainActivity;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Usuario;
import android.app.Activity;

public class FacadeController {

	private static FacadeController instance;
	private LoginController loginController;
	private CreateEventController createEventController;
	private Usuario loggedUser;
	private String sportSelected;

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
		if (activity instanceof CreateEventActivity) {
			createEventController = new CreateEventController(activity);
		}
	}

	public void createEvent(String fecha, String numMax, String numMin,
			String lugar, String departamento, String municipio, String hora) {
		createEventController.createEvent(fecha, numMax, numMin, lugar,
				departamento, municipio, hora, "Baloncesto");

	}

	public void dissmissProgressDialogCreateEvent() {
		createEventController.dissmissProgressDialog();
	}

	public void showEventCreateMessage(String s) {
		createEventController.showAlertMessage("Alerta", s);
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
