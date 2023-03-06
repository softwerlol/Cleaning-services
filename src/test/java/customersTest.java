
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import app.Address;
import app.Application;
import app.Customers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class customersTest {
    Customers c0 = new Customers();
    Address address0;
    private Application app;

    public  customersTest (Application app) {
        this.app = app;
    }


    @Given("that those customers are registered in the system")
    public void that_those_customers_are_registered_in_the_system(io.cucumber.datatable.DataTable dataTable) {
        for (int i = 0; i < dataTable.height(); i++) {
            c0.validUsername(dataTable.row(i).get(0), "c");
            c0.validPassword(dataTable.row(i).get(1));
            c0.validEmail(dataTable.row(i).get(5));
            c0.validMobileNumber(dataTable.row(i).get(6));
            if (c0.getPointer()[0] && c0.getPointer()[1] && c0.getPointer()[2] && c0.getPointer()[3]) {
                c0 = new Customers(dataTable.row(i).get(0), dataTable.row(i).get(1), dataTable.row(i).get(5),
                        dataTable.row(i).get(6));
                c0.getPointer()[4] = true;
                c0.getPointer()[5] = false;
                app.getCustomers().add(c0);
            }

        }


       // throw new io.cucumber.java.PendingException();
    }

    @Given("customers enter username {string}")
    public void customers_enter_username(String string) {
            c0.validUsername(string, "c");
       // throw new io.cucumber.java.PendingException();
    }

    @When("save customers username {string} validation")
    public void save_customers_username_validation(String string) {
        if (c0.getPointer()[0]) {
            c0.setUserName(string);
        }       // throw new io.cucumber.java.PendingException();
    }

    @Then("customers username is valid")
    public void customers_username_is_valid() {
        assertTrue(c0.getPointer()[0]);
        // throw new io.cucumber.java.PendingException();
    }

    @Then("customers username is invalid")
    public void customers_username_is_invalid() {
        assertFalse(c0.getPointer()[0]);
        // throw new io.cucumber.java.PendingException();
    }

    @Given("customers enter password {string}")
    public void customers_enter_password(String string) {
        c0.validPassword(string);
       // throw new io.cucumber.java.PendingException();
    }

    @When("save customers password {string} validation")
    public void save_customers_password_validation(String string) {
        if (c0.getPointer()[1]) {
            c0.setPassword(string);
        }
      //  throw new io.cucumber.java.PendingException();
    }

    @Then("customers password is valid")
    public void customers_password_is_valid() {
        assertTrue(c0.getPointer()[1]);
       // throw new io.cucumber.java.PendingException();
    }

    @Then("customers password is invalid")
    public void customers_password_is_invalid() {
        assertFalse(c0.getPointer()[1]);
        // throw new io.cucumber.java.PendingException();
    }

    @Given("customers enter email {string}")
    public void customers_enter_email(String string) {
        c0.validEmail(string);
      // throw new io.cucumber.java.PendingException();
    }

    @When("customers email get {string} checked")
    public void customers_email_get_checked(String string) {
        if (c0.getPointer()[2])
            c0.setEmail(string);
       // throw new io.cucumber.java.PendingException();
    }

    @Then("customers valid email")
    public void customers_valid_email() {
        assertTrue(c0.getPointer()[2]);
        //throw new io.cucumber.java.PendingException();
    }

    @Then("customers invalid email")
    public void customers_invalid_email() {
        assertFalse(c0.getPointer()[2]);
        // throw new io.cucumber.java.PendingException();
    }

    @Given("customers enter mobile number {string}")
    public void customers_enter_mobile_number(String string) {
        c0.validMobileNumber(string);
       // throw new io.cucumber.java.PendingException();
    }

    @When("customers mobile number get {string} checked")
    public void customers_mobile_number_get_checked(String string) {

        if (c0.getPointer()[3])
            c0.setMobileNumber(string);
      //  throw new io.cucumber.java.PendingException();
    }

    @Then("valid mobile number")
    public void valid_mobile_number() {
        assertTrue(c0.getPointer()[3]);
        //throw new io.cucumber.java.PendingException();
    }

    @Then("invalid mobile number")
    public void invalid_mobile_number() {
        assertTrue(c0.getPointer()[3]);
       // throw new io.cucumber.java.PendingException();
    }

    @Given("customers enter address: apartmentNumber {string}, streetName {string} , city {string}")
    public void customers_enter_address_apartment_number_street_name_city(String string, String string2, String string3) {
            address0 = new Address(string, string2, string3);
       // throw new io.cucumber.java.PendingException();
    }

    @When("customers : apartmentNumber {string}, streetName {string} , city {string} get checked")
    public void customers_apartment_number_street_name_city_get_checked(String string, String string2, String string3) {
        if (address0.validationTest(string, string2, string3)) {
            address0.setApartmentNumber(string);
            address0.setStreetName(string2);
            address0.setCity(string3);
        }
        //throw new io.cucumber.java.PendingException();
    }

    @Then("valid Address")
    public void valid_address() {
        assertTrue(address0.validationTest(address0.getApartmentNumber(), address0.getStreetName(), address0.getCity()));      //  throw new io.cucumber.java.PendingException();
    }

    @Then("invalid Address")
    public void invalid_address() {
        assertFalse(address0.validationTest(address0.getApartmentNumber(), address0.getStreetName(), address0.getCity()));        //throw new io.cucumber.java.PendingException();
    }

    @Given("customers is sign in by username {string}")
    public void customers_is_sign_in_by_username(String string) {
        System.out.println("SIGN in");

        for (int i = 0; i < app.getCustomers().size(); i++) {
            if (app.getCustomers().get(i).getUserName().equals(string)) {
                c0.addonlineCustomers(c0);
            }

        }

        // throw new io.cucumber.java.PendingException();
    }

    @Then("customers is sign in")
    public void customers_is_sign_in() {
        assertTrue(c0.getPointer()[5]);
       // throw new io.cucumber.java.PendingException();
    }

    @Then("customers is not sign in")
    public void customers_is_not_sign_in() {
        assertFalse(c0.getPointer()[5]);
      //  throw new io.cucumber.java.PendingException();
    }

    @Given("print online array list")
    public void print_online_array_list() {
        for (Customers str : app.getCustomers()) {
            System.out.print(str.getUserName() + " : ");
            System.out.print(str.getPassword() + " : ");
            System.out.print(str.getEmail() + " : ");
            System.out.print(str.getMobileNumber() + " : ");
            System.out.println("sign up status is:" + str.getPointer()[4]);
            System.out.println("sign in status is:" + c0.getPointer()[5]);
        }
       // throw new io.cucumber.java.PendingException();
    }



}