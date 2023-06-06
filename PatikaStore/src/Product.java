public class Product {
    private int id;
    private double price;
    private double discount;
    private int stock;
    private String name;
    private Brand brand;

    public Product(int id, double price, double discount, int stock, String name, Brand brand) {
        this.id = id;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }
}
