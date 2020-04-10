package domain.discount;

import domain.Menu;
import domain.Menus;

import java.util.Map;

public class DiscountMachine {

    public static double calculate(Menus menus, Payment payment) {
        int payAmount = menus.calculate();

        payAmount -= discountMenuSize(menus);

        return payment.discount(payAmount);
    }

    private static double discountMenuSize(Menus menus) {
        int discountAmount = 0;
        Map<Menu, MenuSize> orderedMenu = menus.get();

        for (Map.Entry<Menu, MenuSize> entry : orderedMenu.entrySet()) {
            if (entry.getKey().isChicken()) {
                MenuSize menuSize = entry.getValue();
                discountAmount += menuSize.discount();
            }
        }
        return discountAmount;
    }
}
