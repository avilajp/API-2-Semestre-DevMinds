package devminds.tgcontrol.apptg.obj;

public class DTOInterTela {
    private static final DTOInterTela instance = new DTOInterTela();
    private String textoDaChoice;
    private DTOInterTela(){}
    public static DTOInterTela getInstance(){
        return instance;
    }

    public String getTextoDaChoice() {
        return textoDaChoice;
    }

    public void setTextoDaChoice(String textoDaChoice) {
        this.textoDaChoice = textoDaChoice;
    }
}
