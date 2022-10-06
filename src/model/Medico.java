package model;

public class Medico {
    // Variáveis
    private String nomeCompleto,
            cpf,
            enderecoConveniado,
            senha;
    private Float cep,
            telefone;

    // Métodos de Get e Set da classe
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEnderecoConveniado() {
        return enderecoConveniado;
    }

    public void setEnderecoConveniado(String enderecoConveniado) {
        this.enderecoConveniado = enderecoConveniado;
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

    public Float getTelefone() {
        return telefone;
    }

    public void setTelefone(Float telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
