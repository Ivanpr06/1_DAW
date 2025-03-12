import java.util.List;
import java.util.random.RandomGenerator;
public class EnfrentamientoImpl {

    private Equipo equipo1;
    private Equipo equipo2;

    public EnfrentamientoImpl(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public Equipo simularEnfrentamiento(Equipo equipo1, Equipo equipo2) {
        Double RandomGenerator = 1.0 / 2.0;
        Equipo enfrentamiento = null;

        Double equipo1_danyo = equipo1.getpoderEquipo(equipo1) * RandomGenerator;
        Double equipo_2_danyo = equipo2.getpoderEquipo(equipo2) * RandomGenerator;

        if (equipo1_danyo > equipo_2_danyo) {
            enfrentamiento = equipo1;
        }else if (equipo1_danyo < equipo_2_danyo) {
            enfrentamiento = equipo2;
        }else{
            enfrentamiento = null;
        }
        return enfrentamiento;
    }
}
