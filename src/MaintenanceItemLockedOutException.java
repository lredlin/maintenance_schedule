
public class MaintenanceItemLockedOutException extends Exception {

	/**
	 * Maintenance Item Locked Out Exception is thrown when the Maintenance Item is
	 * called but is not currently available as it is under modification by the
	 * Owner when a worker or owner is attempting to modify the current work status
	 * of the Maintenance Item.
	 */
	private static final long serialVersionUID = -3465773505878121704L;

}
