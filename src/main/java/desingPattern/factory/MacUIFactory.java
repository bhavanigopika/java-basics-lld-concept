package desingPattern.factory;

import desingPattern.factory.components.button.Button;
import desingPattern.factory.components.button.MacButton;
import desingPattern.factory.components.menu.MacMenu;
import desingPattern.factory.components.menu.Menu;

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
