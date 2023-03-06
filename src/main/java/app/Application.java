package app;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Application {

    private List<User> users;
    private List<CalendarAppointment> calApp;
    private List<Customers> customers;
    private List<Worker> worker;
    private List<Services> services;
    private List<Invoice> invoice;

    private static final Logger logger = Logger.getLogger(Application.class.getName());

    String failed = "failed";
    String before = "Before:";
    String after = "After:";
    String newVariable = before.replaceAll(before, "newVariable");
    String newVariable1 = after.replaceAll(before, "newVariable1");
    String newVariable2 = failed.replaceAll(before, "newVariable2");

    public Application() {

        this.users = new ArrayList<>();
        this.calApp = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.worker = new ArrayList<>();
        this.services = new ArrayList<>();
        this.invoice = new ArrayList<>();

    }

    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    public List<Customers> getCustomers() {
        return this.customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }

    public List<Worker> getWorker() {
        return worker;
    }

    public void setWorker(List<Worker> worker) {
        this.worker = worker;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public List<CalendarAppointment> getCalendarApp() {
        return this.calApp;
    }

    public void searchAppt(CalendarAppointment calAppt) {
        String format = calAppt.toString();
        boolean conatinAppt = false;

        for (int i = 0; i < getCalendarApp().size(); i++) {
            if (getCalendarApp().get(i).toString().equals(format)) {
                conatinAppt = true;
                logger.info("yes");

            }

        }

        calAppt.setSearched(conatinAppt ? true : false);
    }

    public void addAppts(CalendarAppointment calAppt) {

        logger.info(before);
        for (int i = 0; i < getCalendarApp().size(); i++) {
            if (getCalendarApp().get(i) != null)
                logger.info(getCalendarApp().get(i).toString());

        }

        searchAppt(calAppt);
        if (calAppt.isSearched()) {
            calAppt.setAdded(false);

        } else {

            calAppt.setAdded(true);
            int in = compareAppt(calAppt);
            getCalendarApp().add(in, calAppt);
            logger.info(after);
            for (int i = 0; i < getCalendarApp().size(); i++) {
                if (getCalendarApp().get(i) != null)
                    logger.info(getCalendarApp().get(i).toString());
            }
        }

    }

    private int compareAppt(CalendarAppointment calAppt) {

        int delIndex = 0;
        String[] h1 = calAppt.getStartAppt().split(":");
        String[] h2 = calAppt.getEndAppt().split(":");
        int[] times = new int[4];
        int timesAddtion = 0;
        int parTimesAddtion = 0;

        for (int i = 0; i < (h1.length + h2.length); i++) {
            if (i < 2) {
                times[i] = Integer.parseInt(h1[i]);

            }

            else {
                times[i] = Integer.parseInt(h2[i - 2]);

            }

        }
        timesAddtion = times[0] + times[1] + times[2] + times[3];

        for (int i = 0; i < getCalendarApp().size(); i++) {

            String[] parStart = getCalendarApp().get(i).getStartAppt().split(":");
            String[] parEnd = getCalendarApp().get(i).getEndAppt().split(":");
            int[] parTimes = new int[4];

            for (int j = 0; j < (parStart.length + parEnd.length); j++) {
                if (j < 2) {
                    parTimes[j] = Integer.parseInt(parStart[j]);

                }

                else {
                    parTimes[j] = Integer.parseInt(parEnd[j - 2]);

                }

            }
            parTimesAddtion = parTimes[0] + parTimes[1] + parTimes[2] + parTimes[3];

            if (timesAddtion < parTimesAddtion) {

                delIndex = i;

                break;
            }

        }

        return delIndex;
    }

    public void deleteAppts(CalendarAppointment calAppt) {

        logger.info("Delete Here");
        logger.info(before);
        for (int i = 0; i < getCalendarApp().size(); i++) {
            if (getCalendarApp().get(i) != null)
                logger.info(getCalendarApp().get(i).toString());
        }

        searchAppt(calAppt);

        if (calAppt.isSearched()) {
            calAppt.setDeleted(true);
            logger.info(after);
            for (int i = 0; i < getCalendarApp().size(); i++) {
                if (getCalendarApp().get(i).toString().equals(calAppt.toString()))
                    getCalendarApp().remove(i);
                if (getCalendarApp().get(i) != null)
                    logger.info(getCalendarApp().get(i).toString());
            }
        } else
            calAppt.setDeleted(false);

    }

    public int bookApptSearch(Customers customers) {
        int delIndex = 0;
        String time1 = customers.getCalAppt().getStartAppt();
        String time2 = customers.getCalAppt().getEndAppt();
        for (int i = 0; i < getCustomers().size(); i++) {
            if (getCustomers().get(i).getCalAppt().getStartAppt().equals(time1)
                    && getCustomers().get(i).getCalAppt().getEndAppt().equals(time2)
                    && getCustomers().get(i).getUserName() == null && !(getCustomers().get(i).getCalAppt().isBooked())) {
                delIndex = i;
                return delIndex;
            }
        }
        delIndex = -1;
        return delIndex;
    }

    public int unbookApptSearch(Customers customers) {
        int delIndex = 0;
        String time1 = customers.getCalAppt().getStartAppt();
        String time2 = customers.getCalAppt().getEndAppt();
        for (int i = 0; i < getCustomers().size(); i++) {
            if (getCustomers().get(i).getCalAppt().getStartAppt().equals(time1)
                    && getCustomers().get(i).getCalAppt().getEndAppt().equals(time2)) {

                delIndex = i;
                return delIndex;

            }
        }

        return delIndex = -1;
    }





    public void bookAppt(Customers customers) {
        logger.info("Test with Ahmad hhh");
        logger.info("----------------------------------------------------");
        logger.info("i am in : " + customers.getUserName());

        logger.info(before);
        for (int i = 0; i < getCustomers().size(); i++) {
            if (getCustomers().get(i) != null)
                logger.info(getCustomers().get(i).toString());
        }

        int index = bookApptSearch(customers);
        logger.info(String.format("The final index = ", index));
        if (index != -1) {
            logger.info(after);
            for (int i = 0; i < getCustomers().size(); i++) {
                if (i == index) {
                    customers.setCustomersSNN(i + 1);
                    getCustomers().set(i, customers);
                }
                if (getCustomers().get(i) != null)
                    logger.info(getCustomers().get(i).toString());
            }

        }

        else {
            logger.info("Soryy , not Matchable Appointment!!");
            customers.getCalAppt().setBooked(false);
            logger.info(after);
            for (int i = 0; i < getCustomers().size(); i++) {
                if (getCustomers().get(i) != null)
                    logger.info(getCustomers().get(i).toString());
            }
        }

    }

    public void unbookAppt(Customers customers) {
        logger.info("unbooked with ahmad");
        logger.info("----------------------------------------------------");
        logger.info("i am in : " + customers.getUserName());

        logger.info(before);
        for (int i = 0; i < getCustomers().size(); i++) {
            if (getCustomers().get(i) != null)
                logger.info(getCustomers().get(i).toString());
        }
        int index = unbookApptSearch(customers);
        logger.info(String.format("The final index = ", index));

        if (index != -1) {
            logger.info(after);
            for (int i = 0; i < getCustomers().size(); i++) {
                if (i == index) {

                    getCustomers().get(i).setUserName(null);
                    getCustomers().get(i).getCalAppt().setBooked(customers.getCalAppt().isBooked());

                }
                if (getCustomers().get(i) != null)
                    logger.info(getCustomers().get(i).toString());
            }

        }

//		else {
//			logger.info("Soryy , not Matchable Appointment!!");
//			customers.getCalAppt().setBooked(false);
//			logger.info(after);
//			for (int i = 0; i < getCustomers().size(); i++) {
//				if (getCustomers().get(i) != null)
//					logger.info(getCustomers().get(i).toString());
//			}
//
//			return;
//		}
    }

    public void bookMulti(Customers customers, boolean multi1) {
        logger.info("******We are in multi***********");
        boolean flag = false;
        logger.info(String.format("multi1 is :", multi1, " And customers is:", customers.getCalAppt().isBooked()));

        if (customers.getCalAppt().isBooked() && multi1) {
            customers.setMulti(true);
            logger.info(Boolean.toString(customers.isMulti()));
            flag = true;
        }

        if (!flag) {
            customers.setMulti(false);
            return;
        }

        printAppts(customers);

    }

    public void printAppts(Customers customers) {

        logger.info("Customers Name Appointments : " + customers.getUserName());
        for (int i = 0; i < getCustomers().size(); i++) {
            if (getCustomers().get(i).getUserName().equals(customers.getUserName())) {
                logger.info(getCustomers().get(i).toString());
            }

        }
    }

    String regex = ".*[a-z].*";

    public boolean addMobile(User user, String number) {
        if (number.length() != 10 || number.matches(regex))
            return false;
        user.setMobileNumber(number);
        return true;

    }

    public String delateMobile(User user) {
        if (user.getMobileNumber() != null && !user.getMobileNumber().trim().isEmpty()) {
            user.setMobileNumber("");
            return "succesed";

        }
        return failed;

    }

    public String updateMobile(User user, String number) {

        if (number.length() != 10 || number.matches(regex))
            return failed;
        if (number.equals(user.getMobileNumber()))
            return failed;
        user.setMobileNumber(number);
        return "succesed";

    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public boolean addServices(User user, String name, Double price) {

        if (!user.getRole().equals("worker"))
            return false;

        if (price < 0)
            return false;

        for (int i = 0; i < services.size(); i++) {

            if (services.get(i).getServicesName().equals(name))
                return false;
        }

        Services s = new Services(name, price);
        services.add(s);

        return true;

    }

    public void printInvoice(Invoice invoice2) {

        for (int i = 0; i < getInvoice().size(); i++) {
            if (invoice2.getInvoiceNumber() == getInvoice().get(i).getInvoiceNumber()
                    && invoice2.getcustomers().getPointer()[6]) {
                logger.info(invoice2.toString());

            }

        }

    }



}
