package controlador;

import modelo.GradeType;
import java.util.List;

public class GradeTypeController {

    public void insertNewGradeType(GradeType newGradeType) {
        GradeType.insertGradeType(newGradeType);
        System.out.println("\nNuevo tipo de calificación guardado correctamente!");
    }

    public void displayAllGradeTypes() {
        List<GradeType> gradeTypes = GradeType.getAllGradeTypes();
        System.out.println("\n== Lista de Tipos de Calificación ==");
        for (GradeType gradeType : gradeTypes) {
            System.out.println("ID: " + gradeType.getId() +
                               ", Nombre: " + gradeType.getName() +
                               ", Ponderacion: " + gradeType.getWeight() +
                               ", Creado en: " + gradeType.getCreatedAt());
        }
    }
}
