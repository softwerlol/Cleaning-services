import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class customer {

    @Given("that those customers are registered in the system")
    public void that_those_customers_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
      //  throw new io.cucumber.java.PendingException();
    }

    @Given("patient enter username {string}")
    public void patient_enter_username(String string) {
        // Write code here that turns the phrase above into concrete actions
     //   throw new io.cucumber.java.PendingException();
    }

    @When("save customers username {string} validation")
    public void save_customers_username_validation(String string) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @Then("customers username is valid")
    public void customers_username_is_valid() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @Given("customers enter username {string}")
    public void customers_enter_username(String string) {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }

    @Then("customers username is invalid")
    public void customers_username_is_invalid() {
        // Write code here that turns the phrase above into concrete actions
     //   throw new io.cucumber.java.PendingException();
    }

    @Given("customers enter password {string}")
    public void customers_enter_password(String string) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @When("save patient password {string} validation")
    public void save_patient_password_validation(String string) {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }

    @Then("customers password is valid")
    public void customers_password_is_valid() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @When("save customers password {string} validation")
    public void save_customers_password_validation(String string) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @Then("customers password is invalid")
    public void customers_password_is_invalid() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @Given("customers enter email {string}")
    public void customers_enter_email(String string) {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }

    @When("customers email get {string} checked")
    public void customers_email_get_checked(String string) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @Then("customers valid email")
    public void customers_valid_email() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @Then("customers invalid email")
    public void customers_invalid_email() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @Given("customers enter mobile number {string}")
    public void customers_enter_mobile_number(String string) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @When("customers mobile number get {string} checked")
    public void customers_mobile_number_get_checked(String string) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @Then("valid mobile number")
    public void valid_mobile_number() {
        // Write code here that turns the phrase above into concrete actions
     //   throw new io.cucumber.java.PendingException();
    }

    @Then("invalid mobile number")
    public void invalid_mobile_number() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }

    @Given("customers enter address: apartmentNumber {string}, streetName {string} , city {string}")
    public void customers_enter_address_apartment_number_street_name_city(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @When("customers : apartmentNumber {string}, streetName {string} , city {string} get checked")
    public void customers_apartment_number_street_name_city_get_checked(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @Then("valid Address")
    public void valid_address() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }

    @Then("invalid Address")
    public void invalid_address() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }

    @Given("customers is sign in by username {string}")
    public void customers_is_sign_in_by_username(String string) {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }

    @Then("customers is sign in")
    public void customers_is_sign_in() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }

    @Then("customers is not sign in")
    public void customers_is_not_sign_in() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }

    @Given("print online array list")
    public void print_online_array_list() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }



}
