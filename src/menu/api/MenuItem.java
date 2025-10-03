package menu.api;

public interface MenuItem {
    String getLabel();
    String getSystemNotification();
    MenuTransition execute();
}
