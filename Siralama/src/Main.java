import java.util.Scanner;
import java.util.Arrays;


public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Dizinin boyutu n : ");
        int size = input.nextInt();
        int[] arr = new int[size];
        for (int i =1;i<=size;i++)
        {
            System.out.print(i+". eleman: ");
            int element=input.nextInt();
            arr[i-1]=element;
        }
        Arrays.sort(arr);
        System.out.println("Sıralama : ");
        for(int i : arr)
            System.out.print(i + " ");


    }
}

