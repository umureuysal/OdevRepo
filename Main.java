import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double boy=1.72, index;
        int kilo=105;

            System.out.print("Lütfen boyunuzu (metre cinsinde) giriniz: ");
            //boy = input.nextDouble();
            System.out.print("Lütfen kilonuzu giriniz : ");
            //kilo = input.nextDouble();


            index = kilo/boy*boy;
            System.out.println("Vücut Kitle İndeksiniz: " + index);




    }
}
