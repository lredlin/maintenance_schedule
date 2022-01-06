import java.util.ArrayList;

public class MaintCalendar<T extends Item> {
	
	private ArrayList<T> days = new ArrayList<T>(365); //0-364

	public ArrayList<T> getDays() {
		return days;
	}

	public void setDays(ArrayList<T> days) {
		this.days = days;
	}
	
}
