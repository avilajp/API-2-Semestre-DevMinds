package devminds.tgcontrol.apptg.obj;


public class DTORelatorioFechamento {
    private static final DTORelatorioFechamento instance = new DTORelatorioFechamento();
    private String semestre;
    private String materia;

    public static DTORelatorioFechamento getInstance(){
        return instance;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
