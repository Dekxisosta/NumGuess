package common.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuItem {
    private final String label;
    private final String systemNotification;
    private final List<MenuItem> menuOptions;

    public Menu(String label, String systemNotification, List<MenuItem> menuOptions) {
        this.label = label;
        this.systemNotification = systemNotification;
        this.menuOptions = new ArrayList<>(menuOptions);
    }

    public MenuItem getMenuItem(int index) {
        return menuOptions.get(index);
    }

    public void addMenuItem(MenuItem item) {
        menuOptions.add(item);
    }

    public void removeMenuItem(int index) {
        menuOptions.remove(index);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getSystemNotification() {
        return systemNotification;
    }

    @Override
    public MenuTransition execute() {
        return MenuTransition.openSubmenu(this);
    }

    public String[] getOptionNames() {
        String[] options = new String[menuOptions.size()];
        for (int i = 0; i < menuOptions.size(); i++) {
            options[i] = menuOptions.get(i).getLabel();
        }
        return options;
    }

    public int size() {
        return menuOptions.size();
    }
}
