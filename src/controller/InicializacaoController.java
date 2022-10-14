package controller;

import dao.CadastroDAO;
import model.Conveniado;
import view.CadastroView;
import view.InicializacaoView;

public class InicializacaoController {
    // Variáveis:
    InicializacaoView inicializacaoView = new InicializacaoView();
    CadastrarConveniadoController cadastrarConveniadoController = new CadastrarConveniadoController();
    CadastroView cadastroView = new CadastroView();
    CadastroDAO cadastroDAO = new CadastroDAO();

    public InicializacaoController() {
        switch (inicializacaoView.opcaoDePagina()) {
            case 0:
                switch (inicializacaoView.opcaoDoUsuario()) {
                    case 0:
                        cadastrarConveniadoController.CadastrarConveniado(cadastroView.cadastroConveniado());
                        cadastrarConveniadoController.CadastrarConveniado(cadastroView.cadastroConveniadoTelefone());
                        cadastrarConveniadoController.CadastrarConveniado(cadastroView.cadastroConveniadoEndereco());
                }
        }
    }
}
