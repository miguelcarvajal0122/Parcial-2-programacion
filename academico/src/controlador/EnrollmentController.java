package controlador;

import modeloEnrollmentController
import vista.ViewEnrollment;
import java.util.List;

public class EnrollmentController {
    private ViewEnrollment view;

    public EnrollmentController(ViewEnrollment view) {
        this.view = view;
    }

    public void insertNewEnrollment(Enrollment enrollment) {
        Enrollment.insertEnrollment(enrollment);
        view.mostrarMensaje("\nInscripción guardada correctamente!");
    }

    public void displayAllEnrollments() {
        List<Enrollment> enrollments = Enrollment.getAllEnrollments();
        view.displayListEnrollments(enrollments);
    }
}
