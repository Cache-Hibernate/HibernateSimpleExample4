package com.seostella.hibernate.basics;

import com.seostella.hibernate.basics.dao.UserDAO;
import com.seostella.hibernate.basics.entity.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 03/02/2015
 * {@link http://www.seostella.com/ru/article/2012/03/17/osnovy-hibernate-3-na-primere-raboty-s-mysql.html}
 * ********************************************************************************************************
 * {@link http://www.sql.ru/forum/915534/mappedby-hibernate}
 * {@link http://www.spring-source.ru/docs_simple.php?type=manual&theme=docs_simple&docs_simple=chap04_p03}
 * {@link https://www.youtube.com/watch?v=jAi8bY-H_ek}
 * ********************************************************************************************************
 */
public class UserApp {

    private static Logger logger = Logger.getLogger(UserApp.class.getName());

    public static void main(String[] args) {
        String userInput = ""; // Line read from standard in

        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        String username = "";

        try {
            List users = new UserDAO().list();
            Iterator ui = users.iterator();
            while (ui.hasNext()) {
                User user = (User) ui.next();
                System.out.println("Пользователь: " + user.getName() + ", пароль: " + user.getPassword());
            }
            System.out.println();


            while (!(userInput.equals("0"))) {
                System.out.println("1. Создать пользователя");
                System.out.println("2. Найти пользователя");
                System.out.println("3. Удалить пользователя");
                System.out.println("0. Выход");

                userInput = in.readLine();

                if ("1".equals(userInput)) {
                    try {
                        System.out.print(" Введите имя пользователя: ");
                        username = in.readLine();
                        UserDAO userDAO = new UserDAO();
                        User user = userDAO.createUser(username, "1");
                        System.out.println("Пользователь создан. Имя: "
                                + user.getName() + " пароль: " + user.getPassword());
                    } catch (Exception e) {
                        System.out.println("Пользователь " + username + " уже существует.");
                    }
                } else if ("2".equals(userInput)) {
                    try {
                        System.out.print(" Введите имя пользователя: ");
                        username = in.readLine();
                        UserDAO userDAO = new UserDAO();
                        User user = userDAO.retrieveUser( username );
                        System.out.println( "Пользователь получен из базы данных. Имя: "
                                + user.getName() + " пароль: " + user.getPassword());
                    } catch (Exception e) {
                        System.out.println("Пользователь " + username + " не существует.");
                    }
                } else if( "3".equals( userInput ) ){
                    try {
                        System.out.print(" Введите имя пользователя: ");
                        username = in.readLine();
                        UserDAO userDAO = new UserDAO();
                        User user = userDAO.retrieveUser( username );
                        userDAO.deleteUser( user );
                        System.out.println( "Пользователь " + username + " удален из базы данных.");
                    } catch (Exception e) {
                        System.out.println("Пользователь " + username + " не существует.");
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
