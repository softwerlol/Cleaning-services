package app;

public class Invoice {

    private Customers customers = new Customers();
    private Worker worker = new Worker();
    private CalendarAppointment calender = new CalendarAppointment();
    private int invoiceNumber;
    private String serviceDescription;
    private String serviceFee;

    public Invoice(int invoiceNumber, String customersName, String WorkerName, String serviceDescription,
                   String serviceFee) {
        this.invoiceNumber = invoiceNumber;
        customers.setUserName(customersName);
        worker.setUserName(WorkerName);
        this.serviceDescription = serviceDescription;
        this.serviceFee = serviceFee;
    }

    public Invoice(int invoiceNumber, String customersName, String WorkerName, String serviceDescription,
                   String serviceFee, boolean booked) {


        calender.setBooked(booked);
        customers.setUserName(customersName);
        worker.setUserName(WorkerName);
        this.serviceDescription = serviceDescription;
        this.serviceFee = serviceFee;
        this.invoiceNumber = invoiceNumber;
    }

//	public CalendarAppointment getCalender() {
//		return calender;
//	}
//
//	public void setCalender(CalendarAppointment calender) {
//		this.calender = calender;
//	}

    public Customers getcustomers() {
        return customers;
    }



    public int getInvoiceNumber() {
        return invoiceNumber;
    }


    public void timesetting(String startAppt, String endAppt) {
        calender.setStartAppt(startAppt);
        calender.setEndAppt(endAppt);
    }
    public void datesetting(String apptYear, String apptMonth, String apptDay) {
        calender.setApptYear(apptYear);
        calender.setApptMonth(apptMonth);
        calender.setApptDay(apptDay);
    }
    @Override
    public String toString() {
        return "Invoice [invoiceNumber = " + invoiceNumber + ", customersName = " + customers.getUserName() + ", workerName = "
                + worker.getUserName() + ", serviceDescription = " + serviceDescription + ", serviceFee = " + serviceFee
                + "]";
    }

    public String printReport() {
        return "Invoice [invoiceNumber = " + invoiceNumber + ", customerName = " + customers.getUserName() + ", workerName = "
                + worker.getUserName() + ", Date : " + calender.getApptYear() + "/" + calender.getApptMonth() + "/"
                + calender.getApptDay() + " " + calender.getStartAppt() + " " + calender.getEndAppt()
                + ", serviceDescription : " + serviceDescription + ", serviceFee : " + serviceFee + "]\n";

    }
}
