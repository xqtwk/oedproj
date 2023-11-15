package factory;

import strategy.FineCalculationStrategy;

public abstract class Member {
    public abstract void receiveNotification(String message);
    private FineCalculationStrategy fineCalculationStrategy;

    // Method to set the fine calculation strategy
    public void setFineCalculationStrategy(FineCalculationStrategy fineCalculationStrategy) {
        this.fineCalculationStrategy = fineCalculationStrategy;
    }

    // You might also want a method to calculate fine
    public double calculateFine(int daysLate) {
        if (fineCalculationStrategy != null) {
            return fineCalculationStrategy.calculateFine(daysLate);
        }
        throw new IllegalStateException("Fine calculation strategy not set");
    }
}

