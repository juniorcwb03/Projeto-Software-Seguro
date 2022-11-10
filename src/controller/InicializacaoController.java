package controller;

import view.CadastroView;
import view.InicializacaoView;

public class InicializacaoController {
    // Variáveis:
    InicializacaoView inicializacaoView = new InicializacaoView();
    CadastroView cadastroView = new CadastroView();
    AutenticacaoController autenticacaoController = new AutenticacaoController();
    CadastrarConveniadoController cadastrarConveniadoController = new CadastrarConveniadoController();
    CadastrarMedicoController cadastrarMedicoController = new CadastrarMedicoController();


    public InicializacaoController() {
        switch (inicializacaoView.opcaoDePagina()) {
            case 0 -> {
                switch (inicializacaoView.opcaoDoUsuario()) {
                    case 0 -> {
                        cadastrarConveniadoController.cadastrarConveniado(cadastroView.cadastroConveniado());
                        cadastrarConveniadoController.cadastrarConveniado(cadastroView.cadastroConveniadoTelefone());
                        cadastrarConveniadoController.cadastrarConveniado(cadastroView.cadastroConveniadoEndereco());
                    }
                    case 1 -> {
                        cadastrarMedicoController.cadastrarMedico(cadastroView.cadastroMedico());
                        cadastrarMedicoController.cadastrarMedico(cadastroView.cadastroMedicoTelefone());
                        cadastrarMedicoController.cadastrarMedico(cadastroView.cadastroMedicoEndereco());
                    }
                    default -> cadastroView.opcaoInvalida();
                }
            }
            case 1 -> {
                switch(inicializacaoView.opcaoDoUsuario()) {
                    case 0 -> autenticacaoController.autenticarConveniado();
                    case 1 -> autenticacaoController.autenticarMedico();
                    default -> cadastroView.opcaoInvalida();
                }
            }
            default -> cadastroView.opcaoInvalida();
        }
    }
}
