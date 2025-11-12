public abstract class MetodoPagamento {
    protected double importo;
    public MetodoPagamento(double importo){
        this.importo=importo;
    }
    public abstract boolean verifica();
    public abstract void processamento();
    public abstract String getTipo();
}
