package factory;

import factory.components.button.Button;
import factory.components.button.iOSButton;
import factory.components.dropdown.DropDown;
import factory.components.dropdown.iOSDropDown;
import factory.components.menu.Menu;
import factory.components.menu.iOSMenu;

public class iOSFactory  implements UIFactory {
    @Override
    public Button createButton() {
        return new iOSButton();
    }

    @Override
    public Menu createMenu() {
        return new iOSMenu();
    }

    @Override
    public DropDown createDropDown() {
        return new iOSDropDown();
    }
}
