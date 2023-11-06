package devminds.tgcontrol.apptg.obj;

public class DTOSemestre {
    private static final DTOSemestre instance = new DTOSemestre();
    private String semestre;
    private String materia;
    private DTOSemestre(){}
    public static DTOSemestre getInstance(){
        return instance;
    }
    public String getSemestre(){
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
