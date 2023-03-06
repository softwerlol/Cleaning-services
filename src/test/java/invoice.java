
import static org.junit.Assert.assertTrue;
import app.Application;
import app.CalendarAppointment;
import app.Invoice;
import app.Customers;
import app.Worker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class invoice {

    private Application app;
    private Invoice invoice;

    public invoice(Application app) {
        this.app = app;
    }

    @Given("that those invoices are  in the system class invoice")
    public void that_those_invoices_are_in_the_system_class_invoice(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        Customers customers;
        Worker Worker;
        Invoice invoice;
        for (int i = 0; i < dataTable.height(); i++) {
            invoice = new Invoice(Integer.parseInt(dataTable.row(i).get(0)), dataTable.row(i).get(1),
                    dataTable.row(i).get(2), dataTable.row(i).get(3), dataTable.row(i).get(4));
            app.getInvoice().add(invoice);

        }
       // throw new io.cucumber.java.PendingException();
    }

    @Given("invoice number {int} customers name {string} Workername {string} service {string} fee {string}")
    public void invoice_number_customers_name_workername_service_fee(Integer int1, String string, String string2, String string3, String string4) {
        this.invoice = new Invoice(int1, string, string2, string3, string4);
      //  throw new io.cucumber.java.PendingException();
    }

    @Then("requested invoice and print it")
    public void requested_invoice_and_print_it() {
        invoice.getcustomers().getPointer()[6] = true;
        app.printInvoice(this.invoice);
        assertTrue(true);
       // throw new io.cucumber.java.PendingException();
    }



    @Given("that those customers and appointments are in the system to print report")
    public void that_those_customers_and_appointments_are_in_the_system_to_print_report(
            io.cucumber.datatable.DataTable dataTable) {

//		Invoice invoice;
        Invoice invoice2;

        for (int i = 1; i < dataTable.height(); i++) {

//	public Invoice(int invoiceNumber, String customerstName, String WorkerName, String serviceDescription,
//	String serviceFee, String ApptYear, String ApptMonth, String ApptDay, String StartAppt, String EndAppt,

      //       |		|		    | 2022        |1       |   15    |
  //     |1	|c00001	| 08:00       |08:30   |  true	 |d12345  | carpets     |  40	 |
  //     |2	|c00001	| 08:30       |09:00   |  true   |d12345  | covers  |  10  |
  //     |3	|c00002	| 09:00       |09:30   |  true   |d12340  |carpets and covers  |  1000|
               invoice2 = new Invoice(
                    Integer.parseInt(dataTable.row(i).get(0)), dataTable.row(i).get(1),
                    dataTable.row(i).get(5), dataTable.row(i).get(6), dataTable.row(i).get(7),
                    Boolean.parseBoolean(dataTable.row(i).get(4))
            );
            invoice2.datesetting(dataTable.row(0).get(2), dataTable.row(0).get(3), dataTable.row(0).get(4));
            invoice2.timesetting(dataTable.row(i).get(2), dataTable.row(i).get(3));
            app.getInvoice().add(invoice2);

        }
    }

    @Given("print report")
    public void printReport() {
        System.out.println("the size is " + app.getInvoice().size());
        for (int i = 0; i < app.getInvoice().size(); i++) {
            System.out.println(app.getInvoice().get(i).printReport());
        }
    }

}
