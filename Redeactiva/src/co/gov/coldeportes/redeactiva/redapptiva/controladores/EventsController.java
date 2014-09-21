package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import java.util.List;

import co.gov.coldeportes.redeactiva.redapptiva.EventsActivity;
import co.gov.coldeportes.redeactiva.redapptiva.Mapa;
import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.CalendarFactory;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Calendar;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Evento;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.CustomAdapterEventCalendar;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.CustomAdapterEventsUSer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class EventsController extends AbstractController {

	public EventsController(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	public void showCalendarEvents() {
		EventsActivity e = (EventsActivity) getActivity();
		CustomAdapterEventCalendar customAdapterEventCalendar = new CustomAdapterEventCalendar(
				getActivity(), CalendarFactory.getInstance().getCalendarList());
		e.getListCalendarEvents().setAdapter(customAdapterEventCalendar);
		e.getListCalendarEvents().setOnItemClickListener(
				new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						AlertDialog.Builder dialog = new AlertDialog.Builder(
								getActivity());
						LayoutInflater inflater = LayoutInflater
								.from(getActivity());

						View dialogview = inflater.inflate(
								R.layout.evento_dialog_info_custom_alert, null);

						dialog.setView(dialogview);
						dialog.setTitle(getActivity().getResources().getString(
								R.string.alert_label));

						final TextView txtEvento = (TextView) dialogview
								.findViewById(R.id.txtEvento);
						final TextView txtTipo = (TextView) dialogview
								.findViewById(R.id.txtTipo);
						final TextView xtFechaInicio = (TextView) dialogview
								.findViewById(R.id.txtFechaInicio);
						final TextView txtFechaFinal = (TextView) dialogview
								.findViewById(R.id.txtFechaFinal);
						final TextView txtPais = (TextView) dialogview
								.findViewById(R.id.txtPais);
						final TextView txtEntidad = (TextView) dialogview
								.findViewById(R.id.txtEntidad);
						final TextView txtClaseEvento = (TextView) dialogview
								.findViewById(R.id.txtClaseEvento);
						final TextView txtPaginaWeb = (TextView) dialogview
								.findViewById(R.id.txtPaginaWeb);
						final ImageView btnCompartir = (ImageView) dialogview
								.findViewById(R.id.btnCompartir);
						btnCompartir
								.setOnClickListener(new View.OnClickListener() {

									@Override
									public void onClick(View v) {
										// TODO Auto-generated method stub
										Log.i("Compartir", "Compartiendo");
									}
								});

						final ImageView btnContacto = (ImageView) dialogview
								.findViewById(R.id.btnContacto);

						btnContacto
								.setOnClickListener(new View.OnClickListener() {

									@Override
									public void onClick(View v) {
										// TODO Auto-generated method stub

									}
								});
						Calendar c = CalendarFactory.getInstance()
								.getCalendarList().get(arg2);
						txtEvento.setText("Evento: " + c.getEvento());
						txtTipo.setText("Tipo: " + c.getTipo());
						xtFechaInicio.setText("Fecha Inicio: "
								+ c.getFechaInicio());
						txtFechaFinal.setText("Fecha Final: "
								+ c.getFechaFinal());
						txtPais.setText("Pais: " + c.getPais());
						txtEntidad.setText("Entidad: " + c.getEntidad());
						txtClaseEvento.setText("Clase Evento: "
								+ c.getClaseDeEvento());
						txtPaginaWeb.setText("Pagina Web: " + c.getPaginaWeb());
						dialog.setPositiveButton("Aceptar",
								new OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub

									}
								});
						dialog.show();
					}
				});

	}

	public void showUserEventsFinded(final List<Evento> listaEventos) {
		EventsActivity e = (EventsActivity) getActivity();
		CustomAdapterEventsUSer adapterEventsUSer = new CustomAdapterEventsUSer(
				e, listaEventos);
		e.getListUserEvents().setAdapter(adapterEventsUSer);
		e.getListUserEvents().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());

				builder.setTitle("Alerta");

				builder.setMessage(
						"Desea Asistir Al Evento Creado Por El Usuario: "
								+ listaEventos.get(arg2).getCreador()
										.getNombre() + ", El dia : "
								+ listaEventos.get(arg2).getFecha())
						.setPositiveButton("Aceptar",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {

									}
								});
				builder.setNegativeButton("Cancelar",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								changeActivity(Mapa.class);

							}
						});

				AlertDialog dialog = builder.show();
				dialog.show();

			}
		});
	}

}
