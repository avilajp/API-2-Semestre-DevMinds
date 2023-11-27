package devminds.tgcontrol.apptg.obj.csvimport;


public class DTOInicial {
    private static final DTOInicial instance = new DTOInicial();
    private String semestreMateria;
    private DTOInicial(){}
    public static DTOInicial getInstance(){
        return instance;
    }

    public String getSemestreMateria() {
        return semestreMateria;
    }

    public void setSemestreMateria(String semestreMateria) {
        this.semestreMateria = semestreMateria;
    }
}
