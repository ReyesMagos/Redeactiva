package co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores;

import java.util.List;

import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.MySport;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MySportCustomAdapter extends BaseAdapter {

	private Context context;
	private List<MySport> mySportList;

	public MySportCustomAdapter(Context context, List<MySport> sportsList) {
		this.context = context;
		this.mySportList = sportsList;
	}

	private class ViewHolder {
		ImageView imageTipoProyecto;
		TextView tipo;
		TextView txtClasificacionFuncional;
		TextView txtDescripcion;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mySportList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mySportList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return mySportList.indexOf(getItem(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder = null;
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.custom_mysport_listview,
					null);
			
			holder = new ViewHolder();
			holder.imageTipoProyecto = (ImageView)convertView.findViewById(R.id.imagenProyecto);
			holder.tipo = (TextView)convertView.findViewById(R.id.txttipo);
			holder.txtClasificacionFuncional = (TextView)convertView.findViewById(R.id.txtclasificacionfunc);
			holder.txtDescripcion = (TextView)convertView.findViewById(R.id.textView_descr);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}
		
		MySport mySport = (MySport)getItem(position);
		holder.tipo.setText(mySport.getTipo());
		String cal = calificacionRecortada(mySport.getClasificacionFuncional());
		holder.txtClasificacionFuncional.setText(cal);
		String descr = calificacionRecortada(mySport.getDescripcionDiscapacidad());
		holder.txtDescripcion.setText(descr);
		
		return convertView;
	}

	public String calificacionRecortada(String large) {
		//String aux;
		try {
			String aux = large.substring(0, 40) + "...";
			return aux;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}

}
