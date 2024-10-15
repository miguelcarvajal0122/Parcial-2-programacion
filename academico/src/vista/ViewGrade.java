package vista;

import interfaces.IMostrarMensaje;
import modelo.Grade;
import java.util.List;

public class ViewGrade implements IMostrarMensaje {
    public void displayListGrades(List<Grade> grades) {
        System.out.println(" == Lista de Notas == ");
        for (Grade grade : grades) {
            System.out.println("ID: " + grade.getId() +
                    ", ID de Inscripción: " + grade.getEnrollmentId() +
                    ", Tipo de Nota: " + grade.getGradeTypeId() +
                    ", Nota: " + grade.getGrade() +
                    ", Fecha: " + grade.getCreatedAt());
        }
    }
}
