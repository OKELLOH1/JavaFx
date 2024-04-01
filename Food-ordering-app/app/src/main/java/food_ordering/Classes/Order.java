package food_ordering.Classes;
import java.util.*;

// Order class
public class Order {
    private Customer customer;
    private Restaurant restaurant;
    private MenuItem item;
    private int quantity;
    private Date date;
    private double totalCost;
    private String deliveryAddress;
    private String orderStatus;    
    private PaymentService payment;
    private boolean isPaid;
    // private Timer timer;

    public Order(Restaurant restaurant, MenuItem item,PaymentService payment) {
        // this.customer = customer;
        this.restaurant = restaurant;
        this.item = item;
        this.date = new Date();
        this.totalCost = item.getPrice();
        this.deliveryAddress = "";
        this.orderStatus = "Pending";
        this.payment = payment;
        this.isPaid = false;
        this.quantity = 1;
    }

    public Order(Customer customer, Restaurant restaurant, MenuItem item,PaymentService payment, String deliveryAddress, String orderStatus) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.item = item;
        this.date = new Date();
        this.totalCost = 0;
        this.deliveryAddress = deliveryAddress;
        this.orderStatus = orderStatus;
        this.payment = payment;
        this.isPaid = false;
        }

    public void addItem() {
        this.totalCost += item.getPrice();
        quantity++;
    }

    public void removeItem() {
        if(quantity > 0){
            quantity--;
            this.totalCost -= item.getPrice();
        }
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public Restaurant getRestaurant(){
        return restaurant;
    }

    public MenuItem getItem(){
        return item;
    }

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    public Date getDate() {
        return date;
    }

    public double getTotalCost() {
        return totalCost;
    }
    public int getQuantity(){
        return quantity;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String address) {
        deliveryAddress = address;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void displayOrder() {
        System.out.println("Order Details:");
        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Date: " + date);
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Order Status: " + orderStatus);
        System.out.println("Items: ");
        System.out.println(item.getName() + ": $" + item.getPrice());
        System.out.println("Total Cost: " + totalCost);
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void pay() {
        payment.pay(this.totalCost);
        this.isPaid = true;

        // Create a new timer and schedule the task
        // timer = new Timer();
        // timer.schedule(new TimerTask() {
        //     @Override
        //     public void run() {
        //         if (!orderStatus.equals("Cancelled")) {
        //             setOrderStatus("Accepted");
        //         }
        //     }
        // }, 30000);
    }
    public void cancelOrder() {
        if (!orderStatus.equals("Cancelled")) {
            orderStatus = "Cancelled";
        }
    }
    
    public boolean canModify() {
        return !orderStatus.equals("Cancelled") && !isPaid;
    }

    // public void modifyOrder(ArrayList<MenuItem> newItems, String newDeliveryAddress) {
    //     if (canModify()) {
    //         items = newItems;
    //         deliveryAddress = newDeliveryAddress;
    //     }
    // }
    
}

