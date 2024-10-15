package controlador;

import modelo.Grade;
import vista.ViewGrade;
import java.util.List;

public class GradesController {
    private ViewGrade view;

    public GradesController(ViewGrade view) {
        this.view = view;
    }

    public void insertNewGrade(Grade newGrade) {
        Grade.insertGrade(newGrade);
        view.mostrarMensaje("\nNota guardada correctamente!");
    }

    public void displayAllGrades() {
        List<Grade> grades = Grade.getAllGrades();
        view.displayListGrades(grades);
    }
}
