package co.gov.coldeportes.redeactiva.redapptiva.service.dao;

import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Evento;

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
		evento.saveInBackground(new SaveCallback() {

			@Override
			public void done(ParseException arg0) {
				// TODO Auto-generated method stub
				if (arg0 == null)
					Log.i("Evento", "Evento creado Bien");
				else
					Log.i("Evento", arg0.getMessage().toString());

				FacadeController.getInstance()
						.dissmissProgressDialogCreateEvent();

			}
		});
	}
}
