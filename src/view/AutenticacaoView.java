package view;

import controller.SecureController;
import model.Conveniado;
import model.Medico;


public class AutenticacaoView {
    // Variáveis
    SecureController secureController = new SecureController();

    private String msgConsole;
    private static final String ERRO = "Entrada inválida, digite novamente!";

    // Método para ‘login’ do usuário Conveniado, requer CPF e SENHA.
    public Conveniado loginConveniado(Conveniado conveniado) {
        msgConsole = "Digite o CPF (Ex: xxx.xxx.xxx-xx):";
        conveniado.setCpf(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite sua SENHA:";
        conveniado.setSenha(secureController.lerString(msgConsole, ERRO));

        return conveniado;
    }

    // Mostrar que o usuário Conveniado foi autenticado
    public void conveniadoAutenticado() {
        System.out.println("Sucesso na autenticação!\nBem vindo!");
    }

    // Mostrar que o usuário Conveniado não foi autenticado
    public void conveniadoNaoAutenticado() {
        System.out.println("Falha na autenticação!\nTente novamente!");
    }

    // Método para ‘login’ de um usuário médico, requer CPF e SENHA.
    public Medico loginMedico(Medico medico) {
        msgConsole = "Digite o CPF (Ex: xxx.xxx.xxx-xx):";
        medico.setCpf(secureController.lerString(msgConsole, ERRO));

        msgConsole = "Digite sua SENHA:";
        medico.setSenha(secureController.lerString(msgConsole, ERRO));

        return medico;
    }

    // Mostrar que o usuário Médico foi autenticado
    public void medicoAutenticado() {
        System.out.println("Sucesso na autenticação como Médico no sistema!");
    }

    // Mostrar que o usuário Médico não foi autenticado
    public void medicoNaoAutenticado() {
        System.out.println("Falha na autenticação no sistema\nTente novamente!");
    }
}
