import java.io.*;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Book> bookSetByName = new TreeSet<>();
        Set<Book> bookSetByPageCount = new TreeSet<>(Comparator.comparingInt(Book::getPageCount));

        // Kitap nesnelerini oluşturup setlere ekleyelim
        Book book1 = new Book("Kitap A", 300, "Yazar A", "2021-01-01");
        Book book2 = new Book("Kitap B", 250, "Yazar B", "2020-05-15");
        Book book3 = new Book("Kitap C", 400, "Yazar C", "2019-10-20");
        Book book4 = new Book("Kitap D", 200, "Yazar D", "2022-03-10");
        Book book5 = new Book("Kitap E", 350, "Yazar E", "2018-12-05");

        bookSetByName.add(book1);
        bookSetByName.add(book2);
        bookSetByName.add(book3);
        bookSetByName.add(book4);
        bookSetByName.add(book5);

        bookSetByPageCount.add(book1);
        bookSetByPageCount.add(book2);
        bookSetByPageCount.add(book3);
        bookSetByPageCount.add(book4);
        bookSetByPageCount.add(book5);

        // İsim sırasına göre kitapları yazdırma
        System.out.println("Kitaplar isme göre sıralı:");
        for (Book book : bookSetByName) {
            System.out.println(book);
        }

        // Sayfa sayısına göre kitapları yazdırma
        System.out.println("\nKitaplar sayfa sayısına göre sıralı:");
        for (Book book : bookSetByPageCount) {
            System.out.println(book);
        }
    }
}