package modelo;

import db.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private String createdAt;

    public Enrollment(int id, int studentId, int courseId, String createdAt) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public String getCreatedAt() { return createdAt; }

    // Insertar una nueva inscripción
    public static void insertEnrollment(Enrollment enrollment) {
        Connection con = connection.getConnection();
        String sql = "INSERT INTO enrollment (student_id, course_id) VALUES (?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, enrollment.getStudentId());
            stmt.setInt(2, enrollment.getCourseId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todas las inscripciones
    public static List<Enrollment> getAllEnrollments() {
        Connection con = connection.getConnection();
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM enrollment";

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Enrollment enrollment = new Enrollment(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getString("created_at")
                );
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }
}
