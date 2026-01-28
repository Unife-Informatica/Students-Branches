public class ControlloProduzione {
    private int semiLavorati=0;
    private int finiti=0;

    /* 
        Prodotti SEMILAVORATI
            incremento 
            decremento
            ritorno(get)
    */
    public synchronized void increaseSemilavorati(){
        int tmp=semiLavorati;
        tmp++;
        semiLavorati=tmp;
    }
    public synchronized void decreaseSemilavorati(){
        int tmp=semiLavorati;
        tmp--;
        semiLavorati=tmp;
    }
    public synchronized int getSemiLavorati(){
        return semiLavorati;
    }

    /*
        Prodotti FINITI
            incremento 
            decremento
            ritorno(get)
    */
   public synchronized void increaseFiniti(){
    int tmp=finiti;
    tmp++;
    System.out.println("tmp: "+tmp);
    finiti=tmp;
   }
   public synchronized void decreaseFiniti(){
    int tmp=finiti;
    tmp--;
    finiti=tmp;
   }
   public synchronized int getFiniti(){
    return finiti;
   }

}
