package Modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Stats {

    private Integer id;
    private String ps;
    private Integer at;
    private Integer df;
    private Integer spa;
    private Integer spdf;
    private Integer spd;

}
