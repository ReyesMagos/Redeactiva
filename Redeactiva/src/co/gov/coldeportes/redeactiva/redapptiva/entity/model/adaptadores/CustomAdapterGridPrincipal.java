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
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Calendar;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.OpcionesGrid;

public class CustomAdapterGridPrincipal extends BaseAdapter {
	Context context;
	List<OpcionesGrid> listaOpciones;

	public CustomAdapterGridPrincipal(Context context,
			List<OpcionesGrid> opciones) {
		this.context = context;
		this.listaOpciones = opciones;
	}

	private class viewHolder {
		ImageView imPrincipal;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		viewHolder holder = null;

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {

			convertView = mInflater.inflate(
					R.layout.custom_grin_principal_option, null);

			holder = new viewHolder();
			holder.imPrincipal = (ImageView) convertView
					.findViewById(R.id.imPrincipal111);

			convertView.setTag(holder);

		} else {
			holder = (viewHolder) convertView.getTag();
		}

		// // String s = (String) getItem(position);
		// OpcionesDashBoard option = (OpcionesDashBoard) getItem(position);
		// holder.txtOpcion.setText(option.getNombreOpcion());
		// holder.imagenOpcioes.setImageBitmap(option.getImagenOpcion());

		// holder.imagen.setText(s);
		OpcionesGrid op = getItem(position);
		holder.imPrincipal.setImageBitmap(op.getImageSource());
		holder.imPrincipal.setContentDescription(op.getOptionName());

		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listaOpciones.size();
	}

	@Override
	public OpcionesGrid getItem(int arg0) {
		// TODO Auto-generated method stub
		return listaOpciones.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return listaOpciones.indexOf(getItem(arg0));
	}
}