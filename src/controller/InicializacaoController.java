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
    Conveniado conveniado = new Conveniado();
    CadastroDAO cadastroDAO = new CadastroDAO();

    public InicializacaoController() {
        switch (inicializacaoView.opcaoDePagina()) {
            case 0:
                switch (inicializacaoView.opcaoDoUsuario()) {
                    case 0:
                        conveniado = cadastrarConveniadoController.CadastrarConveniado(cadastroView.cadastroConveniado());
                        conveniado = cadastrarConveniadoController.CadastrarConveniado(cadastroView.cadastroConveniadoTelefone());
                        cadastrarConveniadoController.CadastrarConveniado(cadastroView.cadastroConveniadoEndereco());
                        cadastroDAO.cadastrarConveniado(conveniado);

                }
        }
    }
}
