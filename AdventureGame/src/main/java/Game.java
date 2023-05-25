import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    public void start(){
        //System.out.print("Oyuncu adını giriniz: ");
        //String playerName = scanner.nextLine();
        Player player = new Player("Umur");
        System.out.println("Oyuna hoşgeldin " + player.getName() + "!");
        player.selectChar();
        //player.selectLoc();

        Location location = null;
        while(true){
            System.out.println("Bölgeler");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Mağaza");
            System.out.println("3 - Mağara");
            System.out.println("4 - Orman");
            System.out.println("5 - Nehir");
            System.out.println("0 - Çıkış");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz");
            int selectLoc = scanner.nextInt();
            switch (selectLoc){
                case 0:location=null;
                break;
                case 1:location=new SafeHouse(player);
                break;
                case 2: location=new ToolStore(player);
                break;
                case 3:location=new Cave(player);
                break;
                case 4:location=new Forest(player);
                break;
                case 5:location=new River(player);
                break;
                default:System.out.println("Lütfen geçerli bir bölge giriniz");
            }
            if(!location.onLocation()){
                System.out.println("OYUN BİTTİ!");
            }
        }
    }
}
