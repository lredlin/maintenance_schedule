import java.util.Date;

public interface Item {
	
	public int markComplete();
	
	public void scheduleItem(Date issueDate, Worker worker);
	

}
