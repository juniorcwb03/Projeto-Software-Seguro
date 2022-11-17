package controller;

import dao.CadastroDAO;
import model.Conveniado;
import view.CadastroView;

public class CadastrarConveniadoController {
    // Variáveis
    private final CadastroView cadastroView = new CadastroView();
    private final CadastroDAO cadastroDAO = new CadastroDAO();

    public boolean cadastrarConveniado(Conveniado conveniado) {
        cadastroView.cadastroConveniado(conveniado);
        return cadastroDAO.cadastrarConveniado(conveniado);
    }

    public boolean cadastrarTelefone(Conveniado conveniado) {
        int qtdDeTelefones;
        boolean rs = false;
        qtdDeTelefones = cadastroView.qtdDeTelefones();
        for (int i = 0; i < qtdDeTelefones; i++) {
            cadastroView.cadastroConveniadoTelefone(conveniado);
            rs = cadastroDAO.cadastrarTelefoneConveniado(conveniado);
        }

        return rs;
    }

    public boolean cadastrarEndereco(Conveniado conveniado) {
        cadastroView.cadastroConveniadoEndereco(conveniado);

        return cadastroDAO.cadastrarEnderecoConveniado(conveniado);
    }

    public Boolean buscarConveniado(Conveniado conveniado) {
        cadastroView.buscarConveniadoEditar(conveniado);

        return cadastroDAO.buscarConveniado(conveniado);
    }
}
