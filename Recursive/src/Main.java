import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Taban değeri giriniz: ");
        int x = input.nextInt();
        System.out.print("Üs değerini giriniz: ");
        int y = input.nextInt();
        System.out.println("Sonuc: " + power(x,y));
    }
    public static double power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        else if (exponent < 0) {
            return 1 / power(base, -exponent);
        }
        else {
            return base * power(base, exponent - 1);
        }
    }

}
