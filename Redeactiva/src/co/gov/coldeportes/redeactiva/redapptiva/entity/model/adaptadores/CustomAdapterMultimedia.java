package co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores;

import java.util.List;

import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Evento;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Multimedia;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterMultimedia extends BaseAdapter {
	Context context;
	List<Multimedia> listaOpciones;

	public CustomAdapterMultimedia(Context context, List<Multimedia> opciones) {
		this.context = context;
		this.listaOpciones = opciones;
	}

	private class viewHolder {

		TextView txtNombre;
		TextView txtDescripcion;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		viewHolder holder = null;

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {

			convertView = mInflater
					.inflate(R.layout.multimedia_custom_layout, null);

			holder = new viewHolder();
			holder.txtNombre = (TextView) convertView
					.findViewById(R.id.txtNombre);
			holder.txtDescripcion = (TextView) convertView
					.findViewById(R.id.txtDescripcion);

			convertView.setTag(holder);

		} else {
			holder = (viewHolder) convertView.getTag();
		}

		// // String s = (String) getItem(position);
		// OpcionesDashBoard option = (OpcionesDashBoard) getItem(position);
		// holder.txtOpcion.setText(option.getNombreOpcion());
		// holder.imagenOpcioes.setImageBitmap(option.getImagenOpcion());

		// holder.imagen.setText(s);
		Multimedia m = getItem(position);
		holder.txtNombre.setText(m.getNombre());
		holder.txtDescripcion.setText(m.getDescripcion());

		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listaOpciones.size();
	}



	@Override
	public Multimedia getItem(int arg0) {
		// TODO Auto-generated method stub
		return listaOpciones.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return listaOpciones.indexOf(getItem(arg0));
	}
}
// TODO A
