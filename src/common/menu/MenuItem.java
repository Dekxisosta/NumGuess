package common.menu;

public interface MenuItem {
    String getLabel();
    String getSystemNotification();
    MenuTransition execute();
}
