public class Notebook extends Product {
    private int storage;
    private double screenSize;
    private int ram;

    public Notebook(int id, double price, double discount, int stock, String name, Brand brand,
                    int storage, double screenSize, int ram) {
        super(id, price, discount, stock, name, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getRam() {
        return ram;
    }
}