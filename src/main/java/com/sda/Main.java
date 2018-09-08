package com.sda;


import com.sda.model.Student;
import com.sda.resolved.StudentResolver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        showMenu();
        int choose = 0;
        StudentResolver studentResolver = new StudentResolver();
        while (choose != 5) {
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Studenci: ");
                    List<Student> studentList = studentResolver.get();
                    for (Student student : studentList) {
                        System.out.println(student.getId() + ". " + student.getName() + " " + student.getLastname());
                    }
                    showMenu();

                    break;
                case 2:
                    System.out.println("Dodaj.");
                    Map<String, String> params = new HashMap<>();
                    System.out.println("Podaj imie: ");
                    String name = scanner.next();
                    System.out.println("Podaj nazwisko: ");
                    String lastname = scanner.next();
                    params.put("name", name);
                    params.put("lastname", lastname);
                    studentResolver.insert(params);
                    showMenu();

                    break;
                case 3:
                    System.out.println("Usun. Podaj id: ");
                    int del = scanner.nextInt();
                    studentResolver.delete(del);
                    showMenu();

                    break;
                case 4:
                    System.out.println("Nadpisz. Podaj id");
                    int upid = scanner.nextInt();
                    Map<String, String> updateParams = new HashMap<>();
                    System.out.println("Podaj nowe imie: ");
                    String updateName = scanner.next();
                    updateParams.put("name", updateName);

                    System.out.println("Podaj nowe nazwisko: ");
                    String updateLastname = scanner.next();
                    updateParams.put("lastname", updateLastname);

                    studentResolver.update(upid, updateParams);
                    showMenu();

                    break;
                case 5:
                    System.out.println("Koniec programu");
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
            }
        }

    }

    static void showMenu() {
        System.out.println("Menu:\n" +
                "1. Pokaż rekordy\n" +
                "2. Dodaj rekord\n" +
                "3. Usuń rekord [id=]\n" +
                "4. Nadpisz rekord [id=]\n" +
                "5. Koniec\n");
    }
}
