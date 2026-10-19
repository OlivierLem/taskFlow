package fr.eni.project.taskflow.dal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import fr.eni.project.taskflow.bo.Todolist;

public interface TodolistDAO {
    void create(Todolist todolist);

    Todolist findTodolist(String reference);

    List<Todolist> findAllTodolists(UUID userId);

    void rename(String reference, String newTitle);

    void updateDeadline(String reference, LocalDateTime newDeadline);

    void delete(String reference);
}
