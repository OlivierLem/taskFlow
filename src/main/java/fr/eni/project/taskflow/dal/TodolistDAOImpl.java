package fr.eni.project.taskflow.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.eni.project.taskflow.bo.Todolist;
// TODO: Modifier le rowMapper pour les date et élément pouvant être null 
// TODO: Voir pour le trie dans le select de findAllTodolists
public class TodolistDAOImpl implements TodolistDAO {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public TodolistDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Todolist todolist) {
        String sqlInsert = "INSERT INTO Todolist "
            + "(title, deadline, dateCreate, dateUpdate, reference, User_id) "
            + "VALUES (:title, :deadline, :dateCreate, :dateUpdate, :reference, :user_id)";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("title", todolist.getTitle())
            .addValue("deadline", todolist.getDeadline())
            .addValue("dateCreate", todolist.getDateCreate())
            .addValue("dateUpdate", todolist.getDateUpdate())
            .addValue("reference", todolist.getReference())
            .addValue("user_id", todolist.getUserId());
        jdbcTemplate.update(sqlInsert, params);
    }

    @Override
    public Todolist findTodolist(String reference) {
        String sqlSelect = "SELECT * FROM Todolist WHERE reference = :reference";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("reference", reference);
        return jdbcTemplate.queryForObject(sqlSelect, params, new TodolistRowMapper());
    }

    @Override 
    public List<Todolist> findAllTodolists(UUID userId) {
        String sqlSelectAll = "SELECT * FROM Todolist WHERE User_id = :user_id";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("user_id", userId);
        return jdbcTemplate.query(sqlSelectAll, params, new TodolistRowMapper());
    }

    @Override
    public void rename(String reference, String newTitle) {
        String sqlUpdateTitle = "UPDATE Todolist SET title = :newTitle WHERE reference = :reference";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("newTitle", newTitle)
            .addValue("reference", reference);
        jdbcTemplate.update(sqlUpdateTitle, params); 
    }

    @Override
    public void updateDeadline(String reference, LocalDateTime newDeadline) {
        String sqlUpdateDeadline = "UPDATE Todolist SET deadline = :newDeadline WHERE reference = :reference";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("newDeadline", newDeadline)
            .addValue("reference", reference);
        jdbcTemplate.update(sqlUpdateDeadline, params); 
    }

    @Override
    public void delete(String reference) {
        String sqlDelete = "DELETE FROM Todolist WHERE reference = :reference";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("reference", reference);
        jdbcTemplate.update(sqlDelete, params);  
    }

}

class TodolistRowMapper implements RowMapper<Todolist> {
    @Override
    public Todolist mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todolist todolist = new Todolist();
        todolist.setId(rs.getObject("id", UUID.class));
        todolist.setTitle(rs.getString("title"));
        todolist.setDeadline(rs.getTimestamp("deadline").toLocalDateTime());
        todolist.setDateCreate(rs.getTimestamp("dateCreate").toLocalDateTime());
        todolist.setDateUpdate(rs.getTimestamp("dateUpdate").toLocalDateTime());
        todolist.setReference(rs.getString("reference"));
        todolist.setUserId(rs.getObject("User_id", UUID.class));
        return todolist;
    }
}
