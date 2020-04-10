package controller;

import domain.*;
import domain.discount.DiscountMachine;
import domain.discount.Payment;
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
            if (command.equals(Command.ORDER)) {
                order();
            }
            if (command.equals(Command.PAY)) {
                pay();
            }
            OutputView.printCommandList();
            command = Command.of(InputView.inputCommand());
        }
    }

    public void order() {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        Table table = TableRepository.find(tableNumber);
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
        Menu menu = MenuRepository.find(menuNumber);
        int menuCount = InputView.inputMenuCount();
        table.add(menu, menuCount);
    }

    public void pay() {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        Table table = TableRepository.find(tableNumber);
        if (!table.needToPay()) {
            throw new IllegalArgumentException("결제할 항목이 없습니다.");
        }
        OutputView.printOrderedMenus(table.getMenus().get());
        Payment payment = Payment.of(InputView.inputPayment(tableNumber));
        double payAmount = DiscountMachine.calculate(table.getMenus(), payment);
        OutputView.printPayAmount(payAmount);
    }
}
