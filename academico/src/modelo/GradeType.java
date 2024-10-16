package modelo;

import db.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeType {
    private int id;
    private String name;
    private double weight;
    private String createdAt;

    // Constructor
    public GradeType(int id, String name, double weight, String createdAt) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.createdAt = createdAt;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    // Insertar un nuevo tipo de calificación
    public static void insertGradeType(GradeType gradeType) {
        Connection con = connection.getConnection();
        String sql = "INSERT INTO grade_type (name, weight) VALUES (?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, gradeType.getName());
            statement.setDouble(2, gradeType.getWeight());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar el tipo de calificación: " + e.getMessage());
        }
    }

    // Obtener todos los tipos de calificación
    public static List<GradeType> getAllGradeTypes() {
        Connection con = connection.getConnection();
        List<GradeType> gradeTypes = new ArrayList<>();

        String sql = "SELECT * FROM grade_type";

        try (PreparedStatement statement = con.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                GradeType gradeType = new GradeType(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("weight"),
                    rs.getString("created_at")
                );
                gradeTypes.add(gradeType);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los tipos de calificación: " + e.getMessage());
        }
        return gradeTypes;
    }
}
