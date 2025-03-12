import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PersonajeMarvel personaje = new PersonajeMarvelImpl("Peter Parker", "Spider-Man", Boolean.TRUE, "Sentido arácnido", "Avengers", 8.5);
        PersonajeMarvel personajee = new PersonajeMarvelImpl("Erik Lehnsherr", "Magneto", Boolean.FALSE, "Control del magnetismo", "X-Men", 9.5);
        List<PersonajeMarvel> lista_personajes = new ArrayList<>();

        PersonajeMarvel personaje1 = new PersonajeMarvelImpl("Peter Parker", "Spider-Man", Boolean.TRUE, "Sentido arácnido", "Avengers", 8.5);
        PersonajeMarvel personaje2 = new PersonajeMarvelImpl("Tony Stark", "Iron Man", Boolean.TRUE, "Genio inventor con armadura avanzada", "Avengers", 9.2);
        Equipo equipo = new EquipoImpl("Avengers", lista_personajes);

        equipo.getagregarMiembros(personaje1);
        equipo.getagregarMiembros(personaje2);

        System.out.println(personaje);
        System.out.println(personajee);

        System.out.println(equipo);
    }
}
