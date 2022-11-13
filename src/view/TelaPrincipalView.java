package view;

import controller.SecureController;
import model.Consulta;

public class TelaPrincipalView {
    private final SecureController secureController = new SecureController();

    private String msgConsole;
    private static final String ERRO = "Entrada inválida, digite novamente!";
    private static final String OPCAO_INVALIDA = "Opção inválida, tente novamente!";

    public int menuPrincipal() {
        int opcao;
        msgConsole = """
                Menu de funcionalidades:
                [1] - Marcar Consulta
                [2] - Alterar data/horário da Consulta
                [3] - Ver data da última consulta""";

        opcao = secureController.lerInt(msgConsole, ERRO);
        while (opcao < 0 || opcao > 1) {
            System.out.println(OPCAO_INVALIDA);
            opcao = secureController.lerInt(msgConsole, ERRO);
        }

        return opcao;
    }

    public Consulta marcarConsulta() {
        Consulta consulta = new Consulta();
        msgConsole = "Digite a data em que irá marcar a consulta (Ex:26/12/2022):";
        String data = secureController.lerString(msgConsole, ERRO);
        consulta.setData(data);

        msgConsole = "Digite a horá do dia em que irá marcar a consulta (Ex:16:40):";
        String hora = secureController.lerString(msgConsole, ERRO);
        consulta.setHora(hora);

        return consulta;
    }

    public int menuPrincipalMedico() {
        int opcao;
        msgConsole = """
                Menu de funcionalidades:
                [1] - Ver consultas
                [2] - Registrar nova ocorrência de saúde""";

        opcao = secureController.lerInt(msgConsole, ERRO);
        while (opcao < 0 || opcao > 1) {
            System.out.println(OPCAO_INVALIDA);
            opcao = secureController.lerInt(msgConsole, ERRO);
        }

        return opcao;
    }

    public void opcaoInvalida() {
        System.out.println(OPCAO_INVALIDA);
    }

    public void consultaNaoMarcada() {
        System.out.println("A consulta não foi marcada devido algum erro!");
    }

    public void consultaMarcada() {
        System.out.println("Consulta marcada com sucesso!");
    }
}
