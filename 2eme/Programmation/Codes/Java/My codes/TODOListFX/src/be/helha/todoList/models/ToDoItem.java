package be.helha.todoList.models;

public class ToDoItem {
    // an Item in our list
    protected String description;
    protected boolean done;

    public ToDoItem(String desc) {
        if (!desc.trim().isEmpty()) {
            this.description = desc;
            this.done = false;
        } else
            throw new EmptyDescriptionException();

    }

    public String getDescription() {
        return this.description;
    }

    public boolean isDone() {
        return this.done;
    }

    public boolean hasDescription(String desc) {
        return this.description.equals(desc);
    }

    public void toggleDone() {
        done = !done;
    }
}
