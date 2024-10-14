package vista;

import interfaces.IMostrarMensaje;
import modelo.Enrollment;
import java.util.List;

public class ViewEnrollment implements IMostrarMensaje {
    public void displayListEnrollments(List<Enrollment> enrollments) {
        System.out.println(" == Lista de Inscripciones == ");
        for (Enrollment enrollment : enrollments) {
            System.out.println("ID: " + enrollment.getId() +
                               ", ID Estudiante: " + enrollment.getStudentId() +
                               ", ID Curso: " + enrollment.getCourseId() +
                               ", Fecha de Inscripción: " + enrollment.getCreatedAt());
        }
    }
}
