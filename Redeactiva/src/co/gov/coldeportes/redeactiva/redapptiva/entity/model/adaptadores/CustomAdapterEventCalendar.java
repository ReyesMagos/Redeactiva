package co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Calendar;

public class CustomAdapterEventCalendar extends BaseAdapter {
	Context context;
	List<Calendar> listaOpciones;
	private int image = 0;

	public CustomAdapterEventCalendar(Context context, List<Calendar> opciones) {
		this.context = context;
		this.listaOpciones = opciones;
	}

	private class viewHolder {
		ImageView imageEvent;
		TextView txtEvento;
		TextView txtFechaInicio;
		TextView txtTipoEvento;
		TextView txtNivelEvento;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		viewHolder holder = null;

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {

			convertView = mInflater.inflate(R.layout.calendar_event_layout,
					null);

			holder = new viewHolder();
			holder.imageEvent = (ImageView) convertView
					.findViewById(R.id.imagenevento);
			convertView.setTag(holder);
			holder.txtEvento = (TextView) convertView
					.findViewById(R.id.txttituloevento);
			holder.txtFechaInicio = (TextView) convertView
					.findViewById(R.id.txtfechainicio);
			holder.txtNivelEvento = (TextView) convertView
					.findViewById(R.id.txtnivelevento);
			holder.txtTipoEvento = (TextView) convertView
					.findViewById(R.id.txttipoevento);
			convertView.setTag(holder);

		} else {
			holder = (viewHolder) convertView.getTag();
		}
		if (image == 0) {
			holder.imageEvent.setImageDrawable(context.getResources()
					.getDrawable(R.drawable.atletics3));
			image++;
		} else if (image == 1) {
			holder.imageEvent.setImageDrawable(context.getResources()
					.getDrawable(R.drawable.arco));
			image++;
		} else if (image == 2) {
			holder.imageEvent.setImageDrawable(context.getResources()
					.getDrawable(R.drawable.balon2));
			image++;
		} else if (image == 3) {
			holder.imageEvent.setImageDrawable(context.getResources()
					.getDrawable(R.drawable.cicli2));
			image++;
		} else if (image == 4) {
			holder.imageEvent.setImageDrawable(context.getResources()
					.getDrawable(R.drawable.meda));
			image++;
		} else if (image == 5) {
			holder.imageEvent.setImageDrawable(context.getResources()
					.getDrawable(R.drawable.otra));
			image++;
		} else if (image == 6) {
			holder.imageEvent.setImageDrawable(context.getResources()
					.getDrawable(R.drawable.fama));
			image++;
		} else if (image == 7) {
			holder.imageEvent.setImageDrawable(context.getResources()
					.getDrawable(R.drawable.forza));
			image++;
		} else if (image == 8) {
			holder.imageEvent.setImageDrawable(context.getResources()
					.getDrawable(R.drawable.hh));
			image = 0;
		}

		// // String s = (String) getItem(position);
		// OpcionesDashBoard option = (OpcionesDashBoard) getItem(position);
		// holder.txtOpcion.setText(option.getNombreOpcion());
		// holder.imagenOpcioes.setImageBitmap(option.getImagenOpcion());

		// holder.imagen.setText(s);
		Calendar c = getItem(position);
		holder.txtEvento.setText(c.getEvento());
		holder.txtFechaInicio.setText(c.getFechaInicio());
		holder.txtTipoEvento.setText(c.getTipo());
		holder.txtNivelEvento.setText(c.getNivel() + "/" + c.getPais() + "/"
				+ c.getTerritorio());

		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listaOpciones.size();
	}

	@Override
	public Calendar getItem(int arg0) {
		// TODO Auto-generated method stub
		return listaOpciones.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return listaOpciones.indexOf(getItem(arg0));
	}
}
