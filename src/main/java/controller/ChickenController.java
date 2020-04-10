package controller;

import domain.discount.DiscountMachine;
import domain.discount.Payment;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class ChickenController {

    private final List<Table> tables = TableRepository.tables();
    private final List<Menu> menus = MenuRepository.menus();

    public void run() {
        OutputView.printCommandList();
        Command command = Command.of(InputView.inputCommand());

        while (!command.equals(Command.EXIT)) {
            switch (command) {
                case ORDER:
                    order();
                    break;
                case PAY:
                    pay();
            }
            OutputView.printCommandList();
            command = Command.of(InputView.inputCommand());
        }
    }

    public void order() {
        int tableNumber = selectTable();
        Table table = TableRepository.find(tableNumber);

        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();

        Menu menu = MenuRepository.find(menuNumber);
        int menuCount = InputView.inputMenuCount();
        table.add(menu, menuCount);
    }

    public void pay() {
        int tableNumber = selectTable();
        Table table = TableRepository.find(tableNumber);
        table.validatePayment();

        OutputView.printOrderedMenus(table.getMenus());
        Payment payment = Payment.of(InputView.inputPayment(tableNumber));

        int payAmount = DiscountMachine.calculate(table.getMenus(), payment);
        OutputView.printPayAmount(payAmount);
    }

    private int selectTable() {
        OutputView.printTables(tables);
        return InputView.inputTableNumber();
    }
}
