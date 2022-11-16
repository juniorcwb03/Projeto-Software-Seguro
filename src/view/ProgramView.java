package view;

import controller.SecureController;

public class ProgramView {
    // Variáveis:
    private final SecureController secureController = new SecureController();

    private String msgConsole;
    private static final String ERRO = "Entrada inválida, digite novamente!";
    private static final String OPCAO_INVALIDA = "Opção inválida, tente novamente!";

    public int opcaoDePagina() {
        int opcao;
        msgConsole = "Opções:\n[0] - Cadastro\n[1] - Autenticar\n[2] - Editar um Conveniado\n[3] - Editar um medico\nOpção:";
        opcao = secureController.lerInt(msgConsole, ERRO);
<<<<<<< Updated upstream
        while (opcao < 0 || opcao > 3) {
            System.out.println("Opção inválida, tente novamente!");
=======
        while (opcao < 0 || opcao > 1) {
            System.out.println(OPCAO_INVALIDA);
>>>>>>> Stashed changes
            opcao = secureController.lerInt(msgConsole, ERRO);
        }

        return opcao;
    }

    public int opcaoDeCadastro() {
        int opcao;
        msgConsole = "Opções:\n[0] - Cadastrar um Conveniado\n[1] - Cadastrar um Médico\nOpção:";
        opcao = secureController.lerInt(msgConsole, ERRO);
        while (opcao < 0 || opcao > 1) {
            System.out.println(OPCAO_INVALIDA);
            opcao = secureController.lerInt(msgConsole, ERRO);
        }

        return opcao;
    }

    public int opcaoDeAutenticacao() {
        int opcao;
        msgConsole = "Entrar como:\n[0] - Conveniado\n[1] - Médico\nOpção:";
        opcao = secureController.lerInt(msgConsole, ERRO);
        while (opcao < 0 || opcao > 1) {
            System.out.println(OPCAO_INVALIDA);
            opcao = secureController.lerInt(msgConsole, ERRO);
        }

        return opcao;
    }
}
