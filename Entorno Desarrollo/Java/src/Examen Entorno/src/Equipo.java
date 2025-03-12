import java.util.List;

public interface Equipo {

    public String getNombreEquipo();
    public void setNombreEquipo(String nombreEquipo);
    public List<PersonajeMarvel> getMiembros();
    public void setMiembros(List<PersonajeMarvel> miembros);
    public String getagregarMiembros(PersonajeMarvel personaje);
    public String getquitarMiembros(PersonajeMarvel personaje);
    public Double getpoderEquipo(Equipo personaje);

}
