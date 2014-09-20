package co.gov.coldeportes.redeactiva.redapptiva;

import co.gov.coldeportes.redeactiva.redapptiva.service.dao.CalendarDAO;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class EventsActivity extends ActionBarActivity {

	private ListView listCalendarEvents;
	private ListView listUserEvents;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		CalendarDAO calendarDAO = new CalendarDAO();
		calendarDAO.executeAsyncTaskDAO();
		init();
	}

	public void  init() {
		listCalendarEvents = (ListView) findViewById(R.id.listCalendarEvents);
		listUserEvents = (ListView) findViewById(R.id.listUserEvents);
	}
	
	

	public ListView getListCalendarEvents() {
		return listCalendarEvents;
	}

	public void setListCalendarEvents(ListView listCalendarEvents) {
		this.listCalendarEvents = listCalendarEvents;
	}

	public ListView getListUserEvents() {
		return listUserEvents;
	}

	public void setListUserEvents(ListView listUserEvents) {
		this.listUserEvents = listUserEvents;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.events, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
