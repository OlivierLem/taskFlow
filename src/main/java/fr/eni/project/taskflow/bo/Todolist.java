package fr.eni.project.taskflow.bo;

import java.time.LocalDateTime;
import java.util.UUID;

public class Todolist {
    private UUID id;
    private String title;
    private LocalDateTime deadline;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
    private String reference;
    private User user;

    public Todolist() {}

    public Todolist(UUID id, String title, LocalDateTime deadline, LocalDateTime dateCreate, LocalDateTime dateUpdate,
            String reference, User user) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
        this.reference = reference;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Todolist [id=" + id + ", title=" + title + ", deadline=" + deadline + ", dateCreate=" + dateCreate
                + ", dateUpdate=" + dateUpdate + ", reference=" + reference + ", user=" + user + "]";
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

        Todolist other = (Todolist) obj;
        return id != null && id.equals(other.id);
    }
}
