import adapter.MemberSubscriberAdapter;
import builder.Book;
import command.BorrowBookCommand;
import command.Command;
import command.Library;
import composite.BookCollection;
import composite.BookComponent;
import composite.SingleBook;
import decorator.DigitalAccessBook;
import decorator.IBook;
import factory.Member;
import factory.PremiumMemberFactory;
import factory.RegularMemberFactory;
import observer.BookAvailabilityNotifier;
import proxy.LibraryManager;
import proxy.LibraryManagerProxy;
import strategy.PremiumFineStrategy;
import strategy.RegularFineStrategy;

public class Main {
    public static void main(String[] args) {

        // Builder
        Book book = new Book.Builder()
                .setTitle("Effective Java")
                .setAuthor("Olga Korolkova")
                .build();

        // Decorator
        IBook digitalBook = new DigitalAccessBook(book);

        // Factory
        PremiumMemberFactory premiumMemberFactory = new PremiumMemberFactory();
        RegularMemberFactory regularMemberFactory = new RegularMemberFactory();
        Member regularMember = regularMemberFactory.createMember();
        Member premiumMember = premiumMemberFactory.createMember();

        // Strategy: Apply fine calculation strategy if Member class supports it
         regularMember.setFineCalculationStrategy(new RegularFineStrategy());
         premiumMember.setFineCalculationStrategy(new PremiumFineStrategy());

        // Observer
        BookAvailabilityNotifier notifier = new BookAvailabilityNotifier();
        notifier.subscribe(new MemberSubscriberAdapter(regularMember));
        notifier.subscribe(new MemberSubscriberAdapter(premiumMember));

        notifier.notifySubscribers("Book is available");


        BookComponent singleBook = new SingleBook("Design Patterns");
        BookComponent bookCollection = new BookCollection();
        bookCollection.addItem(singleBook);

        // Command
        Library library = new Library();
        Command borrowBookCommand = new BorrowBookCommand(library, book);
        borrowBookCommand.execute();
        boolean isAdminUser = true;
        // Proxy
        LibraryManager proxyManager = new LibraryManagerProxy(isAdminUser);
        proxyManager.performOperation();

        System.out.println("Book Description: " + digitalBook.getDescription());
    }
}