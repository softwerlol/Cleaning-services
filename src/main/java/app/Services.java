package app;

public class Services {

    private String serviceName;
    private Double servicePrice;

    public Services() {

    }
    public Services(String name, Double price) {
        this.serviceName = name;
        this.servicePrice = price;
    }

    public String getServicesName() {
        return serviceName;
    }

    public void setServicesName(String servicesName) {
        serviceName = servicesName;
    }

    public Double getServicesPrice() {
        return servicePrice;
    }

    public void setServicesPrice(Double servicesPrice) {
        servicePrice = servicesPrice;
    }


}
