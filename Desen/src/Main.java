import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("N Sayısı: ");
        int num = input.nextInt();
        System.out.print("Çıktısı: ");
        decreaseByFive(num);
        System.out.print(num);
    }

    public static void decreaseByFive(int x) {
        if (x > 0) {  // base case: stop recursion if x is 0 or negative
            System.out.print(x + " ");
            decreaseByFive(x - 5);
            System.out.print((x -5) + " ");
        }
    }
}

