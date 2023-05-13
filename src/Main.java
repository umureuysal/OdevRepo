import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        isPrime();
    }

    static void isPrime() {
        System.out.print("Bir sayı giriniz: ");
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        boolean isPrime=true;
        for(int i=2;i<n;i++){
            if(n%i==0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            System.out.println(n + " sayısı asaldır.");
        }
        else {
            System.out.println(n + " sayısı asal değildir");
        }
        isPrime();
    }
}

