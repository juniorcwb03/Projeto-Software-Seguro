package controller;

import dao.AutenticacaoDAO;
import model.Conveniado;
import model.Medico;
import view.AutenticacaoView;

public class AutenticacaoController {
    private final AutenticacaoView autenticacaoView = new AutenticacaoView();
    private AutenticacaoDAO autenticacaoDAO;

    // Método para autenticar um usuário Conveniado
    public void autenticarConveniado() {
        // Variáveis
        Conveniado conveniado = autenticacaoView.loginConveniado(new Conveniado());
        autenticacaoDAO = new AutenticacaoDAO();

        if(Boolean.TRUE.equals(autenticacaoDAO.autenticarConveniado(conveniado))){
            autenticacaoView.conveniadoAutenticado();
        }
        else {
            autenticacaoView.conveniadoNaoAutenticado();
        }
    }

    // Método para autenticar um usuário Médico
    public void autenticarMedico() {
        Medico medico = autenticacaoView.loginMedico(new Medico());
        autenticacaoDAO = new AutenticacaoDAO();

        if (Boolean.TRUE.equals(autenticacaoDAO.autenticarMedico(medico))) {
            autenticacaoView.medicoAutenticado();
        }
        else {
            autenticacaoView.medicoNaoAutenticado();
        }
    }
}
