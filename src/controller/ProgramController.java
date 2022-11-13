package controller;

import view.CadastroView;
import view.ProgramView;

public class ProgramController {
    public ProgramController() {
        // Variáveis:
        ProgramView programView = new ProgramView();
        CadastroView cadastroView = new CadastroView();
        AutenticacaoController autenticacaoController = new AutenticacaoController();
        switch (programView.opcaoDePagina()) {
            case 0 -> {
                switch (programView.opcaoDeCadastro()) {
                    case 0 -> {
                        CadastrarConveniadoController cadastrarConveniadoController = new CadastrarConveniadoController();
                        boolean a = cadastrarConveniadoController.cadastrarConveniado(cadastroView.cadastroConveniado());
                        boolean b = cadastrarConveniadoController.cadastrarTelefone();
                        boolean c = cadastrarConveniadoController.cadastrarEndereco();
                        if (!a && b && c) {
                            cadastroView.conveniadoNaoCadastrado();
                        } else {
                            cadastroView.conveniadoCadastrado();
                            autenticacaoController.autenticarConveniado();

                        }
                    }
                    case 1 -> {
                        CadastrarMedicoController cadastrarMedicoController = new CadastrarMedicoController();
                        boolean a = cadastrarMedicoController.cadastrarMedico(cadastroView.cadastroMedico());
                        boolean b = cadastrarMedicoController.cadastrarTelefone();
                        boolean c = cadastrarMedicoController.cadastrarEndereco();
                        if (!a && b && c) {
                            cadastroView.medicoNaoCadastrado();
                        } else {
                            cadastroView.medicoCadastrado();
                            autenticacaoController.autenticarMedico();
                        }
                    }
                    default -> cadastroView.opcaoInvalida();
                }
            }
            case 1 -> {
                switch(programView.opcaoDeCadastro()) {
                    case 0 -> autenticacaoController.autenticarConveniado();
                    case 1 -> autenticacaoController.autenticarMedico();
                    default -> cadastroView.opcaoInvalida();
                }
            }
            default -> cadastroView.opcaoInvalida();
        }
    }
}
