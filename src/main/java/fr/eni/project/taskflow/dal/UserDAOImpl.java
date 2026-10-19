package fr.eni.project.taskflow.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.project.taskflow.bo.User;

@Repository 
public class UserDAOImpl implements UserDAO{
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(User user) {
        String sqlInsert = "INSERT INTO [User] (firstname, lastname, email, password) VALUES (:firstname, :lastname, :email, :password)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("firstname", user.getFirstName())
                .addValue("lastname", user.getLastName())
                .addValue("email", user.getEmail())
                .addValue("password", user.getPassword());
        jdbcTemplate.update(sqlInsert, params);
    }

    @Override
    public User read(String email) {
        String sqlSelect = "SELECT * FROM [User] WHERE email = :email";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("email", email);
        try {
            return jdbcTemplate.queryForObject(sqlSelect, params, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return  null;
        }
    }

    @Override
    public void update(User user) {
        String sqlUpdate = "UPDATE [User] SET firstname = :firstname, lastname = :lastname WHERE email = :email";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("fistname", user.getFirstName())
                .addValue("lastname", user.getLastName())
                .addValue("email", user.getEmail());
        jdbcTemplate.update(sqlUpdate, params);
    }

    @Override
    public void updatePassword(String email, String newPassword) {
        String sqlUpdatePassword = "UPDATE [User] SET password = :password WHERE email = :email";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("password", newPassword)
                .addValue("email", email);
        jdbcTemplate.update(sqlUpdatePassword, params);
    }

    @Override
    public void delete(String email) {
        String sqlDelete = "DELETE FROM [User] WHERE email = :email";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("email", email);
        jdbcTemplate.update(sqlDelete, params);
    }
}

class UserRowMapper implements RowMapper<User> {
    @Override 
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setId(rs.getObject("id", UUID.class));
        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));

        return user;
    }
}