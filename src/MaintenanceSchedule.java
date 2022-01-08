import java.util.Date;

public class MaintenanceSchedule {	

	private MaintCalendar<MaintenanceItem> maintCalendar;
	
	public MaintenanceSchedule (MaintCalendar<MaintenanceItem> maintCalendar) {
		this.setMaintCalendar(maintCalendar);
	}

	public MaintCalendar<MaintenanceItem> getMaintCalendar() {
		return maintCalendar;
	}

	public void setMaintCalendar(MaintCalendar<MaintenanceItem> maintCalendar) {
		this.maintCalendar = maintCalendar;
	}

	public void markCalComplete(MaintenanceItem maintenanceItem) {
		
	}
	/**
	 * To be used from Front-End to call
	 */
	public void setMaintenanceItemToCalendar(MaintenanceItem.Periodicity periodicity, int index, Date issueDate, Date completedDate, Date dueDate, Owner owner, int specialPeriodicity){
		MaintenanceItem mItem = new MaintenanceItem(periodicity, index, issueDate, completedDate, dueDate, owner, specialPeriodicity);
	} 	
	
	public void emptyCalendar() {
		
	}
	
	public void clearDay() {
		
	}
	
	public void clearWeek() {
		
	}
	
	public void clearMonth() {
		
	}
	
	public void rescheduleItem() {
		
	}
}

