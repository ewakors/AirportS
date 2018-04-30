/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@HandlerChain(file = "handler-chain.xml")
public class ServerInfo {

    @WebMethod
    public String getServerName() {

        ArrayList<Flight> list = new ArrayList<Flight>();

        // JDBC driver name and database URL 
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/mydb";

        // Database credentials 
        String USER = "root";
        String PASS = "newpassword";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String cityFrom = null;
        //Extract data from result set
        try {

            //Open a connection
            System.out.println("Connecting to a selected database...");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected database successfully...");
            //Execute a query 
            System.out.println("Creating statement...");
            stmt = (Statement) conn.createStatement();
            String searchCity = "London";

//            String sql = "SELECT * FROM flight WHERE cityTo LIKE '" + searchCity + "'";
            String sql = "SELECT * FROM flight ";
            rs = stmt.executeQuery(sql);
            //Extract data from result set
            while (rs.next()) {
                
                // Retrieve by column name
                int id = rs.getInt("id");

                cityFrom = rs.getString("cityFrom");
                String cityTo = rs.getString("cityTo");

                //int percent = rs.getInt("percentage");
                String email = rs.getString("email");

                // Setting the values
                Flight flight = new Flight(rs.getString("cityFrom"));
                flight.setID(id);
                flight.setCityFrom(cityFrom);
                flight.setCityTo(cityTo);
                //student.setPercent(percent);
                flight.setDay(email);
                list.add(flight);
                System.out.println("ID: " + id);
                System.out.println("name: " + cityFrom);
                list.add(flight);
            }
        } catch (Exception e) {
            System.out.println("Database error..." + e);
        }
        return cityFrom;

    }

//    @WebMethod
//    public String getAirport() {
//
//        List<Flight> list = new ArrayList<Flight>();
//
//        // JDBC driver name and database URL 
//        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//        String DB_URL = "jdbc:mysql://localhost:3306/mydb";
//
//        // Database credentials 
//        String USER = "root";
//        String PASS = "newpassword";
//
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        String studentName = null;
//        //Extract data from result set
//        try {
//
//            //Open a connection
//            System.out.println("Connecting to a selected database...");
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//            System.out.println("Connected database successfully...");
//            //Execute a query 
//            System.out.println("Creating statement...");
//            stmt = (Statement) conn.createStatement();
//            String name = "Anna";
//
//            String sql = "SELECT * FROM student_data WHERE name LIKE '" + name + "'";
//
//            rs = stmt.executeQuery(sql);
//            //Extract data from result set
//            while (rs.next()) {
//                // Retrieve by column name
//                int id = rs.getInt("id");
//
//                studentName = rs.getString("name");
//                String branch = rs.getString("branch");
//
//                //int percent = rs.getInt("percentage");
//                String email = rs.getString("email");
//
//                // Setting the values
//                Flight student = new Flight();
//                student.setID(id);
//                student.setName(studentName);
//                student.setBranch(branch);
//                //student.setPercent(percent);
//                student.setEmail(email);
//                list.add(student);
//                System.out.println("ID: " + id);
//                System.out.println("name: " + studentName);
//            }
//        } catch (Exception e) {
//            System.out.println("Database error..." + e);
//        }
//        return studentName;
//    }
}
