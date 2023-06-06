public class CellPhone extends Product {
    private int storage;
    private double screenSize;
    private int cameraQuality;
    private double batteryPower;
    private int ram;
    private String color;

    public CellPhone(int id, double price, double discount, int stock, String name, Brand brand,
                     int storage, double screenSize, int cameraQuality, double batteryPower, int ram, String color) {
        super(id, price, discount, stock, name, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.cameraQuality = cameraQuality;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getCameraQuality() {
        return cameraQuality;
    }

    public double getBatteryPower() {
        return batteryPower;
    }

    public int getRam() {
        return ram;
    }

    public String getColor() {
        return color;
    }
}