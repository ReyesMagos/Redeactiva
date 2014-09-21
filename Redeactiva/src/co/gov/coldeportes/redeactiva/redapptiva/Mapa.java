package co.gov.coldeportes.redeactiva.redapptiva;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.FragmentManager;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Mapa extends Activity {
	GoogleMap mapa;
	ActionBar actionBar;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar = getActionBar();
		setContentView(R.layout.activity_mapa);
		mapa = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		if (mapa != null) {
			Log.i("PERRA", "WE HAD MAP");

			ubicarEscenario(6.455, -75.34234, 10);
		} else {
			Log.i("PERRA", "NO MAPP");
		}

	}

	public void ubicarEscenario(Double Lat, Double Lng, int size) {

		LatLng latlong = new LatLng(Lat, Lng);
		// mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		CameraPosition posicion = new CameraPosition.Builder().target(latlong)
				.zoom(size).bearing(0).build();

		CameraUpdate camUpd = CameraUpdateFactory.newCameraPosition(posicion);
		mapa.animateCamera(camUpd);

		Marker n = mapa.addMarker(new MarkerOptions()
				.position(new LatLng(Lat, Lng))
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_RED))
				.title("").snippet("CULO"));

		// n.setIcon(BitmapDescriptorFactory.defaultMarker())

		n.showInfoWindow();

		// se muestra la venta de info

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mapa, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case R.id.action_settings:

			Uri streetViewUri = Uri
					.parse("google.streetview:cbll=41.187849, -5.371510&cbp=1,90,,0,1.0&mz=20");
			Intent streetViewIntent = new Intent(Intent.ACTION_VIEW,
					streetViewUri);
			startActivity(streetViewIntent);
			return true;

		default:
			return super.onOptionsItemSelected(item);

		}
	}

}
