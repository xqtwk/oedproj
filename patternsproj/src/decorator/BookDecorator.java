package decorator;

import builder.Book;

public abstract class BookDecorator implements IBook {
    protected IBook book;

    public BookDecorator(IBook book) {
        this.book = book;
    }

    @Override
    public String getDescription() {
        return book.getDescription();
    }

}
