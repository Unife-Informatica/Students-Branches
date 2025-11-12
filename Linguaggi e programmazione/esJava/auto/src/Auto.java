public class Auto {
    String marca;
    String modello;
    int cilindrata,anno,velocita;
    public Auto(String marca, String modello, int cilindrata,int anno, int velocita){
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.anno = anno;
        this.velocita=0;
    }
    public void setMarca(String marca){
        this.marca=marca;
    }
    public void setModelloo(String modello){
        this.modello=modello;
    }
    public void setCilindrata(int cilindrata){
        this.cilindrata=cilindrata;
    }
    public void setAnno(int anno){
        this.anno=anno;
    }
    public void accellera(int incremento){
        velocita +=incremento;
        System.out.println("L'auto accellera. Velocita' attuale: "+velocita+" km/h");
    }
    public void frena(int decremento){
        velocita-=decremento;
        System.out.println("L'auto freno. Velocita' attuale: "+velocita+" km/h");
    }
    public void stampaInfo(){
        System.out.println("Marca: "+marca+"/n Modello: "+modello+"/n Cilindrata: "+cilindrata+
        "/n Anno: "+anno+"/n Velocita': "+velocita);
    }
}
