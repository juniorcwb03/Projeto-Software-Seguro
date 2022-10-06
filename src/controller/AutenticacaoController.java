package controller;

import dao.AutenticacaoDAO;
import model.Conveniado;
import view.AutenticacaoView;

public class AutenticacaoController {
    // Variáveis
    private Conveniado conveniado;
    private AutenticacaoView autenticacaoView;
    private AutenticacaoDAO autenticacaoDAO;

    // Método para autenticar um usuário Conveniado
    public void autenticarConveniado() {
        conveniado = autenticacaoView.login(new Conveniado());
        autenticacaoDAO = new AutenticacaoDAO();

        if(autenticacaoDAO.autenticarConveniado(conveniado)){
            autenticacaoView.conveniadoAutenticado();
        }
        else {
            autenticacaoView.conveniadoNaoAutenticado();
        }
        // Lembrete: Restante do código
    }

    // Método para autenticar um usuário Médico
    public void autenticarMedico() {

    }
}
