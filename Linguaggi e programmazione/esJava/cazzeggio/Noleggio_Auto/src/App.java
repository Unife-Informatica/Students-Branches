public class App {
    public static void main(String[] args) throws Exception {
        Pagamento paypal = new Pagamento("dadabrig@gmail.com","cavalloRampante");
        Pagamento paypal2 = new Pagamento("dadabri@gmail.com","cavalRampante");
        Auto auto = new Auto("a1","xc40","Volvo", "EK534LJ",30);
        Cliente cliente = new Cliente("p1", "Dario", "Briguglio", "LL342M", "20/02/2004",paypal);
        Cliente cliente2 = new Cliente("p2", "Dar", "Brig", "LL132M", "20/02/2004",paypal2);
        Noleggio n1= new Noleggio("n1", cliente, auto, java.time.LocalDate.now());
        Noleggio n2= new Noleggio("n2", cliente2, auto, java.time.LocalDate.now());
        n1.pagamento(3);
        System.out.println(n1.toString());
        n2.pagamento(5);
        System.out.println(n2.toString());

    }
}
