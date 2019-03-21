package be.helha.todoList.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToDoList {
    protected ArrayList<ToDoItem> items;

    public ToDoList() {
        this.items = new ArrayList<>();
    }

    public void addItem(String desc){
        checkDoubleItem(desc);
        items.add(new ToDoItem(desc));
    }

    public void removeItem(ToDoItem item){
        items.remove(item);
    }

    private void checkDoubleItem(String description){
        for(ToDoItem item: items){
            if(item.hasDescription(description)) throw new DuplicateException();
        }
    }

    public List<ToDoItem> getItems(){
        return Collections.unmodifiableList(items);
    }

}
