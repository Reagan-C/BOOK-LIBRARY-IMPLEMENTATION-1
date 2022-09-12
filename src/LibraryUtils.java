import java.util.*;

public  class LibraryUtils<T> {

    //  A collection to hold all books in the library
    public static Map<String, Book> availableBooks = new HashMap<>();
    public static Queue<AbstractUserEntity> waitingQueue = new PriorityQueue<>(new UserComparator());
    public static final Map<AbstractUserEntity, String> borrowerList = new HashMap<>();
    public static <T>void addBook(final Book book, T t) {
        if (t instanceof Librarian) {
            final String bookName = book.getName();
            // If  map contains book, update copies of book
            if (availableBooks.containsKey(bookName)) {
                Book retrievedBook = availableBooks.get(bookName);
                int noOfCopies = retrievedBook.getNoOfCopies();
                retrievedBook.setNoOfCopies(noOfCopies + book.getNoOfCopies());
                availableBooks.put(bookName, retrievedBook);
                System.out.println(bookName + " exists in the library, the number of available copies have" +
                        " been updated from " + noOfCopies + " to " + retrievedBook.getNoOfCopies() );
            } else {  //  Add book to map
                availableBooks.put(bookName, book);
                System.out.println("Book successfully added to library");
            }
        } else {
            System.out.println("Only the Librarian can add a book to the library");
        }
    }

    public static final boolean addUserToQueue(final AbstractUserEntity user, final Book book) {
        if (book == null || (!availableBooks.containsKey(book.getName()))) {
            System.out.println("Invalid book type");
            return false;
        }
        if (user instanceof Librarian) {
            System.out.println("Only teachers and students are allowed to borrow books");
            return false;
        }
        if (waitingQueue.contains(user) || borrowerList.containsKey(user)){
            System.out.println( "Dear " + user.getName() + ", You can only borrow one book at a time");
            return false;
        }
        if (book.getNoOfCopies() < 1) {
            System.out.println("Book taken");
            return false;
        }

        waitingQueue.add(user);
        System.out.println("User has been added to the queue");
        return true;
    }

    public static <T>void returnBook(T user, Book book) {
        if (book == null ||user instanceof Librarian ) {
            System.out.println("Invalid entry type, please recheck");
        }

        if (borrowerList.containsKey(user) && borrowerList.containsValue(book.getName())) {
        if (user instanceof Teacher) {
            Teacher teacher = (Teacher)user;
            teacher.getBorrowedBooks().remove(book.getName());
        }

        if (user instanceof Student) {
            Student student = (Student)user;
            student.getBorrowedBooks().remove(book.getName());
        }

            Book book1 = availableBooks.get(book.getName());
            book1.setNoOfCopies(book1.getNoOfCopies() + 1);
            availableBooks.replace(book1.getName(), book1);
            borrowerList.remove(user,book.getName());
            System.out.println(book.getName() + " successfully returned by " + user);
        }
    }

    public static boolean approveBook (Librarian librarian, final Book book) {
        Book bookApproved = availableBooks.get(book.getName());
        int copiesOfBook = bookApproved.getNoOfCopies();
        if (copiesOfBook < 1) {
            System.out.println("There are no more copies of this book at the moment. Please come back when book is available");
            return false;
        }
        try {
            AbstractUserEntity user = waitingQueue.peek();
            waitingQueue.poll();
            if (user instanceof Teacher) {
                Teacher teacher = (Teacher) user;
                teacher.getBorrowedBooks().add(book.getName());
            }
            if (user instanceof Student) {
                Student student = (Student) user;
                student.getBorrowedBooks().add(book.getName());
            }
            availableBooks.replace(book.getName(), bookApproved);
            borrowerList.put(user, book.getName());
            bookApproved.setNoOfCopies((bookApproved.getNoOfCopies()) - 1);
            System.out.println("Book successfully borrowed");
        } catch (NullPointerException e) {
            System.out.println("Book to be approved cannot be of null type");
        }
        return true;
    }
}