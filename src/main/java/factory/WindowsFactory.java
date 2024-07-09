package factory;

import factory.components.button.Button;
import factory.components.button.WindowsButton;
import factory.components.dropdown.DropDown;
import factory.components.dropdown.WindowsDropDown;
import factory.components.menu.Menu;
import factory.components.menu.WindowsMenu;

public class WindowsFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }

    @Override
    public DropDown createDropDown() {
        return new WindowsDropDown();
    }
}
