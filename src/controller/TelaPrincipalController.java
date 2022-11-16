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
                if (!telaPrincipalDAO.marcarConsulta(consulta)) {
                    telaPrincipalView.consultaMarcada();
                } else {
                    telaPrincipalView.consultaNaoMarcada();
                }
            }
            case 2 -> {}
            case 3 -> {}
            default -> telaPrincipalView.opcaoInvalida();
        }
    }

    public void menuPrincipalMedico() {

    }
}
