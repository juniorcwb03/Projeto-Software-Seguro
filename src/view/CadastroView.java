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

    public Conveniado cadastroConveniado() {
        msgConsole = "Digite o CPF apenas números (Ex: 499xxxxxx85):";
        conveniado.setCpf(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite seu NOME COMPLETO:";
        conveniado.setNomeCompleto(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite a SENHA:";
        conveniado.setSenha(secureController.lerString(msgConsole, ERRO));

        return conveniado;
    }

    public Conveniado cadastroConveniadoTelefone() {
        msgConsole = "Digite o número do telefone (Apenas números)";
        conveniado.setNumDeTelefone(secureController.lerFloat(msgConsole, ERRO));

        return conveniado;
    }

    public Conveniado cadastroConveniadoEndereco() {
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

    public Medico cadastroMedico() {
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

    public Medico cadastroMedicoTelefone() {
        msgConsole = "Digite o número do telefone (Apenas números):";
        medico.setNumDeTelefone(secureController.lerFloat(msgConsole, ERRO));

        return medico;
    }

    public Medico cadastroMedicoEndereco() {
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
}
