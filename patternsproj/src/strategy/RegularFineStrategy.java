package strategy;

public class RegularFineStrategy implements FineCalculationStrategy {
    @Override
    public double calculateFine(int daysOverdue) {
        return daysOverdue * 1.0;
    }
}
