package view;

import model.Conveniado;
import model.Medico;

import java.util.Scanner;

public class AutenticacaoView {
    // Variáveis
    Scanner sc;

    // Método Construtor da Classe
    public AutenticacaoView(Scanner sc) {
        this.sc = sc;
        this.sc = new Scanner(System.in);
    }

    // Método para login do usuário Conveniado, requer CPF e SENHA.
    public Conveniado loginConveniado(Conveniado conveniado) {
        System.out.println("Digite o CPF (Ex: xxx.xxx.xxx-xx):");
        conveniado.setCpf(sc.nextLine());
        System.out.println("Digite sua SENHA:");
        conveniado.setSenha(sc.nextLine());

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

    // Método para login de um usuário médico, requer CPF e SENHA.
    public Medico loginMedico(Medico medico) {
        System.out.println("Digite o CPF (Ex: xxx.xxx.xxx-xx):");
        medico.setCpf(sc.nextLine());
        System.out.println("Digite sua SENHA:");
        medico.setSenha(sc.nextLine());

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
