package app;

public class Order {
    private String day;
    private String month;
    private String year;
    private String time;

    public Order(String day, String month, String year, String time) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.time = time;

    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if  (!(o instanceof Order))
            return false;
        Order other = (Order) o;
        return (this.day.equals(other.day) && this.month.equals(other.month) && this.year.equals(other.year) && this.time.equals(other.time));
    }
    @Override
    public int hashCode() {
        return 0;
    }



}