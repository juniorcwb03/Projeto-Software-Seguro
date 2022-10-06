package view;

import model.Conveniado;

import java.util.Scanner;

public class AutenticacaoView {
    // Variáveis
    Scanner sc;

    // Método Construtor da Classe
    public AutenticacaoView(Scanner sc) {
        this.sc = sc;
        this.sc = new Scanner(System.in);
    }

    // Método para login do usuário Conveniado, requer CPF, NOME COMPLETO e SENHA.
    public Conveniado login(Conveniado conveniado) {
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
}
