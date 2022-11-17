package view;

import controller.SegurancaController;
import model.Consulta;

public class TelaPrincipalView {
    private final SegurancaController segurancaController = new SegurancaController();

    private String msgConsole;
    private static final String ERRO = "Entrada inválida, digite novamente!";
    private static final String OPCAO_INVALIDA = "Opção inválida, tente novamente!";

    public int menuPrincipal() {
        int opcao;
        msgConsole = """
                
                Menu de funcionalidades:
                [1] - Marcar Consulta
                [2] - Alterar data/horário da Consulta
                [3] - Excluir uma consulta
                Opção:\040""";

        opcao = segurancaController.lerInt(msgConsole, ERRO);
        while (opcao < 0 || opcao > 3) {
            System.out.println(OPCAO_INVALIDA);
            opcao = segurancaController.lerInt(msgConsole, ERRO);
        }

        return opcao;
    }

    public Consulta marcarConsulta() {
        Consulta consulta = new Consulta();
        msgConsole = "Digite a data em que irá marcar a consulta (Ex:26/12/2022):";
        String data = segurancaController.lerString(msgConsole, ERRO);
        consulta.setData(data);

        msgConsole = "Digite a horá do dia em que irá marcar a consulta (Ex:16:40):";
        String hora = segurancaController.lerString(msgConsole, ERRO);
        consulta.setHora(hora);

        return consulta;
    }

    public int menuPrincipalMedico() {
        int opcao;
        msgConsole = """
                Menu de funcionalidades:
                [1] - Ver consultas
                [2] - Registrar nova ocorrência de saúde""";

        opcao = segurancaController.lerInt(msgConsole, ERRO);
        while (opcao < 0 || opcao > 1) {
            System.out.println(OPCAO_INVALIDA);
            opcao = segurancaController.lerInt(msgConsole, ERRO);
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

    public void consultaNaoAtualizada() {
        System.out.println("A consulta não foi atualizada devido algum erro!");
    }

    public Consulta idDaConsulta(Consulta consulta) {
        msgConsole = "Digite o ID da consulta que deseja excluir: ";
        int id = segurancaController.lerInt(msgConsole, ERRO);
        consulta.setId(id);

        return consulta;
    }

    public void consultaNaoDeletada() {
        System.out.println("A consulta não foi deletada devido algum erro!");
    }

    public void consultaDeletada() {
        System.out.println("A consulta foi deletada com sucesso!");
    }
}
