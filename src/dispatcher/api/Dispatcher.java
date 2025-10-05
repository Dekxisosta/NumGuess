package dispatcher.api;

import menu.api.Menu;
import menu.api.MenuTransition;

public interface Dispatcher {
    void greet();
    void goodbye();
    boolean promptTermination();
    MenuTransition execute(Menu menu);
}
