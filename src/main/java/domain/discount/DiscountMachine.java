package domain.discount;

import domain.menu.Menus;

public class DiscountMachine {

    public static int calculate(Menus menus, Payment payment) {
        int payAmount = menus.calculate();
        return payment.discount(payAmount);
    }
}
