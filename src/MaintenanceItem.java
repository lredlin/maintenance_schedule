import java.util.Calendar;
import java.util.Date;

public class MaintenanceItem implements Item{
	
    private Periodicity periodicity;
    private Date issueDate;
    private Date dueDate;
	private Date completedDate;
	private Owner owner;
	private Worker worker;
	private int specialPeriodicity;
    
    // i.e. m-1, d-2, a-1
    private String code;
    
    public enum Periodicity {
    DAILY, WEEKLY, BIWEEKLY, MONTHLY, ANNUAL, SPECIAL
}
    /**
     * Main Method
     */
    public static void main(String[] args) {
    	System.out.println("Hi!");
    	/**
    	 * For Loop: Prints out available periodicities to Console.
    	 */
    	for (Periodicity periodicity : Periodicity.values()) {
    		System.out.println(periodicity);
    	}
    }
    // Maintenance Scheduler[] imports MaintenanceItem and schedules during year
    // If worker is null, MaintenanceItem is unassigned.
    // Index is the next free number for the given periodicity
    public MaintenanceItem(Periodicity periodicity, int index, Date issueDate, Date completedDate, Date dueDate, Owner owner, int specialPeriodicity){
        this.setPeriodicity(periodicity);
        this.setSpecialPeriodicity(specialPeriodicity);
        switch (periodicity){
            case DAILY:
                this.setCode("d-"+index);
            break;
            case WEEKLY:
                this.setCode("w-"+index);
            break;
            case BIWEEKLY:
                this.setCode("b-"+index);
            break;
            case MONTHLY:
                this.setCode("m-"+index);
            break;
            case ANNUAL:
                this.setCode("a-"+index);
            break;
            case SPECIAL:
                this.setCode("s-"+index);
            break;
        }
        this.setIssueDate(issueDate);
        this.setDueDate(dueDate);
        this.setCompletedDate(completedDate);
        this.setOwner(owner);
    }

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    
	public int markComplete() {
		Calendar calDue = Calendar.getInstance();
		calDue.setTime(this.dueDate);
		Calendar calComplete = Calendar.getInstance();
		this.completedDate = calComplete.getTime();
		if (calDue.compareTo(calComplete) < 0) {
			return -1;
		}
		scheduleItem(this.completedDate, this.worker);
		return 1;
		
	}
	@Override
	public void scheduleItem(Date issueDate, Worker worker) {
		this.worker = worker;
		this.issueDate = issueDate;
		Calendar cal = Calendar.getInstance();
		
		switch (this.periodicity) {
			case ANNUAL:
				cal.setTime(issueDate);
				cal.add(Calendar.YEAR, 1); // adds plus one year or 52 weeks
				dueDate = cal.getTime();
				break;
			case BIWEEKLY:
				cal.setTime(issueDate);
				cal.add(Calendar.WEEK_OF_YEAR, 2); // adds plus 2 weeks or 14 days
				dueDate = cal.getTime();
				break;
			case DAILY:
				cal.setTime(issueDate);
				cal.add(Calendar.DAY_OF_WEEK, 1); // adds plus 1 day or 24 hours
				dueDate = cal.getTime();
				break;
			case MONTHLY:
				cal.setTime(issueDate);
				cal.add(Calendar.MONTH, 1); // adds plus 1 month
				dueDate = cal.getTime();
				break;
			case SPECIAL:
				cal.setTime(issueDate);
				cal.add(Calendar.DAY_OF_WEEK, getSpecialPeriodicity()); // adds plus specialPeriodicity set by Owner in # of Days
				dueDate = cal.getTime();
				break;
			case WEEKLY:
				cal.setTime(issueDate);
				cal.add(Calendar.WEEK_OF_YEAR, 1); // adds plus 1 week or 7 days
				dueDate = cal.getTime();
				break;
			
		}
		
		
	}
	
	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	private int getSpecialPeriodicity() {
		return specialPeriodicity;
	}
	private void setSpecialPeriodicity(int specialPeriodicity) {
		this.specialPeriodicity = specialPeriodicity;
	}
	
}