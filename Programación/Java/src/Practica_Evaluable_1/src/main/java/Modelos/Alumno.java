package Modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {

    private Integer identificador;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Curso curso;

    public Alumno() {
    }

    public Alumno(Integer identificador, String dni, String nombre, String apellido, LocalDate fechaNacimiento, Curso curso) {
        this.identificador = identificador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.curso = curso;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(identificador, alumno.identificador) && Objects.equals(dni, alumno.dni) && Objects.equals(nombre, alumno.nombre) && Objects.equals(apellido, alumno.apellido) && Objects.equals(fechaNacimiento, alumno.fechaNacimiento) && curso == alumno.curso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, dni, nombre, apellido, fechaNacimiento, curso);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "identificador=" + identificador +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", curso=" + curso +
                '}';
    }
}
