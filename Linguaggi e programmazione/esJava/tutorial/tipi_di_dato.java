package LP.esJava.tutorial;

public class tipi_di_dato {
    public static void main(String[] args) {
        boolean luce = true;        //true:false|1bit
        byte ilByte = 127;          //-128:127|1byte
        short loShort = 20000;      // -32768:32767|2bytes
        int ilInt = 200_000_000;    // -2 miliardi:2 miliardi|4bytes
        long ilLong = 934749342L;   // -9 quintilioni: 9 quintilioni|8bytes
        float ilFloat = 12.4F;      // numero con 6-7 cifre decimali|4bytes
        double ilDouble =12.3;      // numero con 15 cifre decimali|8bytes
        char ilChar='N';            // singolo carattere|2bytes
        String laString="ciao";     // multiCaratteri|variabile


        System.out.println(laString.toUpperCase());
    }
}
