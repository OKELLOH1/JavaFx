package food_ordering.Classes;

import food_ordering.Abstract_Classes.*;

// Customer class that inherits from FoodService
public class Customer extends FoodService {
    private String email;

    public Customer(String name, String address, String phone, String email) {
        super(name, address, phone);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

}
