package fr.eni.project.taskflow.bo;

import java.util.UUID;

public class Task {
    private UUID id;
    private String content;
    private boolean isCompleted;
    private Todolist todolist;

    public Task() {}

    public Task(UUID id, String content, boolean isCompleted, Todolist todolist) {
        this.id = id;
        this.content = content;
        this.isCompleted = isCompleted;
        this.todolist = todolist;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Todolist getTodolist() {
        return todolist;
    }

    public void setTodolist(Todolist todolist) {
        this.todolist = todolist;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", content=" + content + ", isCompleted=" + isCompleted + ", todolist=" + todolist
                + "]";
    }

    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Task other = (Task) obj;
        return id != null && id.equals(other.id);
    }
}
