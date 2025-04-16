package designPattern.factory;

import designPattern.factory.components.button.AndroidButton;
import designPattern.factory.components.button.Button;
import designPattern.factory.components.menu.AndroidMenu;
import designPattern.factory.components.menu.Menu;

public class AndroidUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }
}
