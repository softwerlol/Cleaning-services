package app;


import java.util.ArrayList;

import java.util.Scanner;
import java.util.logging.*;

public class MainInterface {
    static Logger logger = Logger.getLogger(MainInterface.class.getName());

    static int userIndex;
    private static Scanner scan = new Scanner(System.in);

    private static ArrayList<Users> users = new ArrayList<>();
    private static String userName;
    private static String password;

    private static Record recorded = new Record();
    static ArrayList<Service> servicesList = new ArrayList<Service>();
    ArrayList<Service> selectedServices = new ArrayList<Service>();
    static ArrayList<String> email = new ArrayList<String>();

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
        users.add(new Admin("Ahmad", "ahmad123","0595642327","Tulkrem", Admin));
        users.add(new Worker("qasem", "qasem123","0595642328","Nubles", Worker));
        users.add(new Customer("anas", "anas123","0595642329","Jenin", Customer));
        users.add(new Customer("sami", "sami123","0595642324","Ramallah", Customer));
        users.add(new Secretary("sara", "sara123","0595642325","Gaza", Secretary));

        Customer customer = (Customer)users.get(2);
        recorded.addOrder(new Order("05", "01", "2023", "11 ","wating"), customer);
        customer = (Customer)users.get(3);
        recorded.addOrder(new Order("14", "05", "2023", "3 ","wating"), customer);

        recorded.addOrder(new Order("02", "05", "2023", "9 ","intreatment"), customer);
        recorded.addOrder(new Order("25", "05", "2023", "3 ","Done"), customer);

        recorded.addVisit(new Order("02", "05", "2023", "9 ","intreatment"));
        recorded.addVisit(new Order("25", "05", "2023", "3 ","Done"));

        Service service1 = new Service("Cleaning carpets", 50, 250.00,"9 m2 ","silk");
        servicesList.add(service1);
        servicesList.add(new Service("Cleaning covers", 1, 50.00 ,"3 m2 ","cotton"));
        servicesList.add(new Service("Cleaning  carpets and covers", 50, 500.00,"6 m2 ","wool"));

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

            logger.log(Level.INFO,"Enter Username:");
            userName = scan.nextLine();

            if (userName.equalsIgnoreCase("exit"))
                System.exit(0);


            logger.log(Level.INFO,"\nEnter Password:");
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

            logger.log(Level.INFO,"The username or password is incorrect. Please try again...\n");
        }

    }

    public static void adminActivities() {
        while (true) {
            int i;
            int index;
            String newUserName;
            String newPassword;
            String newRole;
            String newPhone;
            String newAddress;
            String emaill;
            System.out.println(Welcome + users.get(userIndex).userName);
            System.out.println(separate);
            logger.log(Level.INFO,"1. Add User");
            logger.log(Level.INFO,"2. Remove User");
            logger.log(Level.INFO,"3. Show Users");
            logger.log(Level.INFO,"4. Send email");
            logger.log(Level.INFO,"5. Sign Out");

            System.out.println(selectOption);
            int select = scan.nextInt();
            System.out.println();

            switch (select) {
                case 1:
                    scan.nextLine();
                    logger.log(Level.INFO,"Enter Username:");
                    newUserName = scan.nextLine();
                    logger.log(Level.INFO,"Enter Password:\n");
                    newPassword = scan.nextLine();
                    System.out.println();
                    logger.log(Level.INFO,"Enter Phone:");
                    newPhone = scan.nextLine();
                    logger.log(Level.INFO,"Enter Address:");
                    newAddress = scan.nextLine();

                    logger.log(Level.INFO,"Enter Role:\n");
                    newRole = scan.nextLine();
                    if (newRole.equalsIgnoreCase(Admin))
                        users.add(new Admin(newUserName, newPassword,newPhone,newAddress, newRole));
                    else if (newRole.equalsIgnoreCase(Worker))
                        users.add(new Worker(newUserName, newPassword,newPhone,newAddress, newRole));
                    else if (newRole.equalsIgnoreCase(Customer))
                        users.add(new Customer(newUserName, newPassword,newPhone,newAddress, newRole));
                    else if (newRole.equalsIgnoreCase(Secretary))
                        users.add(new Secretary(newUserName, newPassword,newPhone,newAddress, newRole));
                    logger.log(Level.INFO,Done);
                    break;

                case 2:
                    logger.log(Level.INFO,"Users List:\n");

                    logger.log(Level.INFO,separate2);
                    i = 1;
                    for (Users user : users) {
                        logger.log(Level.INFO,i++ + ". " + user.userName + "\t\t" + user.password + "\t\t" + user.phone+  "\t\t" + user.address +"\t\t" + user.role);
                    }
                    System.out.println();
                    logger.log(Level.INFO,"\nPlease select a user:");
                    index = scan.nextInt();
                    if (index > i || index < 1) {

                        logger.log(Level.INFO,invalid);
                        break;
                    }
                    index--;
                    users.remove(index);
                    System.out.println();

                    logger.log(Level.INFO,Done);
                    break;

                case 3:

                    logger.log(Level.INFO,"Users List:\n");
                    logger.log(Level.INFO,separate2);

                    i = 1;
                    for (Users user : users) {
                        logger.log(Level.INFO,i++ + ". " + user.userName + "\t\t" + user.password + "\t\t" + user.phone+ "\t\t" + user.address+ "\t\t" + user.role);
                    }
                    System.out.println();
                    break;

                case 4:
                   email.add(0,"");

                    logger.log(Level.INFO,"Please write you email here :");
                    emaill = scan.next();
                    		email.add(0,emaill);

                    break;
                case 5:

                    logger.log(Level.INFO,logOut);
                    scan.nextLine();
                    return;

                default:

                    logger.log(Level.INFO,invalid);
                    System.out.println();


                    break;
            }
        }
    }

    public static void workerActivities() {
        while (true) {
            int i = 1;
            int index;
            ArrayList<Integer> appIndex = new ArrayList<>();

            logger.log(Level.INFO,"\t\t\tWelcome W. " + users.get(userIndex).userName+"\n");

            logger.log(Level.INFO,separate+"\n");
            logger.log(Level.INFO,"1. Show Customers List");
            logger.log(Level.INFO,"2. Show Order");
            logger.log(Level.INFO,"3. Change Order Status");
            logger.log(Level.INFO,"4. Sign Out");
            logger.log(Level.INFO,selectOption+"\n");
            int select = scan.nextInt();
            System.out.println();

            switch (select) {
                case 1:

                    logger.log(Level.INFO,"Customers List:\n");
                    logger.log(Level.INFO,separate2+"\n");
                    i = 1;
                    appIndex.clear();
                    for (int j = 0; j < recorded.getCustomers().size(); j++)
                        if (recorded.getType().get(j) == 1) {
                            logger.log(Level.INFO,i++ + ". " + recorded.getCustomers().get(j).userName);
                            appIndex.add(j);
                        }
                    if (appIndex.isEmpty()) {

                        logger.log(Level.INFO,"No Customers!\n");
                        break;
                    }
                    System.out.println();
                    logger.log(Level.INFO,"\nPlease select a Customer:\n");
                    index = scan.nextInt();
                    if (index > i || index < 1) {

                        logger.log(Level.INFO,"invalid"+"\n");
                        break;
                    }
                    index--;
                    index = appIndex.get(index);
                    System.out.println();
                    logger.log(Level.INFO,"\nEnter Cleaning services Fee:\n");
                    recorded.getCustomers().get(index).setWorkerVisit(scan.nextDouble());
                    recorded.addVisit(recorded.getOrders().get(index));
                    logger.log(Level.INFO,"\nDone!\n");

                    break;

                case 4:

                    logger.log(Level.INFO,logOut+"\n");

                    scan.nextLine();
                    return;
                case 2:
                    i = 1;


                    logger.log(Level.INFO,orderList+"\n");

                    logger.log(Level.INFO,separate2+"\n");
                    for (int j = 0; j < recorded.getOrders().size(); j++) {

                        logger.log(Level.INFO,i++ + ". " + recorded.getOrders().get(j).getDay()+"/"+
                                    recorded.getOrders().get(j).getMonth()+"/"+
                                    recorded.getOrders().get(j).getYear()+" "+
                                    recorded.getOrders().get(j).getTime()+"  "+
                                    recorded.getOrders().get(j).getStatus()
                                   );


                    }

                    System.out.println();
                    break;

                default:

                    logger.log(Level.INFO,invalid+"\n");
                    System.out.println();
                    break;

                case 3:
                    i = 1;

                    logger.log(Level.INFO,orderList+"\n");
                    logger.log(Level.INFO,separate2+"\n");
                    for (int j = 0; j < recorded.getOrders().size(); j++) {

                            logger.log(Level.INFO,i++ + ". " + recorded.getOrders().get(j).getDay() + "/" +
                                    recorded.getOrders().get(j).getMonth() + "/" + recorded.getOrders().get(j).getYear() +
                                    timeString + recorded.getOrders().get(j).getTime()  +recorded.getOrders().get(j).getStatus());


                    }

                    System.out.println();
                    logger.log(Level.INFO,"\nPlease select an order:");
                    index = scan.nextInt();
                    if (index > i || index < 1) {

                        logger.log(Level.INFO,invalid+"\n");
                        break;
                    }
                    index--;

                    System.out.println();

                    String newDay = recorded.getOrders().get(index).getDay();

                    String newMonth = recorded.getOrders().get(index).getMonth();

                    String newYear = recorded.getOrders().get(index).getYear();

                    String newTime = recorded.getOrders().get(index).getTime();

                    logger.log(Level.INFO,"Choose New Status:"+"\n");
                    String newstatus = scan.next();
                    boolean validOrder = recorded.editOrder(recorded.getOrders().get(index), new Order(newDay, newMonth, newYear, newTime,newstatus));

                    if (validOrder)

                    logger.log(Level.INFO,"Edit Order Successfully.\n"+"\n");
                    else
                        logger.log(Level.INFO,error+"\n");

                    break;

            }
        }
    }

    public static void customerActivities() {
        while (true) {
            int i;
            int index;
            Customer customer = (Customer)users.get(userIndex);
            ArrayList<Integer> appIndex = new ArrayList<>();

            logger.log(Level.INFO,Welcome + users.get(userIndex).userName+"\n");
            logger.log(Level.INFO,separate+"\n");
            logger.log(Level.INFO,"1. Add a Service"+"\n");
            logger.log(Level.INFO,"2. Show Services"+"\n");
            logger.log(Level.INFO,"3. Add Order"+"\n");
            logger.log(Level.INFO,"4. Edit Order"+"\n");
            logger.log(Level.INFO,"5. Delete Order"+"\n");
            logger.log(Level.INFO,"6. Show Order"+"\n");
            logger.log(Level.INFO,"7. Your Cost"+"\n");
            logger.log(Level.INFO,"8. Show email"+"\n");
            logger.log(Level.INFO,"9. Sign Out"+"\n");
            logger.log(Level.INFO,selectOption+"\n");
            int select = scan.nextInt();
            System.out.println();

            switch (select) {
                case 1:
                    i = 1;
                    logger.log(Level.INFO,"Services List:"+"\n");
                    logger.log(Level.INFO,separate2+"\n");
                    for (Service service : servicesList) {
                       logger.log(Level.INFO,i++ + ". " + service);
                    }
                    System.out.println();
                    logger.log(Level.INFO,"\nPlease select a service:"+"\n");
                    index = scan.nextInt();
                    if (index > i || index < 1) {

                        logger.log(Level.INFO,invalid+"\n");
                        break;
                    }
                    index--;
                    System.out.println();
                    if (servicesList.get(index).getQuantity() != 0) {
                        servicesList.get(index).removeQuantity();
                        customer.getSelectedServices().add(servicesList.get(index));

                        logger.log(Level.INFO,Done+"\n");
                    }
                    else
                    logger.log(Level.INFO,"This service is not available!\n"+"\n");

                    break;

                case 2:
                    i = 1;
                    for (Service service : customer.getSelectedServices()) {
                        logger.log(Level.INFO,i++ + ". " + service);
                    }
                    System.out.println();
                    break;

                case 3:
                    logger.log(Level.INFO,"Choose Day:"+"\n");
                    String day = scan.next();
                    logger.log(Level.INFO,"Choose Month:"+"\n");
                    String month = scan.next();
                    logger.log(Level.INFO,"Choose Year:"+"\n");
                    String year = scan.next();
                    logger.log(Level.INFO,"Choose Time:"+"\n");
                    String time = scan.next();
                    String status ="wating";
                    boolean validOrder = recorded.addOrder(new Order(day, month, year, time,status), customer);
                    if (validOrder)

                    logger.log(Level.INFO,"Add Order Successfully.\n"+"\n");
                    else
                    logger.log(Level.INFO,error+"\n");
                    break;

                case 4:
                    i = 1;
                    appIndex.clear();
                    logger.log(Level.INFO,orderList+"\n");
                    logger.log(Level.INFO,separate2+"\n");
                    for (int j = 0; j < recorded.getOrders().size(); j++) {
                        if (recorded.getCustomers().get(j).equals(customer) && recorded.getType().get(j).equals(1)) {
                            logger.log(Level.INFO,i++ + ". " + recorded.getOrders().get(j).getDay() + "/" +
                                    recorded.getOrders().get(j).getMonth() + "/" + recorded.getOrders().get(j).getYear() +
                                    timeString + recorded.getOrders().get(j).getTime()+" " +recorded.getOrders().get(j).getStatus());
                            appIndex.add(j);
                        }
                    }

                    System.out.println();
                    logger.log(Level.INFO,"\nPlease select an order:"+"\n");
                    index = scan.nextInt();
                    if (index > i || index < 1) {
                        logger.log(Level.INFO,invalid+"\n");
                        break;
                    }
                    index--;
                    index = appIndex.get(index);
                    System.out.println();
                    logger.log(Level.INFO,"Choose New Day:"+"\n");
                    String newDay = scan.next();
                    logger.log(Level.INFO,"Choose New Month:"+"\n");
                    String newMonth = scan.next();
                    logger.log(Level.INFO,"Choose New Year:"+"\n");
                    String newYear = scan.next();
                    logger.log(Level.INFO,"Choose New Time:"+"\n");
                    String newTime = scan.next();
                    String statuss="wating";
                    validOrder = recorded.editOrder(recorded.getOrders().get(index), new Order(newDay, newMonth, newYear, newTime,statuss));

                    if (validOrder)

                    logger.log(Level.INFO,"Edit Order Successfully.\n"+"\n");
                    else

                    logger.log(Level.INFO,error+"\n");
                    break;


                case 5:
                    i = 1;
                    appIndex.clear();
                    logger.log(Level.INFO,orderList+"\n");
                    logger.log(Level.INFO,separate2+"\n");
                    for (int j = 0; j < recorded.getOrders().size(); j++) {
                        if (recorded.getCustomers().get(j).equals(customer) && recorded.getType().get(j).equals(1)) {
                            logger.log(Level.INFO,i++ + ". " + recorded.getOrders().get(j).getDay() + "/" +
                                    recorded.getOrders().get(j).getMonth() + "/" + recorded.getOrders().get(j).getYear() +
                                    timeString + recorded.getOrders().get(j).getTime() +recorded.getOrders().get(j).getStatus());
                            appIndex.add(j);
                        }
                    }

                    System.out.println();
                    logger.log(Level.INFO,"\nPlease select an order:"+"\n");
                    index = scan.nextInt();
                    if (index > i || index < 1) {
                        logger.log(Level.INFO,invalid+"\n");
                        break;
                    }
                    index--;
                    index = appIndex.get(index);
                    System.out.println();

                    validOrder = recorded.deleteOrder(recorded.getOrders().get(index));

                    if (validOrder)

                    logger.log(Level.INFO,"Delete Order Successfully.\n"+"\n");
                    else
                    logger.log(Level.INFO,error+"\n");

                    break;

                case 6:
                    i = 1;
                    appIndex.clear();
                    logger.log(Level.INFO,orderList+"\n");
                    logger.log(Level.INFO,separate2+"\n");
                    for (int j = 0; j < recorded.getOrders().size(); j++) {
                        if (recorded.getCustomers().get(j).equals(customer) && recorded.getType().get(j).equals(1)) {
                            logger.log(Level.INFO,i++ + ". " + recorded.getOrders().get(j).getDay() + "/" +
                                    recorded.getOrders().get(j).getMonth() + "/" + recorded.getOrders().get(j).getYear() +
                                    timeString + recorded.getOrders().get(j).getTime() +" "+recorded.getOrders().get(j).getStatus());
                            appIndex.add(j);
                        }
                    }

                    System.out.println();
                    break;
                case 7:
                    i = 1;
                    int price=0;
                    int price1=0;
                    for (Service service : customer.getSelectedServices()) {
                    	price +=service.getPrice();
                        price1 +=service.getPrice();
                        
                    }

                    if(price <= 250)
                        price =price - (price*10/100);
                    else if(price >= 250 && price <=500)
                        price= price - (price*15/100);
                    else if(price > 500)
                        price = price- (price*20/100);
                    else
                        price=price1;
                    logger.log(Level.INFO,"Your Total Price "+price1+"\n");
                    logger.log(Level.INFO,"Your Total Price after dicount  "+(price)+"\n");
                    System.out.println();
                    break;
                case 8:
                	if(email.get(0).equals(""))
                    logger.log(Level.INFO,"You Dont have any email"+"\n");
                	else
                        logger.log(Level.INFO,"You have an email \n"+ email.get(0)+"\n");
                    break;
                case 9:
                    logger.log(Level.INFO,logOut+"\n");
                    scan.nextLine();
                    return;

                default:
                    logger.log(Level.INFO,invalid+"\n");
                    System.out.println();
                    break;
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
                    for (int j = 0; j < recorded.getCustomers().size(); j++)
                        System.out.println(i++ +". " + recorded.getCustomers().get(j).userName);
                    System.out.println();
                    System.out.println("\nPlease select a customer:");
                    index = scan.nextInt();
                    if (index > i || index < 1) {
                        System.out.println(invalid);
                        break;
                    }
                    index--;
                    System.out.println();
                    Customer customer = recorded.getCustomers().get(index);
                    Invoice invoice = new Invoice(customer.getSelectedServices(), customer.getWorkerVisit());
                    invoice.printInvoice();
                    customer.getSelectedServices().clear();
                    customer.setWorkerVisit(0.00);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Choose Month:");
                    Integer month = scan.nextInt();
                    for (int j = 0; j < recorded.getOrders().size(); j++) {
                        if (recorded.getType().get(j) == 2 && (Integer.parseInt(recorded.getOrders().get(j).getMonth()) == month))
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