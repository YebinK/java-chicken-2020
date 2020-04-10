package view;

import domain.Menu;
import domain.Table;
import domain.discount.MenuSize;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_ORDERED = "└ \\ ┘";

    public static void printCommandList() {
        System.out.println("## 메인 화면");
        System.out.println("1 - 주문하기");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLineWithTablePayment(BOTTOM_LINE, tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printOrderedMenus(final Map<Menu, MenuSize> menus) {
        System.out.println("메뉴  \t수량 \t금액");
        for (Map.Entry<Menu, MenuSize> entry : menus.entrySet()) {
            String menuName = entry.getKey().getName();
            int menuCount = entry.getValue().get();
            int price = entry.getKey().getPrice() * menuCount;
            System.out.println(menuName + "\t" + menuCount + "\t" + price);
        }
    }

    private static void printLine(final String line, final int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printLineWithTablePayment(final String line, final List<Table> tables) {
        for (Table table : tables) {
            if (table.needToPay()) {
                System.out.print(BOTTOM_LINE_ORDERED);
                continue;
            }
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printPayAmount(double payAmount) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(payAmount + "원");
    }
}
