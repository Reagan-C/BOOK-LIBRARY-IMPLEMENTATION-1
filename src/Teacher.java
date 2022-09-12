import java.util.ArrayList;

public class Teacher extends AbstractUserEntity {
    private ArrayList<String> borrowedBooks;

    public Teacher(String name, int id, String gender, Role role) {
        super(name, id, gender, role);
        borrowedBooks = new ArrayList<>();
    }

    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }
}

