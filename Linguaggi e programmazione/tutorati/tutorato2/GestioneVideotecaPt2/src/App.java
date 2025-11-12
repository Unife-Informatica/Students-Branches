public class App {
    public static void main(String[] args) throws Exception {
        Film filmAzione= new FilmAzione("a1","Uncharted4");
        Film filmCommedia = new FilmCommedia("c1","Sole a catinelle");
        Film filmDramma = new FilmDramma("d1","La mamma di Fanti");
        Noleggio [] noleggi = new Noleggio[3];
        noleggi[0]=new Noleggio("p1",filmAzione,5);
        noleggi[1]=new Noleggio("p2",filmCommedia,1);
        noleggi[2]=new Noleggio("p3",filmDramma,3);
        System.out.println("Lista noleggi: [");
        for (int i = 0; i < noleggi.length; i++) {
            System.out.println("Noleggio_"+(i+1)+"\n"+noleggi[i]);
        }
        double penaliComplessive=0.0;
        for(int i=0;i<noleggi.length;i++){
            penaliComplessive+=noleggi[i].calcolaPenale();
        }
        System.out.println("Penali complessive= "+penaliComplessive);

        
    }
}
