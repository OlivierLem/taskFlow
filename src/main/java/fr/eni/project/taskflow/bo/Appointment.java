package fr.eni.project.taskflow.bo;

import java.time.LocalDateTime;
import java.util.UUID;

public class Appointment {
    private UUID id;
    private String title;
    private String description;
    private String adress;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
    private String reference;
    private User user;

    public Appointment() {}

    public Appointment(UUID id, String title, String description, String adress, LocalDateTime dateStart,
            LocalDateTime dateEnd, LocalDateTime dateCreate, LocalDateTime dateUpdate, String reference, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.adress = adress;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
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

        Appointment other = (Appointment) obj;
        return id != null && id.equals(other.id);
    }
}
