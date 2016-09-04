package net.slomnicki.akademiakodu.w5d2p1.data;

import net.slomnicki.akademiakodu.w5d2p1.model.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class TodoDatabase {
    private static List<TodoItem> mItems;

    static {
        mItems = new ArrayList<>();
        mItems.add(new TodoItem("Kurs Java", false, null));
        mItems.add(new TodoItem("Rower", true, null));
        mItems.add(new TodoItem("Sprzątanie", false, "Kuchnia"));
    }

    public static List<TodoItem> getItems() {
        return mItems;
    }

    public static TodoItem getItem(int position) {
        return mItems.get(position);
    }

    public static void removeItem(int position) {
        mItems.remove(position);
    }

    public static void updateItem(int position, TodoItem todoItem) {
        mItems.set(position, todoItem);
    }

    public static void add(TodoItem item) {
        mItems.add(0, item);
    }
}
