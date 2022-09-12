import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {
   private String name;
   private String address;

   private static Librarian librarian;
   public static Map<String, Book> books ;

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.books = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getNameOfLibrarian() {
        return librarian.getName();
    }

    public static void setBooks(Map<String, Book> books, Librarian obj) {
        if (obj.getName().equalsIgnoreCase(librarian.getName())) {
            Library.books = books;
        }
    }

    public static Map<String, Book> getBooks() {
        return books;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public void removeLibrarian(Librarian librarian) {
        this.librarian = null;
    }
    @Override
    public String toString() {
        return "Library{" +
                "Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", Name of Librarian='" + librarian + '\'' +
                ", Books=" + books +
                '}';
    }

}
