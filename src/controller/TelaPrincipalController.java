package controller;

import dao.TelaPrincipalDAO;
import model.Consulta;
import view.TelaPrincipalView;

public class TelaPrincipalController {
    private final TelaPrincipalDAO telaPrincipalDAO = new TelaPrincipalDAO();
    private final TelaPrincipalView telaPrincipalView = new TelaPrincipalView();

    public void menuPrincipal() {
        switch (telaPrincipalView.menuPrincipal()) {
            case 1 -> {
                Consulta consulta = new Consulta();
                consulta = telaPrincipalView.marcarConsulta();
                boolean sucesso = telaPrincipalDAO.marcarConsulta(consulta);
                if (sucesso) {
                    telaPrincipalView.consultaMarcada();
                } else {
                    telaPrincipalView.consultaNaoMarcada();
                }
            }
            case 2 -> {
                Consulta consulta = new Consulta();
                consulta = telaPrincipalView.marcarConsulta();
                boolean sucesso = telaPrincipalDAO.atualizarConsulta(consulta);
                if (sucesso) {
                    telaPrincipalView.consultaMarcada();
                } else {
                    telaPrincipalView.consultaNaoAtualizada();
                }
            }
            case 3 -> {
                Consulta consulta = new Consulta();
                consulta = telaPrincipalView.idDaConsulta(consulta);
                boolean sucesso = telaPrincipalDAO.deletarConsulta(consulta);
                if (sucesso) {
                    telaPrincipalView.consultaDeletada();
                } else {
                    telaPrincipalView.consultaNaoDeletada();
                }
            }
            default -> telaPrincipalView.opcaoInvalida();
        }
    }

    public void menuPrincipalMedico() {

    }
}
