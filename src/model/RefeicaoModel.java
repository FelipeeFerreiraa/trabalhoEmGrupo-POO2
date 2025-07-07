package model;

/**
 *
 * @author felip
 */
public class RefeicaoModel {

    //--------- VARIAVEIS
    private int idrefeicao;
    private String comida, dia_semana, horario;

    //--------- CONSTRUTORES
    public RefeicaoModel() {
        this.idrefeicao = 0;
        this.comida = "";
        this.dia_semana = "";
        this.horario = "";
    }

    public RefeicaoModel(int idrefeicao, String comida, String dia_semana, String horario) {
        this.idrefeicao = idrefeicao;
        this.comida = comida;
        this.dia_semana = dia_semana;
        this.horario = horario;
    }

    //--------- GETs
    public int getIdrefeicao() {
        return idrefeicao;
    }

    public String getComida() {
        return comida;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public String getHorario() {
        return horario;
    }

    //--------- SETs
    public void setIdrefeicao(int idrefeicao) {
        this.idrefeicao = idrefeicao;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    //--------- METODOS
}
