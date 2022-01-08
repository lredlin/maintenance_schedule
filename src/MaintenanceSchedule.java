import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MaintenanceSchedule extends Schedule<MaintenanceItem> {

	private MaintCalendar<MaintenanceItem> maintCalendar;

	public MaintenanceSchedule(MaintCalendar<MaintenanceItem> maintCalendar) {

		this.setMaintCalendar(maintCalendar);
	}

	public MaintCalendar<MaintenanceItem> getMaintCalendar() {

		return maintCalendar;
	}

	public void setMaintCalendar(MaintCalendar<MaintenanceItem> maintCalendar) {

		this.maintCalendar = maintCalendar;
	}

	/**
	 * To be used from Front-End to call
	 */
	@Override
	public int markComplete(MaintenanceItem.Periodicity periodicity, int index)
			throws MaintenanceItemNotFoundException {
		MaintenanceItem item = findMaintenanceItem(periodicity, index);
		if (item == null) {
			throw new MaintenanceItemNotFoundException();
		}
		return item.markComplete();

	}

	/**
	 * To be used from Front-End to call
	 */
	public MaintenanceItem createMaintenanceItem(MaintenanceItem.Periodicity periodicity, int index, Date issueDate,
			Date completedDate, Date dueDate, Owner owner, int specialPeriodicity) {

		return new MaintenanceItem(periodicity, index, issueDate, completedDate, dueDate, owner, specialPeriodicity);
	}

	@Override
	public void emptyCalendar() {

		for (int i = 0; i < 365; i++) {
			clearDay(i);
		}

	}

	@Override
	public void clearDay(int Day) {

		maintCalendar.getDays().set(Day, null);

	}

	@Override
	public void scheduleItem(MaintenanceItem newItem, Date issueDate, Worker worker) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(issueDate);
		int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		maintCalendar.getDays().set(dayOfYear, newItem);
		newItem.scheduleItem(issueDate, worker);

	}

	@Override
	public void rescheduleItem(MaintenanceItem.Periodicity periodicity, int index, Date issueDate, Worker worker)
			throws MaintenanceItemNotFoundException {
		MaintenanceItem item = findMaintenanceItem(periodicity, index);
		if (item == null) {
			throw new MaintenanceItemNotFoundException();
		}
		item.setIssueDate(null);
		item.setWorker(null);
		scheduleItem(item, issueDate, worker);

	}

	private MaintenanceItem findMaintenanceItem(MaintenanceItem.Periodicity periodicity, int index) {
		String code = "";
		switch (periodicity) {
		case DAILY:
			code = ("d-" + index);
			break;
		case WEEKLY:
			code = ("w-" + index);
			break;
		case BIWEEKLY:
			code = ("b-" + index);
			break;
		case MONTHLY:
			code = ("m-" + index);
			break;
		case ANNUAL:
			code = ("a-" + index);
			break;
		case SPECIAL:
			code = ("s-" + index);
			break;
		}

		ArrayList<MaintenanceItem> days = this.maintCalendar.getDays();
		for (MaintenanceItem day : days) {
			if (day != null) {
				if (day.getPeriodicity() == periodicity && day.getCode().equals(code)) {
					return day;
				}
			}
		}
		return null;
	}

}
