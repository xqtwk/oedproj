package composite;

public class SingleBook implements BookComponent {
    private String title;

    public SingleBook(String title) {
        this.title = title;
    }

    @Override
    public void displayInfo() {
        System.out.println("Single Book: " + title);
    }

    @Override
    public void addItem(BookComponent singleBook) {

    }
}
