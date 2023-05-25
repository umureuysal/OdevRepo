import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private GameChar gameChar;

    public Player(String name) {
        this.name = name;
    }

    Scanner scanner = new Scanner(System.in);

    public void selectChar() {
        System.out.println("1 - Samuray");
        System.out.println("1 - Okçu");
        System.out.println("1 - Şövalye");
        System.out.print("Lütfen karakter seçiniz: ");
        int inputNum = scanner.nextInt();
        switch (inputNum) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
        }
    }

    public void selectLoc() {
        Location location = null;
        int loc = scanner.nextInt();
        System.out.println("1 - Güvenli Ev");
        System.out.println("2 - Mağaza");
        System.out.print("Lütfen yer seçiniz: ");
        switch (loc) {
            case 1:
                location = (new SafeHouse(this));
                break;
            case 2:
                location = (new ToolStore(this));
                break;
        }
        location.onLocation();
    }

    public void  initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setName(gameChar.getName());
        System.out.println("Karakteriniz: " + gameChar.getName());
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
