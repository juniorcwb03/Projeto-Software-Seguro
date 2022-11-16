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

    public String getValidaSenha() {
        return validaSenha;
    }

    public void setValidaSenha(String validaSenha) {
        this.validaSenha = validaSenha;
    }

    private Float numDeTelefone;
    private String validaSenha;

    public String getValidaCpf() {
        return validaCpf;
    }

    public void setValidaCpf(String validaCpf) {
        this.validaCpf = validaCpf;
    }

    private String validaCpf;

    // Métodos de Get e Set da classe
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    //teste
    public String getCpf() {
        return cpf;
    }
//teste
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
