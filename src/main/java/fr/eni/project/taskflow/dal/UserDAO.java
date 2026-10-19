package fr.eni.project.taskflow.dal;

import fr.eni.project.taskflow.bo.User;

public interface UserDAO {
    void create(User user);

    User read(String email);

    void update(User user);

    void updatePassword(String email, String newPassword);

    void delete(String email);
}
