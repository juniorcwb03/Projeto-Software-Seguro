package view;

import controller.SegurancaController;
import model.Conveniado;
import model.Medico;

public class CadastroView {
    // Variáveis
    SegurancaController segurancaController = new SegurancaController();

    private String msgConsole;
    private static final String ERRO = "Entrada inválida, digite novamente!";
    private static final String CPF = "Digite o CPF apenas números (Ex: 499xxxxxx85):";
    private static final String NOME_COMPLETO = "Digite seu NOME COMPLETO:";
    private static final String SENHA = "Digite a SENHA:";

    public void cadastroConveniado(Conveniado conveniado) {
        System.out.println("\nPÁGINA DE CADASTRO DE UM NOVO CONVENIADO\n");
        msgConsole = CPF;
        conveniado.setCpf(segurancaController.lerString(msgConsole, ERRO));

        msgConsole = NOME_COMPLETO;
        conveniado.setNomeCompleto(segurancaController.lerString(msgConsole, ERRO));

        msgConsole = SENHA;
        conveniado.setSenha(segurancaController.lerString(msgConsole, ERRO));
    }

    public void cadastroConveniadoTelefone(Conveniado conveniado) {
        msgConsole = "Digite o número do telefone (Apenas números)";
        conveniado.setNumDeTelefone(segurancaController.lerFloat(msgConsole, ERRO));
    }

    public void cadastroConveniadoEndereco(Conveniado conveniado) {
        msgConsole = "Digite o CEP (Apenas números):";
        conveniado.setCep(segurancaController.lerFloat(msgConsole, ERRO));

        msgConsole = "Digite a RUA:";
        conveniado.setRuaDaCasa(segurancaController.lerString(msgConsole, ERRO));

        msgConsole = "Digite o NÚMERO DA CASA:";
        conveniado.setNumDaCasa(segurancaController.lerFloat(msgConsole, ERRO));
    }

    // Mostrar que o usuário Conveniado foi cadastrado
    public void conveniadoCadastrado() {
        System.out.println("Sucesso no cadastro de um novo conveniado!");
    }

    // Mostrar que o usuário Conveniado não foi autenticado
    public void conveniadoNaoCadastrado() {
        System.out.println("Falha no cadastro!\nTente novamente!");
    }

    public void cadastroMedico(Medico medico) {
        System.out.println("\nPÁGINA DE CADASTRO DE UM NOVO MÉDICO\n");
        msgConsole = CPF;
        medico.setCpf(segurancaController.lerString(msgConsole, ERRO));

        msgConsole = NOME_COMPLETO;
        medico.setNomeCompleto(segurancaController.lerString(msgConsole, ERRO));

        msgConsole = "Digite a ÁREA ATUANTE (Ex: Odonto):";
        medico.setAreaAtuante(segurancaController.lerString(msgConsole, ERRO));

        msgConsole = SENHA;
        medico.setSenha(segurancaController.lerString(msgConsole, ERRO));
    }

    public void cadastroMedicoTelefone(Medico medico) {
        msgConsole = "Digite o número do telefone (Apenas números):";
        medico.setNumDeTelefone(segurancaController.lerFloat(msgConsole, ERRO));
    }

    public void cadastroMedicoEndereco(Medico medico) {
        msgConsole = "Digite o CEP (Apenas números):";
        medico.setCep(segurancaController.lerFloat(msgConsole, ERRO));

        msgConsole = "Digite a RUA:";
        medico.setRuaDaCasa(segurancaController.lerString(msgConsole, ERRO));

        msgConsole = "Digite o NÚMERO DA CASA:";
        medico.setNumDaCasa(segurancaController.lerFloat(msgConsole, ERRO));
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
        qtdDeTelefones = segurancaController.lerInt(msgConsole, ERRO);

        return qtdDeTelefones;
    }

    public void opcaoInvalida() {
        System.out.println("Opção inválida, tente novamente!");
    }

    public void buscarConveniadoEditar(Conveniado conveniado) {
        System.out.println("\nPÁGINA DE BUSCA PARA CONVENIADOS REGISTRADOS NO SISTEMA\n");
        msgConsole = "Digite o cpf que deseja alterar os registros";
        conveniado.setValidaCpf(segurancaController.lerString(msgConsole, ERRO));
    }

    public void buscarMedicoEditar(Medico medico) {
        System.out.println("\nPÁGINA DE BUSCA PARA MÉDICOS REGISTRADOS NO SISTEMA\n");
        msgConsole = "Digite o cpf que deseja alterar os registros";
        medico.setValidaCpf(segurancaController.lerString(msgConsole, ERRO));

        msgConsole = "Digite a senha que deseja alterar os registros";
        medico.setValidaSenha(segurancaController.lerString(msgConsole, ERRO));
    }
    
    // Mostrar que o usuário Conveniado não foi autenticado
    public void conveniadoNaoEditado() {
        System.out.println("Falha, não editado!\nTente novamente!");
    }

    // Mostrar que o usuário Médico foi cadastrado
    public void editarCadastradoMedico() {
        System.out.println("Sucesso na edição de um médico no sistema!");
    }

    // Mostrar que o usuário Médico não foi autenticado
    public void editarNaoCadastradoMedico() {
        System.out.println("Falha na edição!\nTente novamente!");
    }


    public void editarCadastradoCoveniado() {
        System.out.println("Sucesso na edição de um conveniado no sistema!");
    }
}
