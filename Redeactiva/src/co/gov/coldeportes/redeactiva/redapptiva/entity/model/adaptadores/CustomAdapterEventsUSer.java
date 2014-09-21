package co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.controladores.FacadeController;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Evento;

public class CustomAdapterEventsUSer extends BaseAdapter {
	Context context;
	List<Evento> listaOpciones;
	private int image = 0;

	public CustomAdapterEventsUSer(Context context, List<Evento> opciones) {
		this.context = context;
		this.listaOpciones = opciones;
	}

	private class viewHolder {
		ImageView imageEvent;
		TextView txtCreadorNAme;
		TextView txtFechaEvento;
		TextView txtDeporteEvento;
		TextView txtUbicacionEvento;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		viewHolder holder = null;

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {

			convertView = mInflater
					.inflate(R.layout.events_dialog_custom, null);

			holder = new viewHolder();
			holder.imageEvent = (ImageView) convertView
					.findViewById(R.id.imagenEvento1);
			convertView.setTag(holder);
			holder.txtCreadorNAme = (TextView) convertView
					.findViewById(R.id.txtCreadorName);
			holder.txtFechaEvento = (TextView) convertView
					.findViewById(R.id.txtFechaEvento1);
			holder.txtDeporteEvento = (TextView) convertView
					.findViewById(R.id.txtDeporteEvento);
			holder.txtUbicacionEvento = (TextView) convertView
					.findViewById(R.id.txtUbicacionEvento);

			convertView.setTag(holder);

		} else {
			holder = (viewHolder) convertView.getTag();
		}

		// // String s = (String) getItem(position);
		// OpcionesDashBoard option = (OpcionesDashBoard) getItem(position);
		// holder.txtOpcion.setText(option.getNombreOpcion());
		// holder.imagenOpcioes.setImageBitmap(option.getImagenOpcion());

		// holder.imagen.setText(s);
		Evento e = getItem(position);
		if (image == 0) {
			if (FacadeController.getInstance().getSportSelected()
					.equals("Atletismo")) {
				holder.imageEvent.setImageDrawable(context.getResources()
						.getDrawable(R.drawable.atletisc));
			} else if (FacadeController.getInstance().getSportSelected()
					.equals("Baloncesto")) {
				holder.imageEvent.setImageDrawable(context.getResources()
						.getDrawable(R.drawable.balon));
			} else if (FacadeController.getInstance().getSportSelected()
					.equals("Ciclismo")) {
				holder.imageEvent.setImageDrawable(context.getResources()
						.getDrawable(R.drawable.cicli));

			}
			image++;
		} else if (image == 1) {
			if (FacadeController.getInstance().getSportSelected()
					.equals("Atletismo")) {
				holder.imageEvent.setImageDrawable(context.getResources()
						.getDrawable(R.drawable.atletics1));
			} else if (FacadeController.getInstance().getSportSelected()
					.equals("Baloncesto")) {
				holder.imageEvent.setImageDrawable(context.getResources()
						.getDrawable(R.drawable.balon1));

			} else if (FacadeController.getInstance().getSportSelected()
					.equals("Ciclismo")) {
				holder.imageEvent.setImageDrawable(context.getResources()
						.getDrawable(R.drawable.cicli2));

			}
			image++;
		} else if (image == 2) {

			if (FacadeController.getInstance().getSportSelected()
					.equals("Atletismo")) {
				holder.imageEvent.setImageDrawable(context.getResources()
						.getDrawable(R.drawable.atletics2));
			} else if (FacadeController.getInstance().getSportSelected()
					.equals("Baloncesto")) {
				holder.imageEvent.setImageDrawable(context.getResources()
						.getDrawable(R.drawable.balon2));
			} else if (FacadeController.getInstance().getSportSelected()
					.equals("Ciclismo")) {
				holder.imageEvent.setImageDrawable(context.getResources()
						.getDrawable(R.drawable.cicli2));

			}

			image++;
		} else if (image == 3) {
			if (FacadeController.getInstance().getSportSelected()
					.equals("Atletismo")) {
				holder.imageEvent.setImageDrawable(context.getResources()
						.getDrawable(R.drawable.atletics3));
			} else if (FacadeController.getInstance().getSportSelected()
					.equals("Baloncesto")) {
				holder.imageEvent.setImageDrawable(context.getResources()
						.getDrawable(R.drawable.balon3));
			} else if (FacadeController.getInstance().getSportSelected()
					.equals("Ciclismo")) {
				holder.imageEvent.setImageDrawable(context.getResources()
						.getDrawable(R.drawable.cicli));

			}
			image = 0;
		}
		holder.txtCreadorNAme.setText(e.getCreador().getUsername());
		holder.txtDeporteEvento.setText(e.getDeporte());
		holder.txtFechaEvento.setText(e.getFecha() + "Hora: "
				+ e.getHoraEncuentro());
		holder.txtUbicacionEvento.setText(e.getDepartamento() + "-"
				+ e.getDireccion());

		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listaOpciones.size();
	}

	@Override
	public Evento getItem(int arg0) {
		// TODO Auto-generated method stub
		return listaOpciones.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return listaOpciones.indexOf(getItem(arg0));
	}
}
