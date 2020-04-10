package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private static final int MAX_MENU_SIZE = 99;

    private final int number;
    private final Map<Menu, Integer> menus;

    public Table(final int number) {
        this.number = number;
        this.menus = new HashMap<>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void add(Menu menu, int menuSize) {
        if (!isOrderable(menu, menuSize)) {
            throw new IllegalArgumentException("한 메뉴 당 최대 99개 주문 가능합니다.");
        }
        this.menus.put(menu, menuSize);
    }

    public boolean isOrderable(Menu menu, int menuSize) {
        return !(menus.containsKey(menu) && menus.get(menu) + menuSize > MAX_MENU_SIZE);
    }

    public double calculate() {
        int payAmount = 0;
        for (Map.Entry<Menu, Integer> entry : menus.entrySet()) {
            payAmount = entry.getKey().getPrice() * entry.getValue();
        }

        return payAmount;
    }

    public boolean needToPay() {
        return !menus.isEmpty();
    }


}
