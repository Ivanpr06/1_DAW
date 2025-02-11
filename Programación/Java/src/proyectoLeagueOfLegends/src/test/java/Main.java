import Modelos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Habilidad> habilidades = new ArrayList<>();
        List<Item> items = new ArrayList<>();

        Item item = new Item(1,"Bocata Pan", 12.3, 6.0, 20.5, 17.8);
        items.add(item);
        Escalabilidad escal = new Escalabilidad(2, "Nose q es", 1.9, 14.5, 28.0, 12.2);
        Habilidad habilidad = new Habilidad(3, "Masca", 20.0, 25.0, 10.0, TipoHabilidad.DANYO);
        habilidades.add(habilidad);
        Personaje personaje = new Personaje(5, "Manolo", "Un hombre muy español", LocalDate.of(1954,5,19), 30, 150.4, 100.0, 150.4, 200.0, 250.0, 300.0, 100.0, RegionPersonaje.DESCONOCIDA, habilidades, items, escal);

        System.out.println(item);
        System.out.println(escal);
        System.out.println(habilidad);
        System.out.println(personaje);
    }
}
