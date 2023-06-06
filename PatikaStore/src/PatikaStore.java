import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PatikaStore {
    private List<Brand> brands;
    private List<Product> products;
    private int nextProductId;

    public PatikaStore() {
        brands = new ArrayList<>();
        products = new ArrayList<>();
        nextProductId = 1;
        initializeBrands();
        initializeProducts();
    }

    private void initializeBrands() {
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));
    }

    private void initializeProducts() {
        addProduct(new CellPhone(nextProductId, 3199.0, 0, 10, "SAMSUNG GALAXY A51",
                getBrandByName("Samsung"), 128, 6.5, 32, 4000.0, 6, "Siyah"));
        nextProductId++;
        addProduct(new CellPhone(nextProductId, 7379.0, 0, 8, "iPhone 11 64 GB",
                getBrandByName("Apple"), 64, 6.1, 5, 3046.0, 6, "Mavi"));
        nextProductId++;
        addProduct(new CellPhone(nextProductId, 4012.0, 0, 12, "Redmi Note 10 Pro 8GB",
                getBrandByName("Xiaomi"), 128, 6.5, 35, 4000.0, 12, "Beyaz"));
        nextProductId++;
        addProduct(new Notebook(nextProductId, 7000.0, 0, 5, "HUAWEI Matebook 14",
                getBrandByName("Huawei"), 512, 14.0, 16));
        nextProductId++;
        addProduct(new Notebook(nextProductId, 3699.0, 0, 3, "LENOVO V14 IGL",
                getBrandByName("Lenovo"), 1024, 14.0, 8));
        nextProductId++;
        addProduct(new Notebook(nextProductId, 8199.0, 0, 7, "ASUS Tuf Gaming",
                getBrandByName("Asus"), 2048, 15.6, 32));
        nextProductId++;
    }

    public void addProduct(Product product) {
        products.add(product);
        nextProductId++;
    }

    public void addProductMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ürün Adı: ");
        String name = scanner.nextLine();
        System.out.print("Birim Fiyatı: ");
        double price = scanner.nextDouble();
        System.out.print("İndirim Oranı: ");
        double discount = scanner.nextDouble();
        System.out.print("Stok Miktarı: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Marka: ");
        String brandName = scanner.nextLine();
        Brand brand = getBrandByName(brandName);

        if (brand == null) {
            System.out.println("Geçersiz marka!");
            return;
        }

        System.out.print("Ürün Kategorisi (Cep Telefonu / Notebook): ");
        String category = scanner.nextLine();

        if (category.equalsIgnoreCase("Cep Telefonu")) {
            System.out.print("Depolama: ");
            int storage = scanner.nextInt();
            System.out.print("Ekran Boyutu: ");
            double screenSize = scanner.nextDouble();
            System.out.print("Kamera Kalitesi: ");
            int cameraQuality = scanner.nextInt();
            System.out.print("Pil Gücü: ");
            double batteryPower = scanner.nextDouble();
            System.out.print("RAM: ");
            int ram = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Renk: ");
            String color = scanner.nextLine();

            addProduct(new CellPhone(nextProductId, price, discount, stock, name, brand,
                    storage, screenSize, cameraQuality, batteryPower, ram, color));
        } else if (category.equalsIgnoreCase("Notebook")) {
            System.out.print("Depolama: ");
            int storage = scanner.nextInt();
            System.out.print("Ekran Boyutu: ");
            double screenSize = scanner.nextDouble();
            System.out.print("RAM: ");
            int ram = scanner.nextInt();
            scanner.nextLine();

            addProduct(new Notebook(nextProductId, price, discount, stock, name, brand,
                    storage, screenSize, ram));
        } else {
            System.out.println("Geçersiz ürün kategorisi!");
        }
    }

    public void deleteProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                products.remove(i);
                System.out.println("Ürün başarıyla silindi.");
                return;
            }
        }
        System.out.println("Ürün bulunamadı.");
    }

    public void listBrands() {
        System.out.println("Markalar");
        System.out.println("--------------");
        brands.sort((b1, b2) -> b1.getName().compareToIgnoreCase(b2.getName()));
        for (Brand brand : brands) {
            System.out.println("- " + brand.getName());
        }
        System.out.println();
    }

    public void listProducts(String category) {
        System.out.println(category + " Listesi");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------");
        if (category.equalsIgnoreCase("Cep Telefonu")) {
            System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
            System.out.println("----------------------------------------------------------------------------------------------------");
            for (Product product : products) {
                if (product instanceof CellPhone) {
                    CellPhone cellPhone = (CellPhone) product;
                    System.out.format("| %-2d | %-29s | %-9.2f | %-9s | %-9d | %-9.1f | %-9d | %-9.1f | %-9d | %-9s |\n",
                            cellPhone.getId(), cellPhone.getName(), cellPhone.getPrice(), cellPhone.getBrand().getName(),
                            cellPhone.getStorage(), cellPhone.getScreenSize(), cellPhone.getCameraQuality(),
                            cellPhone.getBatteryPower(), cellPhone.getRam(), cellPhone.getColor());
                }
            }
        } else if (category.equalsIgnoreCase("Notebook")) {
            System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM       |");
            System.out.println("----------------------------------------------------------------------------------------------------");
            for (Product product : products) {
                if (product instanceof Notebook) {
                    Notebook notebook = (Notebook) product;
                    System.out.format("| %-2d | %-29s | %-9.2f | %-9s | %-9s | %-9.1f | %-9d |\n",
                            notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrand().getName(),
                            notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
                }
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public Brand getBrandByName(String brandName) {
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                return brand;
            }
        }
        return null;
    }
}