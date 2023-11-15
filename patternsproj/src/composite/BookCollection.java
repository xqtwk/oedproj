package composite;

import java.util.ArrayList;
import java.util.List;

public class BookCollection implements BookComponent {
    private List<BookComponent> books = new ArrayList<>();

    public void addBook(BookComponent book) {
        books.add(book);
    }
    @Override
    public void addItem(BookComponent bookComponent) {
        books.add(bookComponent); // ATTENTION
    }
    @Override
    public void displayInfo() {
        for (BookComponent book : books) {
            book.displayInfo();
        }
    }
}
