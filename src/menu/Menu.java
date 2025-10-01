package menu;

public class Menu {
    private MenuOption[] menuOptions;

    public Menu(MenuOption[] menuOptions) {
        this.menuOptions = menuOptions;
    }

    public String[] getOptionNames() {
        String[] options = new String [menuOptions.length];
        int size=0;
        for(MenuOption menuOption: menuOptions) {
            options[size++] = menuOption.getLabel();
        }
        return options;
    }
    public MenuOption get(int index){
        return menuOptions[index];
    }
}
