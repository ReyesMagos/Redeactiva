package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import co.gov.coldeportes.redeactiva.redapptiva.R;
import co.gov.coldeportes.redeactiva.redapptiva.activities.MySportsActivity;
import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.MySportFactory;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.MySport;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.MySportCustomAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MySportController extends AbstractController {

	private MySport mySportAux;

	public MySportController(Activity activity) {
		super(activity);
	}

	public void fillListView() {
		MySportsActivity p = (MySportsActivity) getActivity();
		MySportCustomAdapter mySportCustomAdapter = new MySportCustomAdapter(
				getActivity(), MySportFactory.getInstance().filterSports());
		p.getListViewMySport().setAdapter(mySportCustomAdapter);
		p.getListViewMySport().setOnItemClickListener(
				new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> adapter, View view,
							int pos, long arg3) {
						AlertDialog.Builder builder = new AlertDialog.Builder(
								getActivity());
						LayoutInflater inflater = LayoutInflater
								.from(getActivity());
						View dialogView = inflater.inflate(
								R.layout.show_sports_custom_adapter, null);
						builder.setView(dialogView);
						builder.setTitle("Informacion Deporte");

						final TextView textViewDeporte = (TextView) dialogView
								.findViewById(R.id.text_view_sports_deporte);
						final TextView textViewTipo = (TextView) dialogView
								.findViewById(R.id.textView_sports_tipo);
						final TextView textViewDescrDeporte = (TextView) dialogView
								.findViewById(R.id.textView_descripcion_deporte);
						final TextView textViewClasificacionFunc = (TextView) dialogView
								.findViewById(R.id.textViewclasificacionFunc);
						final TextView textViewPagWeb = (TextView) dialogView
								.findViewById(R.id.textView_sitio_web);
						final TextView textViewDescrDisc = (TextView) dialogView
								.findViewById(R.id.textView_descr_disc);
						mySportAux = MySportFactory.getInstance()
								.filterSports().get(pos);

						textViewDeporte.setText(FacadeController.getInstance().getSportSelected());
						textViewTipo.setText(mySportAux.getTipo());
						textViewDescrDeporte.setText(mySportAux
								.getDescripcionDeporte());
						textViewClasificacionFunc.setText(mySportAux
								.getClasificacionFuncional());
						textViewPagWeb.setText(mySportAux.getSitioWeb());
						textViewDescrDisc.setText(mySportAux
								.getDescripcionDiscapacidad());
						builder.setPositiveButton("Aceptar",
								new OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub

									}
								});
						builder.show();
					}
				});

	}

}
