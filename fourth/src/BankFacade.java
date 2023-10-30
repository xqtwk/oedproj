public class BankFacade {
    private LoanService loanService;
    private TaxService taxService;
    private CashService cashService;

    public BankFacade() {
        this.loanService = new LoanService();
        this.taxService = new TaxService();
        this.cashService = new CashService();
    }

    public void processLoan(String customerName, double loanAmount) {
        loanService.processLoan(customerName, loanAmount);
    }

    public void payTaxes(String customerName, double taxAmount) {
        taxService.payTaxes(customerName, taxAmount);
    }

    public void handleCashOperation(String customerName, double cashAmount) {
        cashService.handleCashOperation(customerName, cashAmount);
    }
}
