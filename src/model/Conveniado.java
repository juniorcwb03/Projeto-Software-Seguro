package model;

public class Conveniado {
    // Variáveis
    private String nomeCompleto,
            cpf,
            senha,
            enderecoConveniado;
    private Float cep,
            numDeTelefone;

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

    public String getEnderecoConveniado() {
        return enderecoConveniado;
    }

    public void setEnderecoConveniado(String enderecoConveniado) {
        this.enderecoConveniado = enderecoConveniado;
    }
}
