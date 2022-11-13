package view;

import controller.SecureController;

public class ProgramView {
    // Variáveis:
    private final SecureController secureController = new SecureController();

    private String msgConsole;
    private static final String ERRO = "Entrada inválida, digite novamente!";

    public int opcaoDePagina() {
        int opcao;
        msgConsole = "Opções:\n[0] - Página de Cadastro\n[1] - Página de Autenticação\nOpção: ";
        opcao = secureController.lerInt(msgConsole, ERRO);
        while (opcao < 0 || opcao > 1) {
            System.out.println("Opção inválida, tente novamente!");
            opcao = secureController.lerInt(msgConsole, ERRO);
        }

        return opcao;
    }

    public int opcaoDeCadastro() {
        int opcao;
        msgConsole = "Opções:\n[0] - Cadastrar um Conveniado\n[1] - Cadastrar um Médico\nOpção:";
        opcao = secureController.lerInt(msgConsole, ERRO);
        while (opcao < 0 || opcao > 1) {
            System.out.println("Opção inválida, tente novamente!");
            opcao = secureController.lerInt(msgConsole, ERRO);
        }

        return opcao;
    }
}
