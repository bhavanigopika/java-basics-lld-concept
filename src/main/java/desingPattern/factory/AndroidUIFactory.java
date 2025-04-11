package desingPattern.factory;

import desingPattern.factory.components.button.AndroidButton;
import desingPattern.factory.components.button.Button;
import desingPattern.factory.components.menu.AndroidMenu;
import desingPattern.factory.components.menu.Menu;

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
