import Modelos.Alumno;
import Modelos.Colegio;
import Modelos.Curso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PruebasPracticaEvaluable1 {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();
        Alumno alumno = new Alumno(2,"12345678P", "Manolo", "Risas", LocalDate.of(1980, 10, 10), Curso.CICLOS);
        alumnos.add(alumno);
        Colegio colegio = new Colegio(1, "Safa Reyes", "Calle Calatrava", LocalDate.of(2006, 10,20), alumnos);

        System.out.println(alumno);
        System.out.println(colegio);
    }
}
