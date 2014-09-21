package co.gov.coldeportes.redeactiva.redapptiva.controladores;

import co.gov.coldeportes.redeactiva.redapptiva.EventsActivity;
import co.gov.coldeportes.redeactiva.redapptiva.entity.factory.CalendarFactory;
import co.gov.coldeportes.redeactiva.redapptiva.entity.model.adaptadores.CustomAdapterEventCalendar;
import android.app.Activity;

public class EventsController extends AbstractController {

	public EventsController(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	public void showCalendarEvents() {
		EventsActivity e = (EventsActivity) getActivity();
		CustomAdapterEventCalendar customAdapterEventCalendar = new CustomAdapterEventCalendar(
				getActivity(), CalendarFactory.getInstance().getCalendarList());
		e.getListCalendarEvents().setAdapter(customAdapterEventCalendar);

	}

}
