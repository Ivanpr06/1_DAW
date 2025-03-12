import java.util.ArrayList;
import java.util.List;

public class EquipoImpl implements Equipo{

    private String nombreEquipo;
    private List<PersonajeMarvel> miembros;

    public EquipoImpl(String nombreEquipo, List<PersonajeMarvel> miembros) {
        this.nombreEquipo = nombreEquipo;
        this.miembros = miembros;
    }

    @Override
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    @Override
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    @Override
    public List<PersonajeMarvel> getMiembros() {
        return miembros;
    }

    @Override
    public void setMiembros(List<PersonajeMarvel> miembros) {
        this.miembros = miembros;
    }

    public String getagregarMiembros(PersonajeMarvel personaje){
        this.miembros.add(personaje);
        return personaje.getAlias();
    }

    public String getquitarMiembros(PersonajeMarvel personaje){
        this.miembros.remove(personaje);
        return personaje.getAlias();
    }

    public Double getpoderEquipo(Equipo miembro){
        Double poderEquipo = 0.0;
        for (PersonajeMarvel p : miembros){
            poderEquipo = poderEquipo + p.getPoder();
        }return poderEquipo / miembros.size();
    }

    @Override
    public String toString() {
        for (PersonajeMarvel p : miembros){
            p.getAlias();
        }
        return "Equipo " + nombreEquipo + ", miembros: " + miembros ;
    }
}
