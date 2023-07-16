import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Kitap 1", 150, "Yazar 1", "2021-01-01"));
        books.add(new Book("Kitap 2", 200, "Yazar 2", "2020-05-15"));
        books.add(new Book("Kitap 3", 180, "Yazar 3", "2019-10-30"));
        books.add(new Book("Kitap 4", 120, "Yazar 4", "2018-03-20"));
        books.add(new Book("Kitap 5", 250, "Yazar 5", "2022-07-10"));
        books.add(new Book("Kitap 6", 90, "Yazar 6", "2017-12-05"));
        books.add(new Book("Kitap 7", 300, "Yazar 7", "2016-09-22"));
        books.add(new Book("Kitap 8", 170, "Yazar 8", "2023-04-17"));
        books.add(new Book("Kitap 9", 230, "Yazar 9", "2015-11-12"));
        books.add(new Book("Kitap 10", 140, "Yazar 10", "2014-06-25"));

        // Kitap isminin karşısında yazar ismi olacak şekilde Map oluşturulması
        Map<String, String> bookMap = books.stream()
                .collect(Collectors.toMap(Book::getName, Book::getAuthor));

        System.out.println("Kitaplar ve Yazarlar:");
        bookMap.forEach((kitap, yazar) -> System.out.println(kitap + " -> " + yazar));

        // Sayfa sayısı 100'den fazla olan kitapları filtreleme
        List<Book> filteredBooks = books.stream()
                .filter(book -> book.getPageCount() > 100)
                .collect(Collectors.toList());

        System.out.println("\nSayfa sayısı 100'den fazla olan kitaplar:");
        filteredBooks.forEach(book -> System.out.println(book.getName() + " -> " + book.getAuthor()));
    }
}