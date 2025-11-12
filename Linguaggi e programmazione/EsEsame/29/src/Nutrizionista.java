public class Nutrizionista extends Dipendente {
    int appSett;
    boolean medico;
    double costoOrario;
    String telefono;
    public Nutrizionista(int codDipendente, String tipoDipendente, String nomeDipendente, String telefono,boolean medico, int appSett,
            double costoOrario) {
        super(codDipendente, tipoDipendente, nomeDipendente);
        this.telefono = telefono;
        this.appSett = appSett;
        this.medico = medico;
        this.costoOrario = costoOrario;
    }
    public String getTelefono() {
        return telefono;
    }
    public int getAppSett() {
        return appSett;
    }
    public boolean isMedico() {
        return medico;
    }
    @Override
    public double getCosto() {
        return costoOrario;
    }
    
}
