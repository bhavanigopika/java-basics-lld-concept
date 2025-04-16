package designPattern.factory;

import designPattern.factory.components.button.Button;
import designPattern.factory.components.button.WindowsButton;
import designPattern.factory.components.menu.Menu;
import designPattern.factory.components.menu.WindowsMenu;

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
