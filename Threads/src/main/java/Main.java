import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        // 1'den 10000'e kadar olan sayıları ekleyelim
        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        // 4 eşit parçaya ayıralım
        int chunkSize = numbers.size() / 4;
        ArrayList<Integer> chunk1 = new ArrayList<>(numbers.subList(0, chunkSize));
        ArrayList<Integer> chunk2 = new ArrayList<>(numbers.subList(chunkSize, 2 * chunkSize));
        ArrayList<Integer> chunk3 = new ArrayList<>(numbers.subList(2 * chunkSize, 3 * chunkSize));
        ArrayList<Integer> chunk4 = new ArrayList<>(numbers.subList(3 * chunkSize, numbers.size()));

        // Ortak ArrayList'ler
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        // Thread'leri oluşturup çalıştıralım
        Thread thread1 = new Thread(new NumberProcessor(chunk1, evenNumbers, oddNumbers));
        Thread thread2 = new Thread(new NumberProcessor(chunk2, evenNumbers, oddNumbers));
        Thread thread3 = new Thread(new NumberProcessor(chunk3, evenNumbers, oddNumbers));
        Thread thread4 = new Thread(new NumberProcessor(chunk4, evenNumbers, oddNumbers));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Tüm thread'lerin işini bitirmesini bekleyelim
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Sonuçları yazdıralım
        System.out.println("Çift Sayılar: " + evenNumbers);
        System.out.println("Tek Sayılar: " + oddNumbers);
    }
}