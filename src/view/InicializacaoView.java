package view;

import java.util.Scanner;

public class InicializacaoView {
    // Variáveis:
    Scanner sc = new Scanner(System.in);

    public int opcaoDePagina() {
        int opcao;
        System.out.println("Opções:\n[0] - Página de Cadastro\n[1] - Página de Autenticação\nOpção: ");
        opcao = sc.nextInt();
        while (opcao < 0 || opcao > 1) {
            System.out.println("Opção inválida, tente novamente!");
            System.out.println("Opções:\n[0] - Página de Cadastro\n[1] - Página de Autenticação\nOpção: ");
            opcao = sc.nextInt();
        }

        return opcao;
    }

    public int opcaoDoUsuario() {
        int opcao;
        System.out.println("Opções:\n[0] - Cadastrar um Conveniado\n[1] - Cadastrar um Médico\nOpção:");
        opcao = sc.nextInt();
        while (opcao < 0 || opcao > 1) {
            System.out.println("Opção inválida, tente novamente!");
            System.out.println("Opções:\n[0] - Cadastrar um Conveniado\\n[1] - Cadastrar um Médico\nOpção: ");
            opcao = sc.nextInt();
        }

        return opcao;
    }
}
