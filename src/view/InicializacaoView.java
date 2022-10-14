package view;

import java.util.Scanner;

public class InicializacaoView {
    // Variáveis:
    Scanner sc = new Scanner(System.in);

    public int opcaoDePagina() {
        int opcao = 0;
        System.out.println("Opções:\n[0] - Página de Cadastro\n[1] - Página de Autenticação\nOpção: ");
        opcao = sc.nextInt();

        return opcao;
    }

    public int opcaoDoUsuario() {
        int opcao = 0;
        System.out.println("Opções:\n[0] - Cadastrar um Conveniado\n[1] - Cadastrar um Médico");
        opcao = sc.nextInt();

        return opcao;
    }
}
