public class Main {
    public static void main(String[] args) {
        BankFacade bankWindow = new BankFacade();

        bankWindow.processLoan("John Doe", 5000.0);

        bankWindow.payTaxes("Jane Smith", 1000.0);

        bankWindow.handleCashOperation("Alice Johnson", 2000.0);
    }
}
