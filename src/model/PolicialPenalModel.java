package model;

/**
 *
 * @author felip
 */
public class PolicialPenalModel {

    //--------- VARIAVEIS
    private int idpolicialpenal;
    private String nome, cpf, turno_entrada, turno_saida;

    //--------- CONSTRUTORES
    public PolicialPenalModel() {
        this.idpolicialpenal = 0;
        this.nome = "";
        this.cpf = "";
        this.turno_entrada = "";
        this.turno_saida = "";
    }

    public PolicialPenalModel(int idpolicialpenal, String nome, String cpf, String turno_entrada, String turno_saida) {
        this.idpolicialpenal = idpolicialpenal;
        this.nome = nome;
        this.cpf = cpf;
        this.turno_entrada = turno_entrada;
        this.turno_saida = turno_saida;
    }

    //--------- GETs
    public int getIdpolicialpenal() {
        return idpolicialpenal;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTurno_entrada() {
        return turno_entrada;
    }

    public String getTurno_saida() {
        return turno_saida;
    }

    //--------- SETs
    public void setIdpolicialpenal(int idpolicialpenal) {
        this.idpolicialpenal = idpolicialpenal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTurno_entrada(String turno_entrada) {
        this.turno_entrada = turno_entrada;
    }

    public void setTurno_saida(String turno_saida) {
        this.turno_saida = turno_saida;
    }

    //--------- METODOS
}
