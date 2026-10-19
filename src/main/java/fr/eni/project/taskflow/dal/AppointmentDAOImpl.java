package fr.eni.project.taskflow.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.eni.project.taskflow.bo.Appointment;

public class AppointmentDAOImpl implements AppointmentDAO {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public AppointmentDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Appointment appointment) {
        String sqlInsert = "INSERT INTO Appontment "
            + "(title, description, adress, dateStart, dateEnd, dateCreate, dateUpdate, reference, User_id) " 
            + "VALUES (:title, :description, :adress, :dateStart, :dateEnd, :dateCreate, :dateUpdate, :reference, :user_id)";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("title", appointment.getTitle())
            .addValue("description", appointment.getDescription())
            .addValue("adress", appointment.getAdress())
            .addValue("dateStart", appointment.getDateStart())
            .addValue("dateEnd", appointment.getDateEnd())
            .addValue("dateCreate", appointment.getDateCreate())
            .addValue("dateUpdate", appointment.getDateUpdate())
            .addValue("reference", appointment.getReference())
            .addValue("user_id", appointment.getUserId());
        jdbcTemplate.update(sqlInsert, params);
    }

    @Override
    public Appointment findAppointment(String reference) {
        String sqlSelect = "SELECT * FROM Appointment WHERE reference = :reference";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("reference", reference);
        return jdbcTemplate.queryForObject(sqlSelect, params, new AppointmentRowMapper());
    }

    @Override
    public List<Appointment> findAllAppointments(UUID userId) {
        String sqlSelectAll = "SELECT * FROM Appointment WHERE User_id = :user_id";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("user_id", userId);
        return jdbcTemplate.query(sqlSelectAll, params, new AppointmentRowMapper());
    }

    @Override
    public void rename(String reference, String newTitle) {
        String sqlUpdateTitle = "UPDATE Appointment SET title = :newTitle WHERE reference = :reference";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("newTitle", newTitle)
            .addValue("reference", reference);
        jdbcTemplate.update(sqlUpdateTitle, params);
    }

    @Override
    public void update(Appointment appointment) {
       String sqlUpdate = "UPDATE Appointment SET title = :title, description = :description, adress = :adress, dateStart = :dateStart, dateEnd = : dateEnd, dateUpdate = :dateUpdate WHERE reference = :reference";
       MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("title", appointment.getTitle())
            .addValue("description", appointment.getDescription())
            .addValue("adress", appointment.getAdress())
            .addValue("dateStart", appointment.getDateStart())
            .addValue("dateEnd", appointment.getDateEnd())
            .addValue("dateUpdate", appointment.getDateUpdate())
            .addValue("reference", appointment.getReference());
        jdbcTemplate.update(sqlUpdate, params);
    }

    @Override
    public void delete(String reference) {
        String sqlDelete = "DELETE FROM Appointment WHERE reference = :reference";
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("reference", reference);
        jdbcTemplate.update(sqlDelete, params);
    }

}

class AppointmentRowMapper implements RowMapper<Appointment> {
    @Override
    public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Appointment appointment = new Appointment();

        appointment.setId(rs.getObject("id", UUID.class));
        appointment.setTitle(rs.getString("title"));
        appointment.setDescription(rs.getString("description"));
        appointment.setAdress(rs.getString("adress"));
        appointment.setDateStart(rs.getTimestamp("dateStart").toLocalDateTime());
        appointment.setDateEnd(rs.getTimestamp("dateEnd").toLocalDateTime());
        appointment.setDateCreate(rs.getTimestamp("dateCreate").toLocalDateTime());
        appointment.setDateUpdate(rs.getTimestamp("dateUpdate").toLocalDateTime());
        appointment.setReference(rs.getString("reference"));
        appointment.setUserId(rs.getObject("user_id", UUID.class));

        return appointment;
    }
}