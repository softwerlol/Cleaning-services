package app;

public class CalendarAppointment {
    private String apptYear;
    private String apptMonth;
    private String apptDay;
    private String startAppt;
    private String endAppt;
    private boolean booked;
    private boolean added;
    private boolean searched;
    private boolean deleted;



    public CalendarAppointment() {

    }

    public CalendarAppointment(String apptYear, String apptMonth, String apptDay, String startAppt, String endAppt,
                               boolean booked) {
        this.setApptYear(apptYear);
        this.setApptMonth(apptMonth);
        this.setApptDay(apptDay);
        this.setStartAppt(startAppt);
        this.setEndAppt(endAppt);
        this.setBooked(booked);
        this.setAdded(false);
        this.setSearched(false);
        this.setDeleted(false);

    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String getEndAppt() {
        return endAppt;
    }

    public void setEndAppt(String endAppt) {
        this.endAppt = endAppt;
    }

    public String getStartAppt() {
        return startAppt;
    }

    public void setStartAppt(String startAppt) {
        this.startAppt = startAppt;
    }

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }

    public String getApptYear() {
        return apptYear;
    }

    public void setApptYear(String apptYear) {
        this.apptYear = apptYear;
    }

    public String getApptDay() {
        return apptDay;
    }

    public void setApptDay(String apptDay) {
        this.apptDay = apptDay;
    }

    public String getApptMonth() {
        return apptMonth;
    }

    public void setApptMonth(String apptMonth) {
        this.apptMonth = apptMonth;
    }

    public boolean isSearched() {
        return searched;
    }

    public void setSearched(boolean searched) {
        this.searched = searched;
    }

    @Override
    public String toString() {
        return this.getApptYear() + " " + this.getApptMonth() + " " + this.getApptDay() + " " + this.getStartAppt()
                + " " + this.getEndAppt() + " " + this.isBooked();
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


}
