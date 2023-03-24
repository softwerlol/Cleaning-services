package app;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;

public class MainInterface {
    static Logger logger = Logger.getLogger(MainInterface.class.getName());
    static int userIndex;
    private static Scanner scan = new Scanner(System.in);

    private static ArrayList<Users> users = new ArrayList<>();
    private static String userName, password;

    private static Record record = new Record();
    static ArrayList<Service> servicesList = new ArrayList<Service>();
    ArrayList<Service> selectedServices = new ArrayList<Service>();

    static String Admin = "Admin";
    static String Worker = "Worker";
    static String Customer = "Customer";
    static String Secretary = "Secretary";
    static String Welcome = "\t\t\tWelcome ";
    static String separate = "================================================================================";
    static String separate2 = "------------------------------------";
    static String Done = "Done!\n";
    static String selectOption = "\nPlease select an option:";
    static String logOut = "Logged Out...\n";
    static String invalid = "Invalid selection! Please try again...";
    static String error = "Unsuccessfull Operation!";
    static String orderList = "Orders List:";
    static String timeString = "   Time: ";

    public static void init() {
        users.add(new Admin("Ahmad", "ahmad123", Admin));
        users.add(new Worker("qasem", "qasem123", Worker));
        users.add(new Customer("anas", "anas123", Customer));
        users.add(new Customer("sami", "sami123", Customer));
        users.add(new Secretary("sara", "sara123", Secretary));

        Customer customer = (Customer)users.get(2);
        record.addOrder(new Order("05", "01", "2023", "11"), customer);
        customer = (Customer)users.get(3);
        record.addOrder(new Order("14", "05", "2023", "3"), customer);

        record.addOrder(new Order("02", "05", "2023", "9"), customer);
        record.addOrder(new Order("25", "05", "2023", "3"), customer);

        record.addVisit(new Order("02", "05", "2023", "9"));
        record.addVisit(new Order("25", "05", "2023", "3"));

        Service service1 = new Service("Cleaning carpets", 50, 250.00);
        servicesList.add(service1);
        servicesList.add(new Service("Cleaning covers", 1, 50.00));
        servicesList.add(new Service("Cleaning  carpets and covers", 50, 500.00));

    }

    public static int authenticateUser() {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).checkUserName(userName)) {
                if (users.get(i).checkPassword(password)) {
                    users.get(i).signIn(userName, password);
                    return i;
                }
                else
                    return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        init();

        while (true) {
            System.out.println("Enter Username:");
            userName = scan.nextLine();

            if (userName.equalsIgnoreCase("exit"))
                System.exit(0);

            System.out.println("\nEnter Password:");
            password = scan.nextLine();

            System.out.println();

            userIndex = authenticateUser();

            if (userIndex != -1) {
                if (users.get(userIndex).checkRole(Admin))
                    adminActivities();
                else if (users.get(userIndex).checkRole(Worker))
                    workerActivities();
                else if (users.get(userIndex).checkRole(Customer))
                    customerActivities();
                else if (users.get(userIndex).checkRole(Secretary))
                    secretaryActivities();
            }

            else if (userName.equalsIgnoreCase("exit"))
                break;

            else
                System.out.println("The username or password is incorrect. Please try again...\n");
        }

    }

    public static void adminActivities() {
        while (true) {
            int i;
            int index;
            String newUserName;
            String newPassword;
            String newRole;

            System.out.println(Welcome + users.get(userIndex).userName);
            System.out.println(separate);
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. Show Users");
            System.out.println("4. Sign Out");
            System.out.println(selectOption);
            int select = scan.nextInt();
            System.out.println();

            switch (select) {
                case 1:
                    scan.nextLine();
                    System.out.println("Enter Username:");
                    newUserName = scan.nextLine();
                    System.out.println("Enter Password:\n");
                    newPassword = scan.nextLine();
                    System.out.println("Enter Role:\n");
                    newRole = scan.nextLine();
                    if (newRole.equalsIgnoreCase(Admin))
                        users.add(new Admin(newUserName, newPassword, newRole));
                    else if (newRole.equalsIgnoreCase(Worker))
                        users.add(new Worker(newUserName, newPassword, newRole));
                    else if (newRole.equalsIgnoreCase(Customer))
                        users.add(new Customer(newUserName, newPassword, newRole));
                    else if (newRole.equalsIgnoreCase(Secretary))
                        users.add(new Secretary(newUserName, newPassword, newRole));
                    System.out.println(Done);
                    break;

                case 2:
                    System.out.println("Users List:");
                    System.out.println(separate2);
                    i = 1;
                    for (Users user : users) {
                        System.out.println(i++ + ". " + user.userName + "\t\t" + user.password + "\t\t" + user.role);
                    }
                    System.out.println();
                    System.out.println("\nPlease select a user:");
                    index = scan.nextInt();
                    if (index > i || index < 1) {
                        System.out.println(invalid);
                        break;
                    }
                    index--;
                    users.remove(index);
                    System.out.println();
                    System.out.println(Done);
                    break;

                case 3:
                    System.out.println("Users List:");
                    System.out.println(separate2);
                    i = 1;
                    for (Users user : users) {
                        System.out.println(i++ + ". " + user.userName + "\t\t" + user.password + "\t\t" + user.role);
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println(logOut);
                    scan.nextLine();
                    return;

                default:
                    System.out.println(invalid);
                    System.out.println();
            }
        }
    }

    public static void workerActivities() {
        while (true) {
            int i = 1;
            int index;
            ArrayList<Integer> appIndex = new ArrayList<>();

            System.out.println("\t\t\tWelcome W. " + users.get(userIndex).userName);
            System.out.println(separate);
            System.out.println("1. Show Customers List");
            System.out.println("2. Sign Out");
            System.out.println(selectOption);
            int select = scan.nextInt();
            System.out.println();

            switch (select) {
                case 1:
                    System.out.println("Customers List:");
                    System.out.println(separate2);
                    i = 1;
                    appIndex.clear();
                    for (int j = 0; j < record.getCustomers().size(); j++)
                        if (record.getType().get(j) == 1) {
                            System.out.println(i++ + ". " + record.getCustomers().get(j).userName);
                            appIndex.add(j);
                        }
                    if (appIndex.isEmpty()) {
                        System.out.println("No Customers!\n");
                        break;
                    }
                    System.out.println();
                    System.out.println("\nPlease select a Customer:");
                    index = scan.nextInt();
                    if (index > i || index < 1) {
                        System.out.println(invalid);
                        break;
                    }
                    index--;
                    index = appIndex.get(index);
                    System.out.println();
                    System.out.println("\nEnter Cleaning services Fee:");
                    record.getCustomers().get(index).setWorkerVisit(scan.nextDouble());
                    record.addVisit(record.getOrders().get(index));
                    System.out.println("\nDone!\n");
                    break;

                case 2:
                    System.out.println(logOut);
                    scan.nextLine();
                    return;

                default:
                    System.out.println(invalid);
                    System.out.println();
            }
        }
    }

    public static void customerActivities() {
        while (true) {
            int i;
            int index;
            Customer customer = (Customer)users.get(userIndex);
            ArrayList<Integer> appIndex = new ArrayList<>();

            System.out.println(Welcome + users.get(userIndex).userName);
            System.out.println(separate);
            System.out.println("1. Add a Service");
            System.out.println("2. Show Services");
            System.out.println("3. Add Order");
            System.out.println("4. Edit Order");
            System.out.println("5. Delete Order");
            System.out.println("6. Show Order");
            System.out.println("7. Sign Out");
            System.out.println(selectOption);
            int select = scan.nextInt();
            System.out.println();

            switch (select) {
                case 1:
                    i = 1;
                    System.out.println("Services List:");
                    System.out.println(separate2);
                    for (Service service : servicesList) {
                        System.out.println(i++ + ". " + service);
                    }
                    System.out.println();
                    System.out.println("\nPlease select a service:");
                    index = scan.nextInt();
                    if (index > i || index < 1) {
                        System.out.println(invalid);
                        break;
                    }
                    index--;
                    System.out.println();
                    if (servicesList.get(index).getQuantity() != 0) {
                        servicesList.get(index).removeQuantity();
                        customer.getSelectedServices().add(servicesList.get(index));
                        System.out.println(Done);
                    }
                    else
                        System.out.println("This service is not available!\n");

                    break;

                case 2:
                    i = 1;
                    for (Service service : customer.getSelectedServices()) {
                        System.out.println(i++ + ". " + service);
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Choose Day:");
                    String day = scan.next();
                    System.out.println("Choose Month:");
                    String month = scan.next();
                    System.out.println("Choose Year:");
                    String year = scan.next();
                    System.out.println("Choose Time:");
                    String time = scan.next();

                    boolean validOrder = record.addOrder(new Order(day, month, year, time), customer);
                    if (validOrder)
                        System.out.println("Add Order Successfully.\n");
                    else
                        System.out.print(error);
                    break;

                case 4:
                    i = 1;
                    appIndex.clear();
                    System.out.println(orderList);
                    System.out.println(separate2);
                    for (int j = 0; j < record.getOrders().size(); j++) {
                        if (record.getCustomers().get(j).equals(customer) && record.getType().get(j).equals(1)) {
                            System.out.println(i++ + ". " + record.getOrders().get(j).getDay() + "/" +
                                    record.getOrders().get(j).getMonth() + "/" + record.getOrders().get(j).getYear() +
                                    timeString + record.getOrders().get(j).getTime());
                            appIndex.add(j);
                        }
                    }

                    System.out.println();
                    System.out.println("\nPlease select an order:");
                    index = scan.nextInt();
                    if (index > i || index < 1) {
                        System.out.println(invalid);
                        break;
                    }
                    index--;
                    index = appIndex.get(index);
                    System.out.println();
                    System.out.println("Choose New Day:");
                    String newDay = scan.next();
                    System.out.println("Choose New Month:");
                    String newMonth = scan.next();
                    System.out.println("Choose New Year:");
                    String newYear = scan.next();
                    System.out.println("Choose New Time:");
                    String newTime = scan.next();

                    validOrder = record.editOrder(record.getOrders().get(index), new Order(newDay, newMonth, newYear, newTime));

                    if (validOrder)
                        System.out.println("Edit Order Successfully.\n");
                    else
                        System.out.print(error);

                    break;


                case 5:
                    i = 1;
                    appIndex.clear();
                    System.out.println(orderList);
                    System.out.println(separate2);
                    for (int j = 0; j < record.getOrders().size(); j++) {
                        if (record.getCustomers().get(j).equals(customer) && record.getType().get(j).equals(1)) {
                            System.out.println(i++ + ". " + record.getOrders().get(j).getDay() + "/" +
                                    record.getOrders().get(j).getMonth() + "/" + record.getOrders().get(j).getYear() +
                                    timeString + record.getOrders().get(j).getTime());
                            appIndex.add(j);
                        }
                    }

                    System.out.println();
                    System.out.println("\nPlease select an order:");
                    index = scan.nextInt();
                    if (index > i || index < 1) {
                        System.out.println(invalid);
                        break;
                    }
                    index--;
                    index = appIndex.get(index);
                    System.out.println();

                    validOrder = record.deleteOrder(record.getOrders().get(index));

                    if (validOrder)
                        System.out.println("Delete Order Successfully.\n");
                    else
                        System.out.print(error);

                    break;

                case 6:
                    i = 1;
                    appIndex.clear();
                    System.out.println(orderList);
                    System.out.println(separate2);
                    for (int j = 0; j < record.getOrders().size(); j++) {
                        if (record.getCustomers().get(j).equals(customer) && record.getType().get(j).equals(1)) {
                            System.out.println(i++ + ". " + record.getOrders().get(j).getDay() + "/" +
                                    record.getOrders().get(j).getMonth() + "/" + record.getOrders().get(j).getYear() +
                                    timeString + record.getOrders().get(j).getTime());
                            appIndex.add(j);
                        }
                    }

                    System.out.println();
                    break;

                case 7:
                    System.out.println(logOut);
                    scan.nextLine();
                    return;

                default:
                    System.out.println(invalid);
                    System.out.println();
            }
        }
    }

    public static void secretaryActivities() {
        while (true ) {
            int i = 1;
            int index;
            int numOfVisits = 0;
            Report report = new Report();

            System.out.println(Welcome + users.get(userIndex).userName);
            System.out.println(separate);
            System.out.println("1. Print Invoice");
            System.out.println("2. Print a report of visitors in a certain month");
            System.out.println("3. Print a report of available services");
            System.out.println("4. Sign Out");
            System.out.println(selectOption);
            int select = scan.nextInt();
            System.out.println();

            switch (select) {
                case 1:
                    System.out.println("Customers List:");
                    System.out.println(separate2);
                    i = 1;
                    for (int j = 0; j < record.getCustomers().size(); j++)
                        System.out.println(i++ +". " + record.getCustomers().get(j).userName);
                    System.out.println();
                    System.out.println("\nPlease select a customer:");
                    index = scan.nextInt();
                    if (index > i || index < 1) {
                        System.out.println(invalid);
                        break;
                    }
                    index--;
                    System.out.println();
                    Customer customer = record.getCustomers().get(index);
                    Invoice invoice = new Invoice(customer.getSelectedServices(), customer.getWorkerVisit());
                    invoice.printInvoice();
                    customer.getSelectedServices().clear();
                    customer.setWorkerVisit(0.00);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Choose Month:");
                    Integer month = scan.nextInt();
                    for (int j = 0; j < record.getOrders().size(); j++) {
                        if (record.getType().get(j) == 2 && (Integer.parseInt(record.getOrders().get(j).getMonth()) == month))
                            numOfVisits++;
                    }

                    report.numOfVisitsReport(numOfVisits, month.toString());
                    System.out.println();
                    break;

                case 3:
                    report.availableServicesReport(servicesList);
                    System.out.println();
                    break;

                case 4:
                    System.out.println(logOut);
                    scan.nextLine();
                    return;

                default:
                    System.out.println(invalid);
                    System.out.println();

            }
        }
    }
}