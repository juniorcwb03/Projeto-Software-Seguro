package view;

import java.util.Scanner;

public class InicializacaoView {
    // Variáveis:
    Scanner sc;

    // Método construtor
    public InicializacaoView(Scanner sc) {
        this.sc = sc;
        this.sc = new Scanner(System.in);
    }
    public void opcaoDoUsuario() {
        int opcao = 0;
        System.out.println("Opções:\n[0] - Página de Cadastro\n[1] - Página de Autenticação\nOpção:");
        opcao = sc.nextInt();

        switch (opcao) {
            case 0:
                CadastroView cadastroView;
                // AVISO: AINDA NÃO SEI COMO INICIALIZAR O PROGRAMA KKKKKKKKKKK
        }
    }
}
