package fr.eni.project.taskflow.dal;

import java.util.List;
import java.util.UUID;

import fr.eni.project.taskflow.bo.Task;

public interface TaskDAO {
    void create(Task task);

    List<Task> findAllTasks(String reference);

    void updateContent(UUID id, String newContent);

    void toggleCompletion(UUID id);

    void delete(UUID id);
}
