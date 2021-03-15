package kz.iitu.midterm;

import kz.iitu.midterm.config.SpringConfig;
import kz.iitu.midterm.controller.AdminController;
import kz.iitu.midterm.controller.ClientController;
import kz.iitu.midterm.entities.Payment;
import kz.iitu.midterm.entities.room.Phone;
import kz.iitu.midterm.entities.room.PhoneType;
import kz.iitu.midterm.entities.user.User;
import kz.iitu.midterm.entities.user.UserType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AdminController adminController = context.getBean("adminController",AdminController.class);
        ClientController clientController = context.getBean("clientController",ClientController.class);

        Scanner in= new Scanner(System.in);
        int choise;
        while (true){
            System.out.println("\n          Welcome to the Phone Store!\n" +
                    "\n [1] Login " +
                    "\n [2] Registration " +
                    "\n [0] Quit \n " +
                    "+-----------------------------+");
            System.out.print("Choose:");
            choise = in.nextInt();
            switch (choise) {
                case 1:
                    System.out.print("Login:  ");
                    String login = in.next();
                    System.out.print("Password:  ");
                    String password = in.next();
                    User user = clientController.verificationUser(login, password);
                    if (user != null) {
                        switch (user.getType()) {
                            case 1:

                                while (true) {
                                    System.out.println("WELCOME TO ADMIN PAGE:\n" +
                                            " [1] Add phone \n" +
                                            " [2] Delete phone \n" +
                                            " [3] Add administrator \n" +
                                            " [4] Delete user \n" +
                                            " [5] Show available phones \n" +
                                            " [0] Exit\n" +
                                            "+-------------------------+");
                                    System.out.print("Choose: ");
                                    int choise1 = in.nextInt();
                                    switch (choise1) {
                                        case 1:
                                            Random rand = new Random();
                                            int id = rand.nextInt(10000);
                                            System.out.println("Choose: \n" +
                                                    " [1] Tablet \n" +
                                                    " [2] Smartphone \n" +
                                                    "+--------------+");
                                            System.out.print("Choose: ");
                                            int choise2 = in.nextInt();
                                            PhoneType phoneType;
                                            switch (choise2) {
                                                case 1:
                                                    phoneType = PhoneType.TABLET;
                                                    break;
                                                case 2:
                                                    phoneType = PhoneType.SMARTPHONE;
                                                    break;
                                                default:
                                                    throw new IllegalStateException("Unexpected value: " + choise2);
                                            }
                                            System.out.print("Enter price: ");
                                            int price = in.nextInt();
                                            System.out.println("Enter name of phone: ");
                                            String phoneName = in.next();
                                            Phone phone = new Phone(id,phoneName, true, phoneType, price);
                                            adminController.createPhone(phone);
                                            System.out.println("Phone successfully added!");
                                            break;

                                        case 2:
                                            System.out.print("ID of phone: ");
                                            int id2 = in.nextInt();
                                            adminController.deletePhone(id2);
                                            break;

                                        case 3:
                                            Random rand1 = new Random();
                                            int id1 = rand1.nextInt(10000);
                                            System.out.print("Username: ");
                                            String username = in.next();
                                            System.out.print("Password: ");
                                            String password1 = in.next();
                                            System.out.print("e-mail: ");
                                            String email = in.next();
                                            User user1 = new User(id1, username, password1, email, 1);
                                            adminController.createUser(user1);
                                            break;

                                        case 4:
                                            System.out.print("ID of user: ");
                                            int id3 = in.nextInt();
                                            adminController.deleteUser(id3);
                                            break;

                                        case 5:
                                            adminController.showAvailablePhone();
                                            break;

                                        case 0:
                                            return;
                                    }
                                }

                            case 2:
                                while (true) {
                                    System.out.println("Welcome! : \n" +
                                            " [1] Show available phones \n" +
                                            " [2] Buy phone \n" +
                                            " [0] Exit\n" +
                                            "+-----------------------+");
                                    System.out.print("Choise: ");
                                    int choise3 = in.nextInt();
                                    switch (choise3) {
                                        case 1:
                                            adminController.showAvailablePhone();
                                        case 2:
                                            System.out.println("Choose: \n" +
                                                    " [1] Tablet \n" +
                                                    " [2] Smartphone \n" +
                                                    " [3] Go back \n" +
                                                    "+---------------+");
                                            int choise4 = in.nextInt();
                                            PhoneType phoneType =null;
                                            int numphone=0;
                                            switch (choise4) {
                                                case 1:
                                                    phoneType = PhoneType.TABLET;
                                                    numphone=1;
                                                    break;
                                                case 2:
                                                    phoneType = PhoneType.SMARTPHONE;
                                                    numphone=2;
                                                    break;
                                            }
                                            clientController.phonesByType(phoneType);
                                            System.out.println("Please enter ID of phone: ");
                                            int id = in.nextInt();
                                            Phone phone = clientController.findById(id);
                                            System.out.println(phone);
                                            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                                            Date date = new Date();
                                            String stringDate= DateFor.format(date);
                                            Payment payment = new Payment(phone.getId(),phone.getPhoneName(), phone.getPrice(),  stringDate, user.getId());
                                            System.out.println(stringDate);
                                            clientController.addReservation(payment);
                                            System.out.println("\n\n Thank you!!! Your order: \n" +
                                                    payment + "\n\n");

                                            break;

                                        case 0:
                                            return;
                                    }
                                    break;
                                }
                        }
                    } else {
                        System.out.println("Your password or username is not correct!!!");
                    }
                break;

                case 2:
                    System.out.print("Enter your login: ");
                    String log = in.next();
                    String password1;
                    while(true) {
                        System.out.print("Enter your password: ");
                        password1 = in.next();
                        System.out.print("Confirm your password: ");
                        String password2 = in.next();
                        if (password1.equals(password2)) {
                            break;
                        } else {
                            System.out.println("Confirmation error!!!");
                        }
                    }
                    System.out.print("Enter your e-mail: ");
                    String email = in.next();
                    Random rand = new Random();
                    int id = rand.nextInt(1000);
                    User user1 = new User(id, log, password1, email, 2);
                    adminController.createUser(user1);
                    break;
                    

                case 0:
                    return;
            }
        }
    }
}
