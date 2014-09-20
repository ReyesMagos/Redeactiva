package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Evento;
import co.gov.coldeportes.redeactiva.redapptiva.service.dao.EventoDAO;
import android.app.Activity;

public class CreateEventController extends AbstractController {

	public CreateEventController(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	public void createEvent(String fecha, String numMax, String numMin,
			String lugar, String departamento, String municipio, String deporte) {
		super.showProgressDialog(
				getActivity().getResources().getString(R.string.alert_label),
				"Creando Evento Espere Por Favor");
		Evento e = new Evento();
		e.setDeporte(deporte);
		e.setFecha(fecha);
		e.setMaximoNumeroParticipantes(Integer.parseInt(numMax));
		e.setMinimoNumeroParticipantes(Integer.parseInt(numMin));
		e.setDireccion(lugar);
		e.setMunicipio(municipio);
		e.setDepartamento(departamento);
		e.setCreador(FacadeController.getInstance().getLoggedUser());
		EventoDAO eventoDAO = new EventoDAO();
		eventoDAO.createEvento(e);

	}

}
