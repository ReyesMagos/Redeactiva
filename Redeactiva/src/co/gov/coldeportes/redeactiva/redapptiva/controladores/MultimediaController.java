package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import co.gov.coldeportes.redeactiva.redapptiva.MultimediaActivity;
import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.MultimediaFactory;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.CustomAdapterMultimedia;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

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
		multimediaActivity.getListaMultimedia().setOnItemClickListener(
				new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						getActivity().startActivity(
								new Intent(Intent.ACTION_VIEW, Uri
										.parse(MultimediaFactory.getInstance()
												.getListaMultimedia().get(arg2)
												.getLink())));
					}
				});
	}

}
