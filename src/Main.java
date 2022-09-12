import java.util.ArrayList;
import java.util.Map;

public class Main{

    public static void main(String[] args) {
        Book book1 = new Book("General Physics", 2001, "University Press", 4, "Emeka");
        Book book2 = new Book("General Maths", 2008, "University Press", 5, "Obi");
        Book book3 = new Book("General Biology", 2010, "University Press", 5, "Ndu");

        Librarian librarian = new Librarian("Phil", 1, "Male", Role.LIBRARIAN);


        Teacher teacher1 = new Teacher("Eden", 1, "Male", Role.TEACHER);
        Teacher teacher2 = new Teacher("Neville", 2, "Male", Role.TEACHER);

        Student student1 = new Student("Kings", 1, "Male", Role.SENIOR_STUDENT);
        Student student2 = new Student("Kate", 2, "Female", Role.JUNIOR_STUDENT);

        LibraryUtils.addBook(book1,librarian);
        LibraryUtils.addBook(book2,librarian);
        LibraryUtils.addBook(book3,librarian);

        System.out.println(LibraryUtils.availableBooks.size());//checking the books array size after book addition
        System.out.println(LibraryUtils.availableBooks.toString());

        System.out.println(LibraryUtils.availableBooks.toString());
        System.out.println("Adding user to the queue==========================");

        LibraryUtils.addUserToQueue(teacher1,book3);
        LibraryUtils.addUserToQueue(student2,book3);
        LibraryUtils.addUserToQueue(student1,book3);

        System.out.println("Printing the waiting queue--------------------------");
        System.out.println(LibraryUtils.waitingQueue.toString());

        System.out.println("Approving books based on order of priority -->");
        LibraryUtils.approveBook(librarian,book3);
        System.out.println(LibraryUtils.waitingQueue.toString());// Confirming that the teacher was prioritized first
        LibraryUtils.approveBook(librarian,book3);
        System.out.println(LibraryUtils.waitingQueue.toString());// Confirming that the senior student was prioritized after the teacher
        LibraryUtils.approveBook(librarian,book3);

        System.out.println("Checking the borrowed books array for the teacher and confirming available number of books left");
        System.out.println(teacher1.getBorrowedBooks().toString());
        System.out.println(LibraryUtils.availableBooks.toString());

        System.out.println("Attempting to borrow another book without returning the borrowed one");
        LibraryUtils.addUserToQueue(teacher1,book3);

        System.out.println("Returning the borrowed book.....");
        LibraryUtils.returnBook(teacher1,book3);

        // Confirming that it is reflected in various arrays
        System.out.println(LibraryUtils.borrowerList.toString());
        System.out.println(LibraryUtils.availableBooks.toString());
        System.out.println(teacher1.getBorrowedBooks().toString());

        System.out.println("Attempting to borrow another book after returning the borrowed one");
        LibraryUtils.addUserToQueue(teacher1,book3);

        Book book4 = new Book("A midsummer night's dream",1979,"London Press",0,"William Shakespeare");
        LibraryUtils.addBook(book4,librarian);
//        LibraryUtils.addUserToQueue(teacher2,book4);
//        System.out.println(LibraryUtils.availableBooks.toString());
    }

}