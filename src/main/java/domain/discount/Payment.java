package domain.discount;

public enum Payment {
    CARD(1),
    CASH(0.95);

    private final double discountRate;

    Payment(double discountRate) {
        this.discountRate = discountRate;
    }

    public double discount(int payAmount) {
        return this.discountRate * payAmount;
    }
}
