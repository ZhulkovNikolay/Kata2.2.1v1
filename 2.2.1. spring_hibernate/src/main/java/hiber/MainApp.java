package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


//4. Создайте несколько пользователей с машинами, добавьте их в базу данных, вытащите обратно.
        User user11 = new User("user11","user11","user11@mail.com");
        User user22 = new User("user22","user22","user22@mail.com");
        User user33 = new User("user33","user33","user33@mail.com");

        Car car11 = new Car("model11",11);
        Car car22 = new Car("model22",22);
        Car car33 = new Car("model33",33);

        user11.setCar(car11);
        user22.setCar(car22);
        user33.setCar(car33);

        userService.add(user11);
        userService.add(user22);
        userService.add(user33);



        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar()); // по заданию "добавьте их в базу данных, вытащите обратно."
            System.out.println();
        }

        context.close();
    }
}