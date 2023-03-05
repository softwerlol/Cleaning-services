import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class invoice {

    @Given("that those invoices are  in the system class invoice")
    public void that_those_invoices_are_in_the_system_class_invoice(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
       // throw new io.cucumber.java.PendingException();
    }

    @Given("invoice number {int} customers name {string} Workername {string} service {string} fee {string}")
    public void invoice_number_customers_name_workername_service_fee(Integer int1, String string, String string2, String string3, String string4) {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }

    @Then("requested invoice and print it")
    public void requested_invoice_and_print_it() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }


}
