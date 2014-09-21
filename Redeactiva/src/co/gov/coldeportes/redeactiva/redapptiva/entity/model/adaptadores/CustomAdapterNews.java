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
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Multimedia;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Noticia;

public class CustomAdapterNews extends BaseAdapter {
	Context context;
	List<Noticia> listaOpciones;

	public CustomAdapterNews(Context context, List<Noticia> opciones) {
		this.context = context;
		this.listaOpciones = opciones;
	}

	private class viewHolder {

		TextView txtTitulo;
		TextView txtDescripcion;
		ImageView imagen;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		viewHolder holder = null;

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {

			convertView = mInflater.inflate(R.layout.cutom_new, null);

			holder = new viewHolder();
			holder.imagen = (ImageView) convertView.findViewById(R.id.imageView1);
			holder.txtTitulo = (TextView) convertView
					.findViewById(R.id.txtTitulo);
			holder.txtDescripcion = (TextView) convertView
					.findViewById(R.id.txtContenido);

			convertView.setTag(holder);

		} else {
			holder = (viewHolder) convertView.getTag();
		}

		// // String s = (String) getItem(position);
		// OpcionesDashBoard option = (OpcionesDashBoard) getItem(position);
		// holder.txtOpcion.setText(option.getNombreOpcion());
		// holder.imagenOpcioes.setImageBitmap(option.getImagenOpcion());

		// holder.imagen.setText(s);
		Noticia n = getItem(position);
		holder.txtTitulo.setText(n.getTitulo());
		holder.txtDescripcion.setText(n.getContenido());
		holder.imagen.setImageDrawable(context.getResources().getDrawable(
				R.drawable.n1));

		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listaOpciones.size();
	}

	@Override
	public Noticia getItem(int arg0) {
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
