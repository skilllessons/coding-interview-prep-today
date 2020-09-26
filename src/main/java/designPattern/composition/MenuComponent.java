package main.java.designPattern.composition;

import java.util.ArrayList;
import java.util.List;

abstract class MenuComponent {
    String text;

    MenuComponent(String text) {
        this.text = text;
    }
}

class MenuItem extends MenuComponent {
    MenuItem(String text) {
        super(text);
    }
}

class Menu extends MenuComponent {
    List<MenuComponent> components = new ArrayList<>();

    Menu(String text) {
        super(text);
    }
}

class Test {

    public static void main(String[] args) {
        Menu file = new Menu("file");
        file.components.add(new MenuItem("OPen"));
        file.components.add(new MenuItem("Save"));
        file.components.add(new MenuItem("Exit"));

        Menu recentFile = new Menu("Recent");
        //recentFile.components
        file.components.add(recentFile);

    }
}
