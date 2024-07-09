package factory;

import factory.components.button.Button;
import factory.components.dropdown.DropDown;
import factory.components.menu.Menu;

public interface UIFactory {
    //interface, so only methods
    //let's take return type as void, actually return type is  Button, Menu, DropDown respectively...
    //so we create package Components and keep all Button, Menu, Dropdown inside this
    //Button, Menu, DropDown are all components and interface, now this will be the factory method
    Button createButton();
    Menu createMenu();
    DropDown createDropDown();
}
