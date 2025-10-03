package menu.api;
import java.util.function.Supplier;

public class ActionItem implements MenuItem {
    private String label;
    private String systemNotification;
    private Supplier<MenuTransition> action;

    public ActionItem(String label, String systemNotification, Supplier<MenuTransition> action) {
        this.label = label;
        this.systemNotification = systemNotification;
        this.action = action;
    }

    @Override
    public String getLabel(){return this.label;}

    @Override
    public String getSystemNotification(){return this.systemNotification;}

    @Override
    public MenuTransition execute(){return action.get();}
}
