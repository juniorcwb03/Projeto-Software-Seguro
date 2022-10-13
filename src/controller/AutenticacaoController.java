package controller;

import dao.AutenticacaoDAO;
import model.Conveniado;
import model.Medico;
import view.AutenticacaoView;

public class AutenticacaoController {
    // Variáveis
    private Conveniado conveniado;
    private Medico medico;
    private AutenticacaoView autenticacaoView;
    private AutenticacaoDAO autenticacaoDAO;

    // Método para autenticar um usuário Conveniado
    public void autenticarConveniado() {
        conveniado = autenticacaoView.loginConveniado(new Conveniado());
        autenticacaoDAO = new AutenticacaoDAO();

        if(autenticacaoDAO.autenticarConveniado(conveniado)){
            autenticacaoView.conveniadoAutenticado();
        }
        else {
            autenticacaoView.conveniadoNaoAutenticado();
        }
    }

    // Método para autenticar um usuário Médico
    public void autenticarMedico() {
        medico = autenticacaoView.loginMedico(new Medico());
        autenticacaoDAO = new AutenticacaoDAO();

        if (autenticacaoDAO.autenticarMedico(medico)) {
            autenticacaoView.medicoAutenticado();
        }
        else {
            autenticacaoView.medicoNaoAutenticado();
        }
    }
}
