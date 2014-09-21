package co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores;

import java.util.List;

import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.Projects;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProjectCustomAdapter extends BaseAdapter {

	private Context context;
	private List<Projects> projectList;

	public ProjectCustomAdapter(Context context, List<Projects> projects) {
		this.context = context;
		this.projectList = projects;
	}

	private class ViewHolder {
		ImageView imageTipoProyecto;
		TextView tipoProyecto;
		TextView txtNombreProyecto;
		TextView txtTipoEntidad;
		TextView txtDepartamento;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.custom_project_listview,
					null);
			
			holder = new ViewHolder();
			holder.imageTipoProyecto = (ImageView)convertView.findViewById(R.id.imagenProyecto);
			holder.tipoProyecto = (TextView)convertView.findViewById(R.id.txttipoproyecto);
			holder.txtNombreProyecto = (TextView)convertView.findViewById(R.id.txtnombreProyecto);
			holder.txtTipoEntidad = (TextView)convertView.findViewById(R.id.txttipoentidad);
			holder.txtDepartamento = (TextView)convertView.findViewById(R.id.txtDepartamento);
			
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
			
		}
		Projects projects = (Projects) getItem(position);
		holder.tipoProyecto.setText(projects.getTipo());
		holder.txtNombreProyecto.setText(projects.getNombrePrograma());
		holder.txtTipoEntidad.setText(projects.getTipoEntidad());
		String dpto;
		switch (Integer.parseInt(projects.getCodigoDepartamento())) {
		case 86:
			dpto = "Putumayo";
			break;
		case 85:
			dpto = "Casanare";
			break;
		case 47:
			dpto = "Magdalena";
			break;
		case 25:
			dpto = "Cundinamarca";
			break;
		case 91:
			dpto= "Amazonas";
			break;
		case 05:
			dpto = "Antioquia";
			break;
		case 81:
			dpto = "Arauca";
			break;
		case 8:
			dpto = "Atlantico";
			break;
		case 11:
			dpto = "Bogota D.C";
			break;
		default:
			dpto = "Norte de Santander";
			break;
		}
		holder.txtDepartamento.setText(dpto);
		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return projectList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return projectList.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return projectList.indexOf(getItem(position));
	}

}
