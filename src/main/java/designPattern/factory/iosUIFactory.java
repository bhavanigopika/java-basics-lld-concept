package designPattern.factory;

import designPattern.factory.components.button.Button;
import designPattern.factory.components.button.iosButton;
import designPattern.factory.components.menu.Menu;
import designPattern.factory.components.menu.iosMenu;

public class iosUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new iosButton();
    }

    @Override
    public Menu createMenu() {
        return new iosMenu();
    }
}
