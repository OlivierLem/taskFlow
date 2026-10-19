package fr.eni.project.taskflow.dal;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.eni.project.taskflow.bo.Task;

public class TaskDAOImpl implements TaskDAO{
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public TaskDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Task task) {
        String sqlInsert = "INSERT INTO Task "
            + "(content, isCompleted, Todolist_id) "
            + "VALUES (:content, :isCompleted, :todolist_id)";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("content", task.getContent())
            .addValue("isCompleted", task.isCompleted())
            .addValue("todolist_id", task.getTodolist());
        jdbcTemplate.update(sqlInsert, params);
    }

    @Override
    public List<Task> findAllTasks(String reference) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllTasks'");
    }

    @Override
    public void updateContent(UUID id, String newContent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateContent'");
    }

    @Override
    public void toggleCompletion(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toggleCompletion'");
    }

    @Override
    public void delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
