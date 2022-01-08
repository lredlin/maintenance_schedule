import java.util.Date;

public abstract class Schedule<T extends Item> {

	public MaintCalendar<T> maintCalendar;

	// TODO
	/*
	 * Calendar can be marked complete Calendar can be emptied Clear day Schedule
	 * Item Reschedule Item throws MaintenanceItemNotFoundException
	 * 
	 */

	public abstract int markComplete(MaintenanceItem.Periodicity periodicity, int index) throws MaintenanceItemNotFoundException;

	public abstract void emptyCalendar();

	public abstract void clearDay(int Day);

	public abstract void scheduleItem(T newItem, Date issueDate, Worker worker);

	public abstract void rescheduleItem(MaintenanceItem.Periodicity periodicity, int index, Date issueDate, Worker worker) throws MaintenanceItemNotFoundException;

}
