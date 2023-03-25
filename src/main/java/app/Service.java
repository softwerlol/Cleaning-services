package app;

public class Service {
    private String serviceName;
    private int quantity;
    private double price;
    private String decripation;
    private String material;

    public Service (String serviceName, int quantity, double price,String decripation,String material) {
        this.serviceName = serviceName;
        this.quantity = quantity;
        this.price = price;
        this.dedecripation=decripation;
        this.material=material;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    public double getdecripation() {
        return decripation;
    }
    public double getmaterial() {
        return material;
    }
public double discount(int price) {
	if(price <= 250)
		return price*10/100
		else if(price >= 250 && price <=500)
					return price*15/100
							else if(price > 500)
								return price*20/100
				
	
}



    public void removeQuantity() {
        this.quantity--;
    }

    public String printList() {
        return "Service Name = " + serviceName + ", Quantity = " + quantity + ", Price = " + price + " NIS"+",Decripation = "+decripation +"Material ="+material ;
    }

    @Override
    public String toString() {
    	 return "Service Name = " + serviceName + ", Quantity = " + quantity + ", Price = " + price + " NIS"+",Decripation = "+decripation +"Material ="+material ;
    	       }

}
