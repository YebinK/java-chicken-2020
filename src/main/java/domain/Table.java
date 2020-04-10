package domain;

public class Table {
    private final int number;
    private final Menus menus;

    public Table(final int number) {
        this.number = number;
        this.menus = new Menus();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void add(Menu menu, int menuSize) {
        if (!isOrderable(menu, menuSize)) {
            throw new IllegalArgumentException("한 메뉴 당 최대 99개 주문 가능합니다.");
        }
        this.menus.add(menu, menuSize);
    }

    public boolean isOrderable(Menu menu, int menuSize) {
        return menus.isOrderable(menu, menuSize);
    }

    public double calculate() {
        return menus.calculate();
    }

    public boolean needToPay() {
        return !menus.isEmpty();
    }
}
