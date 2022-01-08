
public class MaintenanceItemNotFoundException extends Exception {

	/**
	 * Maintenance Item Not Found Exception is thrown when the Maintenance Item is
	 * called but does not currently exist where it is suppose to be, has already
	 * been marked complete, has already been removed from the maintenance schedule.
	 */
	private static final long serialVersionUID = 8214813310112396704L;

}
