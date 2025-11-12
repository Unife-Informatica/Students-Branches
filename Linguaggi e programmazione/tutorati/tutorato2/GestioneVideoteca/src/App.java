public class App {
    public static void main(String[] args) throws Exception {
        Film filmAzione= new FilmAzione("A1","Terminator");
        Film filmCommedia=new FilmCommedia("C1","Una notte da leoni");
        Film filmDramma=new FilmDramma("D1","Titanic");
        Noleggio [] noleggi = new Noleggio[3];
        noleggi[0]=new Noleggio(filmAzione,"1",5);
        noleggi[1]= new Noleggio(filmCommedia,"2",1);
        noleggi[2]=new Noleggio(filmDramma,"3",3);

        System.out.println("Lista Noleggi: [");
        for (int i = 0; i < noleggi.length; i++) {
            System.out.println("Noleggio_"+(i+1)+"\n"+noleggi[i]);
        }
        System.out.println("]");
        
        double amountPenali = 0.0;
        for (Noleggio noleggi1 : noleggi) {
            amountPenali += noleggi1.calcolaPenale();
        }
        System.out.println("Ammontare complessivo delle penali: "+amountPenali+"$");
    }
}
