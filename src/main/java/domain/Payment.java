package domain;

public enum Payment {
    CARD(1),
    CASH(0.95);

    private final double discountRate;

    Payment(double discountRate) {
        this.discountRate = discountRate;
    }

    public double apply(int payAmount) {
        return this.discountRate * payAmount;
    }
}
