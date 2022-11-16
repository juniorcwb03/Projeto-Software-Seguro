package view;

import controller.SecureController;
import model.Conveniado;
import model.Medico;

public class CadastroView {
    // Variáveis
    SecureController secureController = new SecureController();
    Conveniado conveniado = new Conveniado();
    Medico medico = new Medico();

    private String msgConsole;
    private static final String ERRO = "Entrada inválida, digite novamente!";

    public Conveniado cadastroConveniado(Conveniado conveniado) {
        msgConsole = "Digite o CPF apenas números (Ex: 499xxxxxx85):";
        conveniado.setCpf(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite seu NOME COMPLETO:";
        conveniado.setNomeCompleto(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite a SENHA:";
        conveniado.setSenha(secureController.lerString(msgConsole, ERRO));

        return conveniado;
    }

    public Conveniado cadastroConveniadoTelefone(Conveniado conveniado) {
        msgConsole = "Digite o número do telefone (Apenas números)";
        conveniado.setNumDeTelefone(secureController.lerFloat(msgConsole, ERRO));

        return conveniado;
    }

    public Conveniado cadastroConveniadoEndereco(Conveniado conveniado) {
        msgConsole = "Digite o CEP (Apenas números):";
        conveniado.setCep(secureController.lerFloat(msgConsole, ERRO));

        msgConsole = "Digite a RUA:";
        conveniado.setRuaDaCasa(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite o NÚMERO DA CASA:";
        conveniado.setNumDaCasa(secureController.lerFloat(msgConsole, ERRO));

        return conveniado;
    }

    // Mostrar que o usuário Conveniado foi cadastrado
    public void conveniadoCadastrado() {
        System.out.println("Sucesso no cadastro de um novo conveniado!");
    }

    // Mostrar que o usuário Conveniado não foi autenticado
    public void conveniadoNaoCadastrado() {
        System.out.println("Falha no cadastro!\nTente novamente!");
    }

    public Medico cadastroMedico(Medico medico) {
        msgConsole = "Digite o CPF apenas números (Ex: 499xxxxxx85):";
        medico.setCpf(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite seu NOME COMPLETO:";
        medico.setNomeCompleto(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite a ÁREA ATUANTE (Ex: Odonto):";
        medico.setAreaAtuante(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite a SENHA:";
        medico.setSenha(secureController.lerString(msgConsole, ERRO));

        return medico;
    }

    public Medico cadastroMedicoTelefone(Medico medico) {
        msgConsole = "Digite o número do telefone (Apenas números):";
        medico.setNumDeTelefone(secureController.lerFloat(msgConsole, ERRO));

        return medico;
    }

    public Medico cadastroMedicoEndereco(Medico medico) {
        msgConsole = "Digite o CEP (Apenas números):";
        medico.setCep(secureController.lerFloat(msgConsole, ERRO));

        msgConsole = "Digite a RUA:";
        medico.setRuaDaCasa(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite o NÚMERO DA CASA:";
        medico.setNumDaCasa(secureController.lerFloat(msgConsole, ERRO));

        return medico;
    }

    // Mostrar que o usuário Médico foi cadastrado
    public void medicoCadastrado() {
        System.out.println("Sucesso no cadastro de um novo médico no sistema!");
    }

    // Mostrar que o usuário Médico não foi autenticado
    public void medicoNaoCadastrado() {
        System.out.println("Falha no cadastro!\nTente novamente!");
    }

    public int qtdDeTelefones() {
        int qtdDeTelefones;
        msgConsole = "Quantos telefones deseja cadastrar (0 para nenhum):";
        qtdDeTelefones = secureController.lerInt(msgConsole, ERRO);

        return qtdDeTelefones;
    }

    public void opcaoInvalida() {
        System.out.println("Opção inválida, tente novamente!");
    }

    public Conveniado editarConveniado(Conveniado conveniado) {
        msgConsole = "Digite o CPF apenas números (Ex: 499xxxxxx85):";
        conveniado.setCpf(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite seu NOME COMPLETO:";
        conveniado.setNomeCompleto(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite a SENHA:";
        conveniado.setSenha(secureController.lerString(msgConsole, ERRO));

        return conveniado;
    }



    public Conveniado editarConveniadoTelefone(Conveniado conveniado) {
        msgConsole = "Digite o número do telefone (Apenas números)";
        conveniado.setNumDeTelefone(secureController.lerFloat(msgConsole, ERRO));

        return conveniado;
    }

    public Conveniado editarConveniadoEndereco(Conveniado conveniado) {
        msgConsole = "Digite o CEP (Apenas números):";
        conveniado.setCep(secureController.lerFloat(msgConsole, ERRO));

        msgConsole = "Digite a RUA:";
        conveniado.setRuaDaCasa(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite o NÚMERO DA CASA:";
        conveniado.setNumDaCasa(secureController.lerFloat(msgConsole, ERRO));

        return conveniado;
    }

    public Conveniado buscarConveniadoEditar(Conveniado conveniado) {
        msgConsole = "Digite o cpf que deseja alterar os registros";
        conveniado.setValidaCpf(secureController.lerString(msgConsole, ERRO));


        return conveniado;
    }

    public Medico buscarMedicoEditar(Medico medico) {
        msgConsole = "Digite o cpf que deseja alterar os registros";
        medico.setValidaCpf(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite a senha que deseja alterar os registros";
        medico.setValidaSenha(secureController.lerString(msgConsole, ERRO));


        return medico;
    }



    // Mostrar que o usuário Conveniado não foi autenticado
    public void conveniadoNaoEditado() {
        System.out.println("Falha, não editado!\nTente novamente!");
    }

    public Medico editarMedico(Medico medico) {
        msgConsole = "Digite o CPF apenas números (Ex: 499xxxxxx85):";
        medico.setCpf(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite seu NOME COMPLETO:";
        medico.setNomeCompleto(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite a ÁREA ATUANTE (Ex: Odonto):";
        medico.setAreaAtuante(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite a SENHA:";
        medico.setSenha(secureController.lerString(msgConsole, ERRO));

        return medico;
    }

    public Medico editarMedicoTelefone(Medico medico) {
        msgConsole = "Digite o número do telefone (Apenas números):";
        medico.setNumDeTelefone(secureController.lerFloat(msgConsole, ERRO));

        return medico;
    }

    public Medico editarMedicoEndereco(Medico medico) {
        msgConsole = "Digite o CEP (Apenas números):";
        medico.setCep(secureController.lerFloat(msgConsole, ERRO));

        msgConsole = "Digite a RUA:";
        medico.setRuaDaCasa(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite o NÚMERO DA CASA:";
        medico.setNumDaCasa(secureController.lerFloat(msgConsole, ERRO));

        return medico;
    }

    // Mostrar que o usuário Médico foi cadastrado
    public void editarCadastradoMedico() {
        System.out.println("Sucesso na edição de um  médico no sistema!");
    }

    // Mostrar que o usuário Médico não foi autenticado
    public void editarNaoCadastradoMedico() {
        System.out.println("Falha na edição!\nTente novamente!");
    }


    public void editarCadastradoCoveniado() {
        System.out.println("Sucesso na edição de um  conveniado no sistema!");
    }
}
