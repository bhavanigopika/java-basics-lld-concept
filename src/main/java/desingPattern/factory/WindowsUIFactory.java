package desingPattern.factory;

import desingPattern.factory.components.button.Button;
import desingPattern.factory.components.button.WindowsButton;
import desingPattern.factory.components.menu.Menu;
import desingPattern.factory.components.menu.WindowsMenu;

public class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }
}
