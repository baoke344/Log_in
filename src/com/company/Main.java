package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        //Connection and Open connection
        String url = "jdbc:postgresql://localhost/db_users";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","nhuchuahechia");
        props.setProperty("ssl","false");
        Connection conn = DriverManager.getConnection(url, props);


        Scanner scan = new Scanner(System.in);
        String userName;
        String passWords;


        List<Users> list = new ArrayList<>();

        //Execute a query
        System.out.println("Creating INSERT statement...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT user_name, user_password FROM user_info";

        ResultSet rs = stmt.executeQuery(sql);

        //Extract data from result set
        while(rs.next()){
            String userName_data = rs.getString("user_name");
            String userPasswords_data = rs.getString("user_password");

            Users user = new Users();
            user.setUserName(userName_data);
            user.setPassWords(userPasswords_data);
            list.add(user);

//            System.out.println("User_Name: "+ userName_data);
//            System.out.println("User_passwords: "+userPasswords_data);
        }
        for (Users user : list) {
            System.out.println(user);
        }
        rs.close();
        stmt.close();;
        conn.close();



//        for (int i = 0; i < 3; i++) {
//
//            Users user = new Users();
//            System.out.print("Enter username: ");
//            userName = scan.nextLine();
//            user.setUserName(userName);
//            System.out.print("Enter password: ");
//            passWords = scan.nextLine();
//            user.setPassWords(passWords);
//            list.add(user);
//        }
//
//        for (Users user : list) {
//            System.out.println(user);
//        }
//        scan.close();
    }

//    public static List<Users> user() {
//
//        return List.of()
//
//        );
//    }
}
