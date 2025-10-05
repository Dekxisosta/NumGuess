package menu.api;

import java.util.List;
import java.util.function.Supplier;

public abstract class MenuFactory {
    public abstract Menu create();

    protected Menu menu(String label, String systemNotification, List<MenuItem> options){
        return new Menu(label, systemNotification, options);
    }

    protected ActionItem action(String label, String systemNotification, Supplier<MenuTransition> action){
        return new ActionItem(label, systemNotification, action);
    }
}
