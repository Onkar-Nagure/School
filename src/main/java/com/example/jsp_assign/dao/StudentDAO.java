package com.example.jsp_assign.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String insert = "INSERT INTO students (name, last_name, dept) VALUES (?, ?, ?)";
    private static final String select_all = "SELECT * FROM students";
    private static final String find = "SELECT * FROM students where id = ?";
    private static final String delete_student = "DELETE FROM students WHERE id = ?";
    private static final String update = "UPDATE students SET name = ?, last_name = ?, dept = ? WHERE id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://localhost:3306/school";
            String pwd = "onkar";
            String username = "root";

            connection = DriverManager.getConnection(jdbcURL, username, pwd);
            if(connection == null) System.out.println("Error connecting to database");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void addStudent(Student student) {
        try {
            Connection connect = getConnection();
            PreparedStatement stmt = connect.prepareStatement(insert);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getLastName());
            stmt.setString(3, student.getDept());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Connection connect = getConnection();
            if(connect == null) {
                System.out.println("Error connecting to database from gey All Students");
                return null;
            }
            PreparedStatement stmt = connect.prepareStatement(select_all);
            try(ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String last_name = rs.getString("last_name");
                    String dept = rs.getString("dept");
                    students.add(new Student(id, name, last_name, dept));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void deleteStudent(int id) {
        try {
            Connection connect = getConnection();
             PreparedStatement stmt = connect.prepareStatement(delete_student);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StudentDAO st = new StudentDAO();
        Connection conn = st.getConnection();
        if(conn == null) System.out.println("Error connecting to database");
        else System.out.println("Connected to database");
        System.out.println(st.getAllStudents().toString());
    }

    public Student getStudentById(int i) throws SQLException {
        Connection conn = getConnection();
        Student st = null;

        PreparedStatement stmt = conn.prepareStatement(find);
        stmt.setInt(1, i);
        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String last_name = rs.getString("last_name");
            String dept = rs.getString("dept");
            st = new Student(id, name, last_name, dept);
        }
        return st;
    }

    public boolean updateStudent(Student student) {

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(update)) {

            statement.setString(1, student.getName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getDept());
            statement.setInt(4, student.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}