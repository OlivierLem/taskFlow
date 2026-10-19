package fr.eni.project.taskflow.dal;

import java.util.List;
import java.util.UUID;

import fr.eni.project.taskflow.bo.Appointment;

public interface AppointmentDAO {
    void create(Appointment appointment);

    Appointment findAppointment(String reference);

    List<Appointment> findAllAppointments(UUID userId);

    void rename(String reference, String newTitle);

    void update(Appointment appointment);

    void delete(String reference);
}
