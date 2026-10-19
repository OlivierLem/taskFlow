package fr.eni.project.taskflow.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.eni.project.taskflow.bo.Note;

public class NoteDAOImpl implements NoteDAO{
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public NoteDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Note note) {
        String sqlInsert = "INSERT INTO Note "
            + "(title, content, dateCreate, dateUpadate, reference, User_id) "
            + "VALUES (:title, :content, :dateCreate, :dateUpdate, :reference, :user_id)";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("title", note.getTitle())
            .addValue("content", note.getContent())
            .addValue("dateCreate", note.getDateCreate())
            .addValue("dateUpdate", note.getDateUpdate())
            .addValue("reference", note.getReference())
            .addValue("user_id", note.getUserId());
            
        jdbcTemplate.update(sqlInsert, params);
    }

    @Override
    public Note findNote(String reference) {
        String sqlSelect = "SELECT * FROM Note WHERE reference = :reference";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("reference", reference);
        return jdbcTemplate.queryForObject(sqlSelect, params, new NoteRowMapper());
    }

    
    @Override
    public List<Note> findAllNotes(UUID userId) {
        String sqlSelectAll = "SELECT * FROM Note WHERE User_id = :user_id";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("user_id", userId);
        return jdbcTemplate.query(sqlSelectAll, params, new NoteRowMapper());
    }

    @Override
    public void rename(String reference, String newTitle) {
        String sqlUpdateTitle = "UPDATE Note SET title = :newTitle WHERE reference = :reference";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("newTitle", newTitle)
            .addValue("reference", reference);
        jdbcTemplate.update(sqlUpdateTitle, params);
    }

    @Override
    public void updateContent(String reference, String newContent) {
        String sqlUpdateContent = "UPDATE Note SET content = :newContent WHERE reference = :reference";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("newContent", newContent)
            .addValue("reference", reference);
        jdbcTemplate.update(sqlUpdateContent, params); }

    @Override
    public void delete(String reference) {
        String sqlDelete = "DELETE FROM Note WHERE reference = :reference";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("reference", reference);
        jdbcTemplate.update(sqlDelete, params);
    }
}

class NoteRowMapper implements RowMapper<Note> {
    @Override
    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
        Note note = new Note();

        note.setId(rs.getObject("id", UUID.class));
        note.setTitle(rs.getString("title"));
        note.setContent(rs.getString("content"));
        note.setDateCreate(rs.getTimestamp("dateCreate").toLocalDateTime());
        note.setDateUpdate(rs.getTimestamp("dateUpdate").toLocalDateTime());
        note.setReference(rs.getString("reference"));
        note.setUserId(rs.getObject("user_id", UUID.class));

        return note;
    } 
}