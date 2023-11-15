package command;

import builder.Book;

public class BorrowBookCommand implements Command {
    private Library library;
    private Book book;

    public BorrowBookCommand(Library library, Book book) {
        this.library = library;
        this.book = book;
    }

    @Override
    public void execute() {
        library.borrowBook(book);
    }
}
