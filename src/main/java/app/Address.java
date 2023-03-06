package app;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {

    String apartmentNumber;
    String streetName;
    String city;
    boolean []signbit= { false, false, false };

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(String apartmentNumber, String streetName, String city) {
        this.streetName = streetName;
        this.apartmentNumber = apartmentNumber;
        this.city = city;

    }

    void validApartmentNumber(String apartmentNumber) {

        String regex = "([0-9]).{1,4}";
        Pattern p = Pattern.compile(regex);

        if (apartmentNumber == null)
            this.signbit[0] = false;
        else {
            Matcher m = p.matcher(apartmentNumber);

            if (m.matches())
                this.signbit[0] = true;
            else
                this.signbit[0] = false;
        }
    }

    void validStreetName(String streetName) {

        String regex = "([a-zA-Z]).{3,15}";
        Pattern p = Pattern.compile(regex);

        if (streetName == null)
            this.signbit[1] = false;
        else {
            Matcher m = p.matcher(streetName);
            if (m.matches())
                this.signbit[1] = true;
            else
                this.signbit[1] = false;
        }

    }

    void validCity(String city) {

        String regex = "([a-zA-Z]).{3,15}";
        Pattern p = Pattern.compile(regex);

        if (city == null)
            this.signbit[2] = false;
        else {
            Matcher m = p.matcher(city);
            if (m.matches())
                this.signbit[2] = true;
            else
                this.signbit[2] = false;
        }
    }

    public boolean validationTest(String a, String c, String s) {
        this.validApartmentNumber(a);
        this.validCity(s);
        this.validStreetName(c);
        boolean checkPoint = false;
        for(int i = 0; i < signbit.length; i++) {
            if (!signbit[i]) {
                checkPoint = false;
                break;
            } else if (signbit[i]) {
                checkPoint = true;
                continue;
            }
        }
        return checkPoint;
    }
}
