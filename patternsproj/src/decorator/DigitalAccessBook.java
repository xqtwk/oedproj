package decorator;

public class DigitalAccessBook extends BookDecorator {
    public DigitalAccessBook(IBook book) {
        super(book);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Digital Access";
    }

    public void accessDigitalContent() {
        System.out.println("Accessing digital content for the book: " + book.getDescription());
    }

    public void downloadContent() {
        System.out.println("Downloading content for the book: " + book.getDescription());
    }
}
