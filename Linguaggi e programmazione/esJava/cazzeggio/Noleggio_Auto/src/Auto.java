public class Auto {
    private String codUniv;
    private String modello;
    private String marca;
    private String targa;
    private Boolean noleggiata;
    double prezzoOrario;
    public Auto(String codUniv, String modello,String marca, String targa,double prezzoOrario){
        this.codUniv=codUniv;
        this.modello=modello;
        this.marca=marca;
        this.targa=targa;
        this.noleggiata=false;
        this.prezzoOrario=prezzoOrario;
    }
    public void isNoleggiata()throws AutoGiaNoleggiata{
        if(noleggiata){
            throw new AutoGiaNoleggiata("L'auto e' gia' stata noleggiata");
        }
        noleggiata=true;
    }
    public String getCodUniv(){
        return codUniv;
    }
    public String getModello(){
        return modello;
    }
    public String getMarca(){
        return marca;
    }
    public String getTarga(){
        return targa;
    }
    public double getPrezzoOrario(){
        return prezzoOrario;
    }

    
}
