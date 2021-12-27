public class MaintenanceItem {
    private Periodicity periodicity;
    
    // i.e. m-1, d-2, a-1
    private String code;
    
    public enum Periodicity {
    DAILY, WEEKLY, BIWEEKLY, MONTHLY, ANNUAL, SPECIAL
}

    // index is the next free number for the given periodicity
    public MaintenanceItem(Periodicity periodicity, int index){
        this.periodicity = periodicity;
        switch (periodicity){
            case DAILY:
                this.code = "d-"+index;
            break;
            case WEEKLY:
                this.code = "w-"+index;
            break;
            case BIWEEKLY:
                this.code = "b-"+index;
            break;
            case MONTHLY:
                this.code = "m-"+index;
            break;
            case ANNUAL:
                this.code = "a-"+index;
            break;
            case SPECIAL:
                this.code = "s-"+index;
            break;
        }
    }
    
}