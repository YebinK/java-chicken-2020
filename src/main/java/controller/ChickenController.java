package controller;

import domain.*;
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
        }
    }

    public void order() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);
    }

    public void pay() {
    }
}
