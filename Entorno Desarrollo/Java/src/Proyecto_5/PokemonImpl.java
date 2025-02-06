package Proyecto_5;

public class PokemonImpl implements Pokemon{
    // Atributos
    private Integer NumPokemon;
    private String NamePokemon;
    private String DescPokemon;
    private Integer AlturaPokemon;
    private Integer PesoPokemon;
    private GeneroPokemon GeneroPokemon;
    private String TipoPokemon;

    // Constructor
    public PokemonImpl(Integer numPokemon, String namePokemon, String descPokemon, Integer alturaPokemon, Integer pesoPokemon, Proyecto_5.GeneroPokemon generoPokemon, String tipoPokemon) {
        NumPokemon = numPokemon;
        NamePokemon = namePokemon;
        DescPokemon = descPokemon;
        AlturaPokemon = alturaPokemon;
        PesoPokemon = pesoPokemon;
        GeneroPokemon = generoPokemon;
        TipoPokemon = tipoPokemon;
    }

    // Get && Set

    @Override
    public Integer getNumPokemon() {
        return NumPokemon;
    }

    @Override
    public String getNamePokemon() {
        return NamePokemon;
    }

    @Override
    public String getDescPokemon() {
        return DescPokemon;
    }

    @Override
    public void setDescPokemon(String desc) {

    }

    @Override
    public Integer getAlturaPokemon() {
        return AlturaPokemon;
    }

    @Override
    public void setAlturaPokemon(Integer altura) {

    }

    @Override
    public Integer getPesoPokemon() {
        return PesoPokemon;
    }

    @Override
    public void setPesoPokemon(Integer peso) {

    }

    @Override
    public GeneroPokemon getGeneroPokemon() {
        return GeneroPokemon;
    }

    @Override
    public void setGeneroPokemon(Proyecto_5.GeneroPokemon genero) {

    }

    @Override
    public String getTipoPokemon() {
        return TipoPokemon;
    }

    // ToString
    @Override
    public String toString() {
        return "Nº" + NumPokemon + " - " + NamePokemon + " - " + DescPokemon + "\nAltura : " + AlturaPokemon + "\nPeso : " + PesoPokemon + "kg" + "\nGenero : " + GeneroPokemon + "\nTipo : " + TipoPokemon;
    }
}
