package desingPattern.factory;

import desingPattern.factory.components.button.Button;
import desingPattern.factory.components.menu.Menu;

public interface UIFactory {
    //UI factory having factory methods
    Button createButton();
    Menu createMenu();
}
