package domain.menu;

import java.util.HashMap;
import java.util.Map;

public class Menus {
    private static final int MAX_MENU_SIZE = 99;

    private final Map<Menu, MenuSize> menus;

    public Menus() {
        this.menus = new HashMap<>();
    }

    public boolean isOrderable(Menu menu, int menuSize) {
        int orderedSize = 0;
        if (menus.containsKey(menu)) {
            orderedSize = menus.get(menu).get();
        }
        return orderedSize + menuSize < MAX_MENU_SIZE;
    }

    public void add(Menu menu, int menuSize) {
        menus.put(menu, new MenuSize(menuSize));
    }

    public int calculate() {
        int payAmount = 0;
        for (Map.Entry<Menu, MenuSize> entry : menus.entrySet()) {
            payAmount += sumAndDiscount(entry.getKey(), entry.getValue());
        }
        return payAmount;
    }

    public int sumAndDiscount(Menu menu, MenuSize menuSize) {
        int price = menu.getPrice() * menuSize.get();
        if (menu.isChicken()) {
            price -= menuSize.discount();
        }
        return price;
    }

    public boolean isEmpty() {
        return menus.isEmpty();
    }

    public Map<Menu, MenuSize> get() {
        return menus;
    }

}
