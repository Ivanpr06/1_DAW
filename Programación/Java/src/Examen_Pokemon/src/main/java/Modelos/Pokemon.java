package Modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pokemon {

    private Integer numPokedex;
    private Integer generacion;
    private String nombre;
    private Integer nivel;
    private List<TipoPokemon> tipos;
    private Stats stats;
    private List<LineaEvolutiva> lineaEvolutiva;
    private List<Movimiento> movimientos;

}
