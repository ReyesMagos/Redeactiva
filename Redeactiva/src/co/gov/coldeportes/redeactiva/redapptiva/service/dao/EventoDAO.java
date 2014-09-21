package co.gov.coldeportes.redeactiva.redapptiva.service.dao;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Evento;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Usuario;

public class EventoDAO extends AbstractDAO {

	public void createEvento(Evento e) {
		ParseObject evento = new ParseObject("Evento");
		evento.put("deporte", e.getDeporte());
		evento.put("fecha", e.getFecha());
		evento.put("maximoNumeroParticipantes",
				e.getMaximoNumeroParticipantes());
		evento.put("minimoNumeroParticipantes",
				e.getMinimoNumeroParticipantes());
		evento.put("direccion", e.getDireccion());
		evento.put("departamento", e.getDepartamento());
		evento.put("municipio", e.getMunicipio());
		evento.put("creador", e.getCreador().getUseR());
		evento.put("horaEncuentro", e.getHoraEncuentro());
		evento.saveInBackground(new SaveCallback() {

			@Override
			public void done(ParseException arg0) {
				// TODO Auto-generated method stub
				if (arg0 == null)
					FacadeController.getInstance().showEventCreateMessage(
							"Evento Creado Correctamente");

				else
					FacadeController.getInstance().showEventCreateMessage(
							"Error al Crear Evento. "
									+ arg0.getMessage().toString());

				FacadeController.getInstance()
						.dissmissProgressDialogCreateEvent();

			}
		});
	}

	public void getEvents(String sport) {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Evento");
		query.whereEqualTo("deporte", sport);
		super.executeAsyncTaskParse(query);
	}

	public void createAndShowEvents(List list) {
		List<Evento> listaEventos = new ArrayList<Evento>();
		for (Object o : list) {
			ParseObject parseObject = (ParseObject) o;
			Evento e = new Evento();
			e.setObjectId(parseObject.getObjectId());
			e.setDeporte(parseObject.getString("deporte"));
			e.setFecha(parseObject.getString("fecha"));
			e.setMaximoNumeroParticipantes(parseObject
					.getInt("maximoNumeroParticipantes"));
			e.setMinimoNumeroParticipantes(parseObject
					.getInt("minimoNumeroParticipantes"));
			e.setDepartamento(parseObject.getString("departamento"));
			e.setMunicipio(parseObject.getString("municipio"));
			e.setDireccion(parseObject.getString("direccion"));
			e.setHoraEncuentro(parseObject.getString("horaEncuentro"));
			try {
				ParseUser user = parseObject.getParseObject("creador").fetch();
				Usuario usuario = new Usuario();
				usuario.setNombre(user.getString("name"));
				usuario.setEmail(user.getEmail());
				usuario.setUsername(user.getUsername());
				usuario.setUserType(user.getInt("userType"));
				usuario.setDepartamento(user.getString("departamento"));
				usuario.setMunicipio(user.getString("municipio"));
				if (usuario.getUserType() == 1) {
					usuario.setDiscapacity(user.getString("discapacity"));
				}
				usuario.setUseR(user);
				e.setCreador(usuario);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listaEventos.add(e);

		}
		FacadeController.getInstance().showUserEvents(listaEventos);
	}
}
