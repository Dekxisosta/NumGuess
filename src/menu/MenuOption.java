package menu;
import java.util.function.Supplier;

public class MenuOption {
    private String label;
    private Supplier<MenuResult> action;

    public  MenuOption(String label, Supplier<MenuResult>  action) {
        this.label = label;
        this.action = action;
    }

    public String getLabel(){return this.label;}
    public MenuResult execute(){return action.get();}
}
