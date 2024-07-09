package factory;

import factory.components.button.AndroidButton;
import factory.components.button.Button;
import factory.components.dropdown.AndroidDropDown;
import factory.components.dropdown.DropDown;
import factory.components.menu.AndroidMenu;
import factory.components.menu.Menu;

public class AndroidFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }

    @Override
    public DropDown createDropDown() {
        return new AndroidDropDown();
    }
}
