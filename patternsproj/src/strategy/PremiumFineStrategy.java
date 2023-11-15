package strategy;

public class PremiumFineStrategy implements FineCalculationStrategy {
    @Override
    public double calculateFine(int daysOverdue) {
        return daysOverdue * 0.5; // Premium nariai turi moketi maziau
    }
}
