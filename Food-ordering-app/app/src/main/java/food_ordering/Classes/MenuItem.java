package food_ordering.Classes;

// MenuItem class
public class MenuItem {
    private String name;
    private double price;
    private String description;
    private String category;
    private boolean availability;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.description = "";
        this.category = "";
        this.availability = true;
    }
    public MenuItem(String name, double price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.availability = true;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void displayItem() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Description: " + description);
        System.out.println("Category: " + category);
        System.out.println("Availability: " + availability);
    }
}

