public class PersonajeMarvelImpl  implements PersonajeMarvel{

    private String nombre;
    private String alias;
    private Boolean esHeroe;
    private String poderPrincipal;
    private String afiliacion;
    private Double poder;

    public PersonajeMarvelImpl(String nombre, String alias, Boolean esHeroe, String poderPrincipal, String afiliacion, Double poder) {
        this.nombre = nombre;
        this.alias = alias;
        this.esHeroe = esHeroe;
        this.poderPrincipal = poderPrincipal;
        this.afiliacion = afiliacion;
        this.poder = poder;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public Boolean getEsHeroe() {
        return esHeroe;
    }

    @Override
    public String getPoderPrincipal() {
        return poderPrincipal;
    }

    @Override
    public String getAfiliacion() {
        return afiliacion;
    }

    @Override
    public Double getPoder() {
        return poder;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setEsHeroe(Boolean esHeroe) {
        this.esHeroe = esHeroe;
    }

    @Override
    public void setPoderPrincipal(String poderPrincipal) {
        this.poderPrincipal = poderPrincipal;
    }

    @Override
    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    @Override
    public void setPoder(Double poder) {
        this.poder = poder;
    }

    @Override
    public String toString() {
        return alias + " (" + nombre + "). Su poder principal es el " + poderPrincipal + " . Su afiliacion, " + afiliacion + ". " + esHeroe + ". Su poder es de " + poder + ".";
    }
}
