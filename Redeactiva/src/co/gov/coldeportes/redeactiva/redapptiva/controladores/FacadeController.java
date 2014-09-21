package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import java.util.List;

import co.gov.coldeportes.redeactiva.redapptiva.CreateEventActivity;
import co.gov.coldeportes.redeactiva.redapptiva.EventsActivity;
import co.gov.coldeportes.redeactiva.redapptiva.MultimediaActivity;
import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.activities.MainActivity;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Evento;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Usuario;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.CalendarDAO;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.EventoDAO;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.MultimediaDAO;
import android.app.Activity;

public class FacadeController {

	private static FacadeController instance;
	private LoginController loginController;
	private CreateEventController createEventController;
	private EventsController eventsController;
	private Usuario loggedUser;
	private String sportSelected;
	private String activitySelectedFromGrid;
	private MultimediaController multimediaController;
	private String notice;

	private FacadeController() {

	}
	
	

	public LoginController getLoginController() {
		return loginController;
	}



	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}



	public CreateEventController getCreateEventController() {
		return createEventController;
	}



	public void setCreateEventController(CreateEventController createEventController) {
		this.createEventController = createEventController;
	}



	public EventsController getEventsController() {
		return eventsController;
	}



	public void setEventsController(EventsController eventsController) {
		this.eventsController = eventsController;
	}



	public MultimediaController getMultimediaController() {
		return multimediaController;
	}



	public void setMultimediaController(MultimediaController multimediaController) {
		this.multimediaController = multimediaController;
	}



	public String getNotice() {
		return notice;
	}



	public void setNotice(String notice) {
		this.notice = notice;
	}



	public String getActivitySelectedFromGrid() {
		return activitySelectedFromGrid;
	}

	public String getSportSelected() {
		return sportSelected;
	}

	public void setSportSelected(String sportSelected) {
		this.sportSelected = sportSelected;
	}

	public void setActivitySelectedFromGrid(String activitySelectedFromGrid) {
		this.activitySelectedFromGrid = activitySelectedFromGrid;
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
		if (activity instanceof EventsActivity) {
			eventsController = new EventsController(activity);
			CalendarDAO calendarDAO = new CalendarDAO();
			calendarDAO.executeAsyncTaskDAO();
			EventoDAO eventoDAO = new EventoDAO();
			eventoDAO.getEvents(sportSelected);
			eventsController.showProgressDialog("Alerta",
					"Consultando Eventos Deportivos Espere Por Favor");
		}
		if (activity instanceof MultimediaActivity) {
			multimediaController = new MultimediaController(activity);
			MultimediaDAO multimediaDAO = new MultimediaDAO();
			multimediaDAO.executeAsyncTaskDAO();
			multimediaController
					.showProgressDialog("Alerta",
							"Obteniendo Informacion Multimedia de Deportes , espero por favor");

		}
	}

	public void dissmissDialogMultimedia() {
		multimediaController.dissmissProgressDialog();
	}

	public void showMultimediaThings() {
		multimediaController.showMultimediaThings();
	}

	public void dissmissEVentsActivityProgress() {
		eventsController.dissmissProgressDialog();
	}

	public void showCalendarEvents() {
		eventsController.showCalendarEvents();
	}

	public void showUserEvents(List<Evento> listaEventos) {
		eventsController.showUserEventsFinded(listaEventos);
	}

	public void createEvent(String fecha, String numMax, String numMin,
			String lugar, String departamento, String municipio, String hora) {
		createEventController.createEvent(fecha, numMax, numMin, lugar,
				departamento, municipio, hora, sportSelected);

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
