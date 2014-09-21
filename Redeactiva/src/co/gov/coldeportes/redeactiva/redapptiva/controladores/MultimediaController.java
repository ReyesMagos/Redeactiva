package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import co.gov.coldeportes.redeactiva.redapptiva.MultimediaActivity;
import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.MultimediaFactory;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.CustomAdapterMultimedia;
import android.app.Activity;

public class MultimediaController extends AbstractController {

	public MultimediaController(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	public void showMultimediaThings() {
		MultimediaActivity multimediaActivity = (MultimediaActivity) getActivity();
		CustomAdapterMultimedia customAdapterMultimedia = new CustomAdapterMultimedia(
				getActivity(), MultimediaFactory.getInstance()
						.getListaMultimedia());

		multimediaActivity.getListaMultimedia().setAdapter(
				customAdapterMultimedia);
	}

}
