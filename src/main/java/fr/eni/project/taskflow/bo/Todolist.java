package fr.eni.project.taskflow.bo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Todolist {
    private UUID id;
    private String title;
    private LocalDateTime deadline;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
    private String reference;
    private UUID userId;


    public Todolist() {}

    public Todolist(UUID id, String title, LocalDateTime deadline, LocalDateTime dateCreate, LocalDateTime dateUpdate,
            String reference, UUID userId) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
        this.reference = reference;
        this.userId = userId;
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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    

    @Override
    public String toString() {
        return "Todolist [id=" + id + ", title=" + title + ", deadline=" + deadline + ", dateCreate=" + dateCreate
                + ", dateUpdate=" + dateUpdate + ", reference=" + reference + ", userId=" + userId + "]";
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
