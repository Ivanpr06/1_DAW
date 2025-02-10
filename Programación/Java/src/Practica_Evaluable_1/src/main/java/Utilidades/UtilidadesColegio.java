package Utilidades;

import Modelos.Alumno;
import Modelos.Colegio;
import Modelos.Curso;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesColegio {

    public static Integer totalAlumnos(List <Colegio> colegio) {
        Integer totalAlumnos =  0;
        for(Colegio col : colegio) {
            Integer suma = col.getAlumnos().size();
            totalAlumnos += suma;
        }return totalAlumnos;

    }

    public static List<Alumno> mayoresEdad(Colegio colegio) {
        List<Alumno> mayoresEdad = new ArrayList<>();
        for(Alumno a : colegio.getAlumnos()) {
            if(a.getCurso().equals(Curso.CICLOS) && Period.between(a.getFechaNacimiento(), LocalDate.now()).getYears() > 18) {
                mayoresEdad.add(a);
            }
        }return mayoresEdad;

    }


    public static Map<Colegio, Integer> totalAlumnosPorColegio(List <Colegio> colegio) {
        Map<Colegio, Integer> totalAlumnosPorColegio = new HashMap<>();
        for (Colegio col : colegio) {
            if (totalAlumnosPorColegio.containsKey(col)) {
                totalAlumnosPorColegio.put(col, totalAlumnosPorColegio.get(col) + 1);
            } else {
                totalAlumnosPorColegio.put(col, 1);
            }
        }
        return totalAlumnosPorColegio;
    }

    public static Map<Curso, List<Alumno>> alumnosPorcurso(Colegio colegio){
        Map<Curso, List<Alumno>> alumnosPorCurso = new HashMap<>();
        for(Alumno alumno : colegio.getAlumnos()){
            if(alumnosPorCurso.containsKey(alumno.getCurso())){
                alumnosPorCurso.get(alumno.getCurso()).add(alumno);
            }else{
                List<Alumno> alumnos = new ArrayList<>();
                alumnos.add(alumno);
                alumnosPorCurso.put(alumno.getCurso(), alumnos);
            }
        }return alumnosPorCurso;
    }
}


