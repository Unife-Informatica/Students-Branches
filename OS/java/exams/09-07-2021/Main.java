public class Main {

    public static void main(String[] args) {
        Consumi c = new Consumi();

        SimulaConsumi sc = new SimulaConsumi(c);
        Thread tsc = new Thread(sc);

        tsc.start();

        int count = 0;

        while (true) {
            try {
                float val = c.getVal();

                if (val > 20) {
                    count++;
                }

                if (count > 3) {
                    sc.termina();
                }

                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
