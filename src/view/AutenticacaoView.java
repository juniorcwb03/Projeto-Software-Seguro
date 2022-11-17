package view;

import controller.SegurancaController;
import model.Conveniado;
import model.Medico;


public class AutenticacaoView {
    // Variáveis
    SegurancaController segurancaController = new SegurancaController();

    private String msgConsole;
    private static final String ERRO = "Entrada inválida, digite novamente!";

    // Método para ‘login’ do usuário Conveniado, requer CPF e SENHA.
    public Conveniado loginConveniado(Conveniado conveniado) {
        System.out.println("\nPÁGINA DE LOGIN PARA CONVENIADO\n");
        msgConsole = "Digite o CPF (Ex: xxx.xxx.xxx-xx):";
        conveniado.setCpf(segurancaController.lerString(msgConsole, ERRO));

        msgConsole = "Digite sua SENHA:";
        conveniado.setSenha(segurancaController.lerString(msgConsole, ERRO));

        conveniado.setSenha(SegurancaController.fazerHash(conveniado.getSenha()));

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
        System.out.println("\nPÁGINA DE LOGIN PARA MÉDICOS\n");
        msgConsole = "Digite o CPF (Ex: xxx.xxx.xxx-xx):";
        medico.setCpf(segurancaController.lerString(msgConsole, ERRO));

        msgConsole = "Digite sua SENHA:";
        medico.setSenha(segurancaController.lerString(msgConsole, ERRO));

        medico.setSenha(SegurancaController.fazerHash(medico.getSenha()));
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
