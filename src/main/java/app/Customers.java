package app;

import java.util.ArrayList;
import java.util.List;
public class Customers extends User {

    private int customersSNN;
    private CalendarAppointment calAppt;
    private boolean multi;
    Address address0;
    List<Customers> onlineCustomers = new ArrayList<>();

    public Customers(int customerSNN, String userName, CalendarAppointment calAppt) {
        super(userName);
        this.setCustomersSNN(customerSNN);
        this.setCalAppt(calAppt);

    }

    public Customers(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);

    }

    public Customers() {
    }

    public CalendarAppointment getCalAppt() {
        return calAppt;
    }

    public void setCalAppt(CalendarAppointment calAppt) {
        this.calAppt = calAppt;
    }

    @Override
    public String toString() {
        return this.getCustomersSNN() + " " + this.getUserName() + " " + calAppt.getApptYear() + " "
                + calAppt.getApptMonth() + " " + calAppt.getApptDay() + " " + calAppt.getStartAppt() + " "
                + calAppt.getEndAppt() + " " + calAppt.isBooked();
    }

    public Address getAddress0() {
        return address0;
    }

    public void setAddress0(Address address0) {
        this.address0 = address0;
    }

    public List<Customers> getonlineCustomers() {
        return onlineCustomers;
    }

    public void setonlineCustomers(List<Customers> onlineCustoomers) {
        onlineCustomers = onlineCustomers;
    }

    public int getCustomersSNN() {
        return customersSNN;
    }

    public void setCustomersSNN(int customerstSNN) {
        this.customersSNN = customersSNN;
    }

    public boolean isMulti() {
        return multi;
    }

    public void setMulti(boolean multi) {
        this.multi = multi;
    }

    public void addonlineCustomers(Customers c) {

        if (c.getPointer()[4])
            c.pointer[5] = true;
    }


}
