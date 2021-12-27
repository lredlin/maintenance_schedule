public class MaintenanceItem {
    private Periodicity periodicity;
    
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
    
    
    // index is the next free number for the given periodicity
    public MaintenanceItem(Periodicity periodicity, int index){
        this.setPeriodicity(periodicity);
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
    
}