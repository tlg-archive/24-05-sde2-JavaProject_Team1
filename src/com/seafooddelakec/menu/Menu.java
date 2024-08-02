package com.seafooddelakec.menu;

import java.util.ArrayList;
import java.util.List;

import static com.apps.util.Console.blankLines;
import static com.apps.util.Console.pause;

public class Menu {
    private final List<MenuItem> menuItems;
    private final List<MenuItem> orderedItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.orderedItems = new ArrayList<>();
    }

    public void displayMenu() {
        displayMenuSection("COMBOS", MenuItem.Type.COMBO);
        System.out.println();
        displayMenuSection("DRINKS", MenuItem.Type.DRINK);
    }

    private void displayMenuSection(String sectionTitle, MenuItem.Type type) {
        String border = "+=====+==========+======================================+";
        String titleFormat = "| %-49s |";
        String itemFormat = "| %-3d | $%-7.2f | %-34s |";

        displayAnimatedString(border);
        displayAnimatedString(String.format(titleFormat, sectionTitle));
        displayAnimatedString(border);
        displayAnimatedString("| ID  | Price    | Description                          |");
        displayAnimatedString(border);

        for (MenuItem item : menuItems) {
            if (item.type() == type) {
                String description = item.description();
                if (description.length() > 34) {
                    description = description.substring(0, 31) + "...";
                }
                String formattedItem = String.format(itemFormat,
                        item.id(), item.price(), description);
                displayAnimatedString(formattedItem);
            }
        }
        displayAnimatedString(border);
    }

    private void displayAnimatedString(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            pause(2);
        }
        System.out.println();
    }

    public MenuItem getItemById(int id) {
        for (MenuItem item : menuItems) {
            if (item.id() == id) {
                return item;
            }
        }
        return null;
    }

    public void addOrderedItem(MenuItem item) {
        orderedItems.add(item);
    }

    public List<MenuItem> getOrderedItems() {
        return new ArrayList<>(orderedItems);
    }
}