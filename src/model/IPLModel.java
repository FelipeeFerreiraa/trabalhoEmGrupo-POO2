package model;

/**
 *
 * @author felip
 */
public class IPLModel {

//--------- VARIAVEIS
    private int idipl;
    private String ipl_nome, ipl_cpf;
    private CrimesModel crime;
    private VisitasModel parentesco;
    private RefeicaoModel refeicao;
    private PolicialPenalModel policial;

    //--------- CONSTRUTORES
    public IPLModel() {
        this.idipl = 0;
        this.ipl_nome = "";
        this.ipl_cpf = "";
        this.crime = new CrimesModel();
        this.parentesco = new VisitasModel();
        this.refeicao = new RefeicaoModel();
        this.policial = new PolicialPenalModel();
    }

    public IPLModel(int idipl, String ipl_nome, String ipl_cpf, CrimesModel crime, VisitasModel parentesco, RefeicaoModel refeicao, PolicialPenalModel policial) {
        this.idipl = idipl;
        this.ipl_nome = ipl_nome;
        this.ipl_cpf = ipl_cpf;
        this.crime = crime;
        this.parentesco = parentesco;
        this.refeicao = refeicao;
        this.policial = policial;
    }

    //--------- GETs
    public int getIdipl() {
        return idipl;
    }

    public String getIpl_nome() {
        return ipl_nome;
    }

    public String getIpl_cpf() {
        return ipl_cpf;
    }

    public CrimesModel getCrime() {
        return crime;
    }

    public VisitasModel getParentesco() {
        return parentesco;
    }

    public RefeicaoModel getRefeicao() {
        return refeicao;
    }

    public PolicialPenalModel getPolicial() {
        return policial;
    }

    //--------- SETs
    public void setIdipl(int idipl) {
        this.idipl = idipl;
    }

    public void setIpl_nome(String ipl_nome) {
        this.ipl_nome = ipl_nome;
    }

    public void setIpl_cpf(String ipl_cpf) {
        this.ipl_cpf = ipl_cpf;
    }

    public void setCrime(CrimesModel crime) {
        this.crime = crime;
    }

    public void setParentesco(VisitasModel parentesco) {
        this.parentesco = parentesco;
    }

    public void setRefeicao(RefeicaoModel refeicao) {
        this.refeicao = refeicao;
    }

    public void setPolicial(PolicialPenalModel policial) {
        this.policial = policial;
    }

    //--------- METODOS
}
