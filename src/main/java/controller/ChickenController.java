package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class ChickenController {

    private final List<Table> tables = TableRepository.tables();
    private final List<Menu> menus = MenuRepository.menus();

    public void run() {
        OutputView.printCommandList();
        int whatToDo = InputView.inputCommand();

        while (whatToDo != 3) {
            OutputView.printTables(tables);

            final int tableNumber = InputView.inputTableNumber();

            OutputView.printMenus(menus);
        }
    }
}
