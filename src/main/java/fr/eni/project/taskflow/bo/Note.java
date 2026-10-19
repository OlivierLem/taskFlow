package fr.eni.project.taskflow.bo;

import java.time.LocalDateTime;
import java.util.UUID;

public class Note {
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
    private String reference;
    private UUID userId;

    public Note() {}

    public Note(UUID id, String title, String content, LocalDateTime dateCreate, LocalDateTime dateUpdate,
            String reference, UUID userId) {
        this.id = id;
        this.title = title;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Note [id=" + id + ", title=" + title + ", content=" + content + ", dateCreate=" + dateCreate
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

        Note other = (Note) obj;
        return id != null && id.equals(other.id);
    }
}
