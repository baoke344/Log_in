package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        PreparedStatement pstmt_i = null;
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

        //Execute a INSERT query
        System.out.println("Creating INSERT statement...");

        String sql_insert;


        for (int i = 0; i < 1; i++) {
            sql_insert = "INSERT INTO user_info(user_name, user_password) VALUES(?,?)";
            pstmt_i = conn.prepareStatement(sql_insert);

            System.out.print("Enter username: ");
            userName = scan.nextLine();
            pstmt_i.setString(1,userName);
            System.out.print("Enter password: ");
            passWords = scan.nextLine();
            pstmt_i.setString(2,passWords);
            pstmt_i.execute();
        }

        //Execute a print query
        stmt = conn.createStatement();
        String sql_print = "SELECT user_name, user_password FROM user_info";
        ResultSet rs = stmt.executeQuery(sql_print);

        //Extract data from result set
        while(rs.next()){
            String userName_data = rs.getString("user_name");
            String userPasswords_data = rs.getString("user_password");

            Users user = new Users();
            user.setUserName(userName_data);
            user.setPassWords(userPasswords_data);
            list.add(user);


        }
        for (Users user : list) {
            System.out.println(user);
        }
        rs.close();
        stmt.close();
        pstmt_i.close();
        conn.close();



    }


}
