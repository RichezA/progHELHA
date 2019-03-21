package be.helha.todoList.views;

import be.helha.todoList.models.ToDoItem;

public interface MainViewInteraction {
    void removeItem(ToDoItem item);
    void addItem(String desc);
    void checkedBox(ToDoItem item);
}
