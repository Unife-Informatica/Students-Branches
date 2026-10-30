public class RectangularPrisms9 {
    public static void main(String[] args) {
        CreateFile app1 = new CreateFile();

        app1.openFile();
        for(int i = 0; i < 9; i++) {
            double a = (i + 1) * 2.0;
            double b = (i + 1) * 1.5;
            double height = (i + 1) * 3.0;

            RectangularPrism rp = new RectangularPrism();

            rp.setA(a);
            rp.setB(b);
            rp.setHeight(height);

            app1.addRectangularPrism(rp);
        }
        app1.closeFile();

        ReadFile app2 = new ReadFile();
        app2.openFile();
        app2.readRectangularPrism();
        app2.closeFile();
    }
}
