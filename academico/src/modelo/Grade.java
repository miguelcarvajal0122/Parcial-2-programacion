package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Grade {
    private int id;
    private int enrollmentId;
    private int gradeTypeId;
    private double grade;
    private String createdAt;

    public Grade(int id, int enrollmentId, int gradeTypeId, double grade, String createdAt) {
        this.id = id;
        this.enrollmentId = enrollmentId;
        this.gradeTypeId = gradeTypeId;
        this.grade = grade;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public int getGradeTypeId() {
        return gradeTypeId;
    }

    public double getGrade() {
        return grade;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    // Insertar una nueva nota en la base de datos
    public static void insertGrade(Grade grade) {
        Connection con = connection.getConnection();
        String sql = "INSERT INTO grades (id, enrollment_id, grade_type_id, grade, created_at) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, grade.getId());
            statement.setInt(2, grade.getEnrollmentId());
            statement.setInt(3, grade.getGradeTypeId());
            statement.setDouble(4, grade.getGrade());
            statement.setString(5, grade.getCreatedAt());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todas las notas de la base de datos
    public static List<Grade> getAllGrades() {
        Connection con = connection.getConnection();
        List<Grade> grades = new ArrayList<>();

        String sql = "SELECT * FROM grades";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Grade grade = new Grade(
                    rs.getInt("id"),
                    rs.getInt("enrollment_id"),
                    rs.getInt("grade_type_id"),
                    rs.getDouble("grade"),
                    rs.getString("created_at")
                );
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }
}
