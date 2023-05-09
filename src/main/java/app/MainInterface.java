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

    static String admin = "Admin";
    static String worker = "Worker";
    static String customer = "Customer";
    static String secretary = "Secretary";
    static String welcome = "\t\t\tWelcome ";
    static String separate = "================================================================================";
    static String separate2 = "------------------------------------";
    static String done = "Done!\n";
    static String selectOption = "\nPlease select an option:";
    static String logOut = "Logged Out...\n";
    static String invalid = "Invalid selection! Please try again...";
    static String error = "Unsuccessfull Operation!";
    static String orderList = "Orders List:";
    static String timeString = "   Time: ";

    public static void init() {
        users.add(new Admin("Ahmad", "ahmad123","0595642327","Tulkrem", admin));
        users.add(new Worker("qasem", "qasem123","0595642328","Nubles", worker));
        users.add(new Customer("anas", "anas123","0595642329","Jenin", customer));
        users.add(new Customer("sami", "sami123","0595642324","Ramallah", customer));
        users.add(new Secretary("sara", "sara123","0595642325","Gaza", secretary));

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



            userIndex = authenticateUser();

            if (userIndex != -1) {
                if (users.get(userIndex).checkRole(admin))
                    adminActivities();
                else if (users.get(userIndex).checkRole(worker))
                    workerActivities();
                else if (users.get(userIndex).checkRole(customer))
                    customerActivities();
                else if (users.get(userIndex).checkRole(secretary))
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
            logger.log(Level.INFO,welcome + users.get(userIndex).userName+"\n");
            logger.log(Level.INFO,separate2+"\n");
            logger.log(Level.INFO,"1. Add User");
            logger.log(Level.INFO,"2. Remove User");
            logger.log(Level.INFO,"3. Show Users");
            logger.log(Level.INFO,"4. Send email");
            logger.log(Level.INFO,"5. Sign Out");
            logger.log(Level.INFO,selectOption+"\n");
            int select = scan.nextInt();


            switch (select) {
                case 1:
                    scan.nextLine();
                    logger.log(Level.INFO,"Enter Username:");
                    newUserName = scan.nextLine();
                    logger.log(Level.INFO,"Enter Password:\n");
                    newPassword = scan.nextLine();

                    logger.log(Level.INFO,"Enter Phone:");
                    newPhone = scan.nextLine();
                    logger.log(Level.INFO,"Enter Address:");
                    newAddress = scan.nextLine();

                    logger.log(Level.INFO,"Enter Role:\n");
                    newRole = scan.nextLine();
                    if (newRole.equalsIgnoreCase(admin))
                        users.add(new Admin(newUserName, newPassword,newPhone,newAddress, newRole));
                    else if (newRole.equalsIgnoreCase(worker))
                        users.add(new Worker(newUserName, newPassword,newPhone,newAddress, newRole));
                    else if (newRole.equalsIgnoreCase(customer))
                        users.add(new Customer(newUserName, newPassword,newPhone,newAddress, newRole));
                    else if (newRole.equalsIgnoreCase(secretary))
                        users.add(new Secretary(newUserName, newPassword,newPhone,newAddress, newRole));
                    logger.log(Level.INFO,done);
                    break;

                case 2:
                    logger.log(Level.INFO,"Users List:\n");

                    logger.log(Level.INFO,separate2);
                    i = 1;
                    for (Users user : users) {
                        logger.log(Level.INFO,i++ + ". " + user.userName + "\t\t" + user.password + "\t\t" + user.phone+  "\t\t" + user.address +"\t\t" + user.role);
                    }

                    logger.log(Level.INFO,"\nPlease select a user:");
                    index = scan.nextInt();
                    if (index > i || index < 1) {

                        logger.log(Level.INFO,invalid);
                        break;
                    }
                    index--;
                    users.remove(index);


                    logger.log(Level.INFO,done);
                    break;

                case 3:

                    logger.log(Level.INFO,"Users List:\n");
                    logger.log(Level.INFO,separate2);

                    i = 1;
                    for (Users user : users) {
                        logger.log(Level.INFO,i++ + ". " + user.userName + "\t\t" + user.password + "\t\t" + user.phone+ "\t\t" + user.address+ "\t\t" + user.role);
                    }

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

                    logger.log(Level.INFO,"\nPlease select a Customer:\n");
                    index = scan.nextInt();
                    if (index > i || index < 1) {

                        logger.log(Level.INFO,"invalid\n");
                        break;
                    }
                    index--;
                    index = appIndex.get(index);

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

                        System.out.println(i++ + ". " + recorded.getOrders().get(j).getDay()+"/"+
                                recorded.getOrders().get(j).getMonth()+"/"+
                                recorded.getOrders().get(j).getYear()+" "+
                                recorded.getOrders().get(j).getTime()+"  "+
                                recorded.getOrders().get(j).getStatus()
                        );


                    }


                    break;

                default:

                    logger.log(Level.INFO,invalid+"\n");

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


                    logger.log(Level.INFO,"\nPlease select an order:");
                    index = scan.nextInt();
                    if (index > i || index < 1) {

                        logger.log(Level.INFO,invalid+"\n");
                        break;
                    }
                    index--;



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

            logger.log(Level.INFO,welcome + users.get(userIndex).userName+"\n");
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


            switch (select) {
                case 1:
                    i = 1;
                    logger.log(Level.INFO,"Services List:"+"\n");
                    logger.log(Level.INFO,separate2+"\n");
                    for (Service service : servicesList) {
                        logger.log(Level.INFO,i++ + ". " + service);
                    }

                    logger.log(Level.INFO,"\nPlease select a service:"+"\n");
                    index = scan.nextInt();
                    if (index > i || index < 1) {

                        logger.log(Level.INFO,invalid+"\n");
                        break;
                    }
                    index--;

                    if (servicesList.get(index).getQuantity() != 0) {
                        servicesList.get(index).removeQuantity();
                        customer.getSelectedServices().add(servicesList.get(index));

                        logger.log(Level.INFO,done+"\n");
                    }
                    else
                        logger.log(Level.INFO,"This service is not available!\n"+"\n");

                    break;

                case 2:
                    i = 1;
                    for (Service service : customer.getSelectedServices()) {
                        logger.log(Level.INFO,i++ + ". " + service);
                    }

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


                    logger.log(Level.INFO,"\nPlease select an order:"+"\n");
                    index = scan.nextInt();
                    if (index > i || index < 1) {
                        logger.log(Level.INFO,invalid+"\n");
                        break;
                    }
                    index--;
                    index = appIndex.get(index);

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


                    logger.log(Level.INFO,"\nPlease select an order:"+"\n");
                    index = scan.nextInt();
                    if (index > i || index < 1) {
                        logger.log(Level.INFO,invalid+"\n");
                        break;
                    }
                    index--;
                    index = appIndex.get(index);


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

            logger.log(Level.INFO,welcome + users.get(userIndex).userName);
            scan.nextLine();
            logger.log(Level.INFO,separate);
            scan.nextLine();
            logger.log(Level.INFO,"1. Print Invoice\n");
            logger.log(Level.INFO,"2. Print a report of visitors in a certain month\n");
            logger.log(Level.INFO,"3. Print a report of available services\n");
            logger.log(Level.INFO,"4. Sign Out\n");
            logger.log(Level.INFO,selectOption);
            scan.nextLine();
            int select = scan.nextInt();


            switch (select) {
                case 1:
                    logger.log(Level.INFO,"Customers List:\n");
                    logger.log(Level.INFO,separate2+"\n");
                    i = 1;
                    for (int j = 0; j < recorded.getCustomers().size(); j++)
                        logger.log(Level.INFO,i++ +". " + recorded.getCustomers().get(j).userName);

                    logger.log(Level.INFO,"\nPlease select a customer:");
                    index = scan.nextInt();
                    if (index > i || index < 1) {

                        logger.log(Level.INFO,invalid);
                        break;
                    }
                    index--;


                    Customer customer = recorded.getCustomers().get(index);
                    Invoice invoice = new Invoice(customer.getSelectedServices(), customer.getWorkerVisit());
                    invoice.printInvoice();
                    customer.getSelectedServices().clear();
                    customer.setWorkerVisit(0.00);

                    break;

                case 2:

                    logger.log(Level.INFO,"Choose Month:\n");

                    Integer month = scan.nextInt();
                    for (int j = 0; j < recorded.getOrders().size(); j++) {
                        if (recorded.getType().get(j) == 2 && (Integer.parseInt(recorded.getOrders().get(j).getMonth()) == month))
                            numOfVisits++;
                    }

                    report.numOfVisitsReport(numOfVisits, month.toString());

                    break;

                case 3:
                    report.availableServicesReport(servicesList);
                    scan.nextLine();

                    break;

                case 4:

                    logger.log(Level.INFO,logOut);
                    scan.nextLine();
                    return;

                default:

                    logger.log(Level.INFO,invalid);


                    break;

            }
        }
    }
}