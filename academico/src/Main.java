import controlador.CourseController;
import controlador.StudentController;
import controlador.TeacherController;
import controlador.GradesController;
import controlador.EnrollmentController;
import controlador.GradeTypeController;
import db.connection;
import modelo.Course;
import modelo.Student;
import modelo.Teacher;
import modelo.Enrollment;
import modelo.Grade;
import modelo.GradeType;
import vista.ViewCourse;
import vista.ViewStudent;
import vista.ViewTeacher;
import vista.ViewGrade;
import vista.ViewEnrollment;

public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        System.out.println("Bienvenido a nuestro sistema académico!");

        // Inicializar vistas
        ViewStudent viewStudent = new ViewStudent();
        ViewTeacher viewTeacher = new ViewTeacher();
        ViewCourse viewCourse = new ViewCourse();
        ViewGrade viewGrade = new ViewGrade();
        ViewEnrollment viewEnrollment = new ViewEnrollment();
        GradeTypeController gradeTypeController = new GradeTypeController();



        // Inicializar controladores
        StudentController studentController = new StudentController(viewStudent);
        TeacherController teacherController = new TeacherController(viewTeacher);
        CourseController courseController = new CourseController(viewCourse);
        GradesController gradesController = new GradesController(viewGrade);
        EnrollmentController EnrollmentController = new EnrollmentController(viewEnrollment);
        GradeTypeController GradeTypeController = new GradeTypeController();


        // Inicializar objetos de estudiante
        Student newStudent = new Student(12345, "Daniel", "daniel@gmail.com");
        Student newStudent1 = new Student(4321, "Juanito", "juanito@gmail.com");

        // Guardar estudiantes en la base de datos
        studentController.insertNewStudent(newStudent);
        studentController.insertNewStudent(newStudent1);

        // Mostrar estudiantes en la vista
        studentController.displayAllStudents();

        // Inicializar objeto profesor
        Teacher newTeacher = new Teacher(1235, "Pablo", "Ciencias Sociales");

        // Guardar profesor en la base de datos
        teacherController.insertNewTeacher(newTeacher);

        // Mostrar profesores en la vista
        teacherController.displayAllTeachers();

        // Inicializar objeto curso
        Course newCourse = new Course(1234, "Historia", "...", true, newTeacher.getId());

        // Guardar curso en la base de datos
        courseController.insertNewCourse(newCourse);

        // Mostrar cursos en la vista
        courseController.displayAllCourses();

        // Inicializar objetos de inscripción
        Enrollment newEnrollment = new Enrollment(1, newStudent.getId(), newCourse.getId(), "2024-10-15");
        Enrollment newEnrollment1 = new Enrollment(2, newStudent1.getId(), newCourse.getId(), "2024-10-15");

        // Guardar inscripciones en la base de datos
        Enrollment.insertEnrollment(newEnrollment);
        Enrollment.insertEnrollment(newEnrollment1);

        // Mostrar todas las inscripciones
        System.out.println("\n== Lista de Inscripciones ==");
        for (Enrollment enrollment : Enrollment.getAllEnrollments()) {
            System.out.println("Id: " + enrollment.getId() +
                               ", Estudiante ID: " + enrollment.getStudentId() +
                               ", Curso ID: " + enrollment.getCourseId() +
                               ", Fecha: " + enrollment.getCreatedAt());
        }

        // Inicializar objetos de calificación
        Grade newGrade = new Grade(1, newEnrollment.getId(), 1, 4.5, "2024-10-15");
        Grade newGrade1 = new Grade(2, newEnrollment1.getId(), 1, 3.8, "2024-10-15");

        // Guardar calificaciones en la base de datos
        gradesController.insertNewGrade(newGrade);
        gradesController.insertNewGrade(newGrade1);

        // Mostrar calificaciones en la vista
        gradesController.displayAllGrades();


         // Inicializar y guardar tipos de calificación
        GradeType gradeType1 = new GradeType(1, "Examen Final", 0.5, "2024-10-15");
        GradeType gradeType2 = new GradeType(2, "Tarea", 0.2, "2024-10-15");
        gradeTypeController.insertNewGradeType(gradeType1);
        gradeTypeController.insertNewGradeType(gradeType2);

        // Mostrar tipos de calificación
        gradeTypeController.displayAllGradeTypes();

        Course enrollment1;
        // Inicializar y guardar calificaciones
        Grade grade1 = new Grade(1, enrollment1.getId(), gradeType1.getId(), 4.5, "2024-10-15");
        Grade grade2 = new Grade(2, enrollment2.getId(), gradeType2.getId(), 3.8, "2024-10-15");
        gradesController.insertNewGrade(grade1);
        gradesController.insertNewGrade(grade2);

        // Mostrar calificaciones
        gradesController.displayAllGrades();
        
    }
}
