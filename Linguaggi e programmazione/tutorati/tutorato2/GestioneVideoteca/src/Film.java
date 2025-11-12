public abstract class Film{
    protected String codUniv, titolo;
    double penale;
    public Film(String codUniv, String titolo){
        this.codUniv = codUniv;
        this.titolo=titolo;
    }
    public abstract double calcolaPenale(int giorniRitardo);

    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        Film other = (Film)obj;
        if(codUniv==null){
            if(other.codUniv!=null){
                return false;
            }
        }else if(!codUniv.equals(other.codUniv)){
            return false;
        }
        return true;
    }
    @Override
    public String toString(){
        return "[codice="+codUniv+", titolo="+titolo+", penale="+penale+"]";
    }
}
