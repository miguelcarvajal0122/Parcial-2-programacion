package controlador;

import vista.ViewEnrollment;
import java.util.List;

import modelo.Enrollment;

public class EnrollmentController {
    private ViewEnrollment view;

    public EnrollmentController(ViewEnrollment view) {
        this.view = view;
    }

    public void insertNewEnrollment(Enrollment enrollment) {
        Enrollment.insertEnrollment(enrollment);
        view.mostrarMensaje("\nInscription guardada correctamente!");
    }

    public void displayAllEnrollments() {
        List<Enrollment> enrollments = Enrollment.getAllEnrollments();
        view.displayListEnrollments(enrollments);
    }
}
