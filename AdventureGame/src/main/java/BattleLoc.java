import java.util.Random;

public class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        System.out.println("Şu anda buradasınız: " + this.getName());
        System.out.println("Dikkatli ol! Burada "+ this.randomObstacleAmount() + " adet " + this.getObstacle().getName() + " yaşıyor!");
        String selectCase = input.nextLine();
        selectCase.toUpperCase();
        if(selectCase.equals("S")) {
            System.out.println("Kan dökülecek!");

        }
        return true;
    }
    public boolean combat(int obsAmount) {
        for(int i = 1;i<=obsAmount;i++) {
            playerStats();
            obstacleStats();
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("Vur veya kaç");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    System.out.println("Siz vurdunuz!");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("Canavar size vurdu!");
                    }
                    }
                }
            }

        return false;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + "Canı: " + this.getObstacle().getHealth());
    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Hasar: " + this.getPlayer().getDamage());
        System.out.println("Para: " + this.getPlayer().getMoney());
    }
    public void obstacleStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getReward());
    }
    public int randomObstacleAmount(){
        Random random= new Random();
        return random.nextInt(this.getMaxObstacle())+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
