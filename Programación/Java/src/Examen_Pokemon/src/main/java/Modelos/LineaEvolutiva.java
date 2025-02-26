package Modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LineaEvolutiva {
    private Pokemon pokemon;
    private Integer nivelParaEvolucionar;
    private Integer orden;
}
