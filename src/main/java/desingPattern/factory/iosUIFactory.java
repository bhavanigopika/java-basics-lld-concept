package desingPattern.factory;

import desingPattern.factory.components.button.Button;
import desingPattern.factory.components.button.iosButton;
import desingPattern.factory.components.menu.Menu;
import desingPattern.factory.components.menu.iosMenu;

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
