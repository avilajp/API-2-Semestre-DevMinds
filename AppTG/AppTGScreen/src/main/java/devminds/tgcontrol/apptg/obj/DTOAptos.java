package devminds.tgcontrol.apptg.obj;

public class DTOAptos {
    private static final DTOAptos instance = new DTOAptos();
    private String semestre;
    private String materia;

    public static DTOAptos getInstance(){
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
