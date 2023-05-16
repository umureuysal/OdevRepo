import java.util.Scanner;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        int[] array = {10, 20, 20, 10, 10, 20, 5, 20};
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int count = 1;

            if (value == -1) {
                continue;
            }

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == value) {
                    count++;
                    array[j] = -1;
                }
            }

            System.out.println(value + "sayısı "+count+" kere tekrar edildi");
        }
    }
}




