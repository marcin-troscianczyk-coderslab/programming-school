package pl.coderslab.school.main;

import pl.coderslab.school.dao.UserDao;

public class Main {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        String name = "Jan Kowalski";
        String email = "jan.kowalski@gmail.com";
        String password = "QW%5!nm";

        boolean result = userDao.createUser(name, email, password);

        System.out.println("Result: " + result);

    }
}
