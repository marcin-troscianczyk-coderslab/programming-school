package pl.coderslab.school.dao;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.school.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/programmingschool?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String CREATE_USER_SQL = "insert into users(name, email, password) values (?, ?, ?)";

    public boolean createUser(String name, String email, String password) {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement createUserPreparedStatement = connection.prepareStatement(CREATE_USER_SQL)) {

            createUserPreparedStatement.setString(1, name);
            createUserPreparedStatement.setString(2, email);

            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            ;

            createUserPreparedStatement.setString(3, hashedPassword);

            int rowsAffected = createUserPreparedStatement.executeUpdate();

            return rowsAffected == 1 ? true : false;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean createUser(User user) {
        return false;
    }

}
