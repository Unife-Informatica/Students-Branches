/*
 * Le INTERFACCE permettono di definire i tipi, nomi, parametri
 * delle funzioni delle classi.
 */
interface Animal {
  public void animalSound();
  public void sleep();
  /*
   * una funzione definita come default fa in modo che nel caso di
   * aggiunta di funzioni nella interface non si rompa la 
   * compilazione. Nel caso la classe ridefinisca la funzione run()
   * questa verrà sovrascritta.
   */
  default void run() {
    System.out.println("Animal is run");
  }
}

/*
 * è possibile che una classe implementi piu interfacce separandole
 * con la virgola
 */
class Pig implements Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
  public void sleep() {
    System.out.println("Zzz");
  }
}

class Main {
  public static void main(String[] args) {
    Pig myPig = new Pig();
    myPig.animalSound();
    myPig.sleep();
  }
}
