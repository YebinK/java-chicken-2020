package domain.discount;

import java.util.Arrays;

public enum Payment {
    CARD(1, 1),
    CASH(2, 0.95);

    private final int paymentNumber;
    private final double discountRate;

    Payment(int paymentNumber, double discountRate) {
        this.paymentNumber = paymentNumber;
        this.discountRate = discountRate;
    }

    public static Payment of(int input) {
        return Arrays.stream(values())
                .filter(payment -> payment.paymentNumber == input)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 결제방식입니다."));
    }

    public int discount(int payAmount) {
        return (int) (this.discountRate * payAmount);
    }
}
