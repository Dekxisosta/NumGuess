package menu.api;

public class MenuTransition {


    public enum Type {
        MAIN_MENU,
        SUBMENU,
        EXIT;
    }

    private Type type;
    private Menu submenu;

    public MenuTransition(Type type, Menu submenu){
        this.type = type;
        this.submenu = submenu;
    }
    public Type getType() {
        return type;
    }
    public static MenuTransition exit() {
        return new MenuTransition(Type.EXIT, null);
    }

    public static MenuTransition mainMenu() {
        return new MenuTransition(Type.MAIN_MENU, null);
    }

    public static MenuTransition openSubmenu(Menu submenu) {
        return new MenuTransition(Type.SUBMENU, submenu);
    }
    public Menu getSubmenu() { return submenu; }

}
