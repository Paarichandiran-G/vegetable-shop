
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.userController;
import Models.Connect;
import Views.Admin;
import Views.Farmer;
import Views.Consumer;

public class App extends Connect {
    public static void main(String[] args) {
        try {
            Connect.getConnection();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println();
                System.out.println("+---------------------------------+");
                System.out.println("|           1.Login               |");
                System.out.println("|           2.New User            |");
                System.out.println("|           3.Exit                |");
                System.out.println("+---------------------------------+");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    System.out.println();
                    System.out.print(" ENTER YOUR EMAIL    : ");
                    String email = sc.nextLine();
                    System.out.println();
                    System.out.print(" ENTER YOUR PASSWORD : ");
                    String password = sc.nextLine();
                    System.out.println();
                    int role = userController.login(email, password);
                    if (role == 1) {
                        Farmer.farmer();
                    } else if (role == 2) {
                        Admin.admin();
                    } else {
                        Consumer.consumer();
                    }

                }
                else if (choice == 2) {
                    System.out.println();
                    System.out.println("--ENTER YOUR NAME--");
                    System.out.println();
                    String name = sc.nextLine();
                    System.out.println();
                    System.out.println("--ENTER YOUR GENDER (M/F)--");
                    System.out.println();
                    String gender = sc.nextLine();
                    System.out.println();
                    System.out.println("--ENTER YOUR LOCATION--");
                    System.out.println();
                    String location = sc.nextLine();
                    System.out.println();
                    System.out.println("--ENTER YOUR CONTACT NUMBER--");
                    System.out.println();
                    String contactNumber = sc.nextLine();
                    System.out.println();
                    System.out.println("--ENTER YOUR ROLE ADMIN/FARMER/CONSUMER--");
                    System.out.println();
                    String role = sc.nextLine();
                    System.out.println();
                    System.out.println("--ENTER YOUR EMAIL--");
                    System.out.println();
                    String email = sc.nextLine();
                    System.out.println();
                    System.out.println("--CREATE STRONG PASSWORD-");
                    System.out.println();
                    String password = sc.nextLine();
                    userController.add(name, gender, location, contactNumber, role, email, password);
                    System.out.println("--SUCESSFULLY USER_ID CREATED--");
                } else {
                    System.out.println();
                    System.out.println("-- THANK YOU ! --");
                    return;
                }
            } catch (SQLException err) {
                System.out.println("--Database error--");
            } catch (InputMismatchException err) {
                System.out.println("--Invalid input--");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
