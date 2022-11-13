package model;

public class Conveniado {
    // Variáveis
    private int id;
    private String nomeCompleto;
    private String cpf;
    private String senha;
    private String ruaDaCasa;
    private Float numDaCasa;
    private Float cep;
    private Float numDeTelefone;

    // Métodos de Get e Set da classe
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRuaDaCasa() {
        return ruaDaCasa;
    }

    public void setRuaDaCasa(String ruaDaCasa) {
        this.ruaDaCasa = ruaDaCasa;
    }

    public Float getNumDaCasa() {
        return numDaCasa;
    }

    public void setNumDaCasa(Float numDaCasa) {
        this.numDaCasa = numDaCasa;
    }

    public Float getCep() {
        return cep;
    }

    public void setCep(Float cep) {
        this.cep = cep;
    }

    public Float getNumDeTelefone() {
        return numDeTelefone;
    }

    public void setNumDeTelefone(Float numDeTelefone) {
        this.numDeTelefone = numDeTelefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
