package view;

import controller.SegurancaController;

public class ProgramView {
    // Variáveis:
    private final SegurancaController segurancaController = new SegurancaController();

    private String msgConsole;
    private static final String ERRO = "Entrada inválida, digite novamente!";
    private static final String OPCAO_INVALIDA = "Opção inválida, tente novamente!";

    public int opcaoDePagina() {
        int opcao;
        msgConsole = """
                ESCOLHA PARA QUAL PÁGINA DESEJA PROSSEGUIR:
                
                Opções:
                [0] - Cadastro
                [1] - Autenticar
                [2] - Editar um Conveniado
                [3] - Editar um medico
                Opção:\040""";
        opcao = segurancaController.lerInt(msgConsole, ERRO);

        while (opcao < 0 || opcao > 3) {
            System.out.println(ERRO);
            while (opcao < 0 || opcao > 1) {
                System.out.println(OPCAO_INVALIDA);
                opcao = segurancaController.lerInt(msgConsole, ERRO);
            }
        }

        return opcao;
    }


    public int opcaoDeCadastro() {
            int opcao;
            msgConsole = """
                    
                    ESCOLHA QUAL TIPO DE USUÁRIO DESEJA CADASTRAR:
                    
                    Opções:
                    [0] - Cadastrar um Conveniado
                    [1] - Cadastrar um Médico
                    Opção:\040""";
            opcao = segurancaController.lerInt(msgConsole, ERRO);
            while (opcao < 0 || opcao > 1) {
                System.out.println(OPCAO_INVALIDA);
                opcao = segurancaController.lerInt(msgConsole, ERRO);
            }

            return opcao;
        }

        public int opcaoDeAutenticacao() {
            int opcao;
            msgConsole = """
                    
                    ESCOLHA COMO QUAL USUÁRIO DO SISTEMA IRÁ SE AUTENTICAR:
                    Entrar como:
                    [0] - Conveniado
                    [1] - Médico
                    Opção:\040""";
            opcao = segurancaController.lerInt(msgConsole, ERRO);
            while (opcao < 0 || opcao > 1) {
                System.out.println(OPCAO_INVALIDA);
                opcao = segurancaController.lerInt(msgConsole, ERRO);
            }

            return opcao;
        }
}
