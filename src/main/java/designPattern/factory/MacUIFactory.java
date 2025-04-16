package designPattern.factory;

import designPattern.factory.components.button.Button;
import designPattern.factory.components.button.MacButton;
import designPattern.factory.components.menu.MacMenu;
import designPattern.factory.components.menu.Menu;

public class MacUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Menu createMenu() {
        return new MacMenu();
    }
}
