package controller;

import dao.CadastroDAO;
import model.Conveniado;
import view.CadastroView;

public class CadastrarConveniadoController {
    // Variáveis
    private final CadastroView cadastroView = new CadastroView();
    private final CadastroDAO cadastroDAO = new CadastroDAO();

    public boolean cadastrarConveniado(Conveniado conveniado) {

        return cadastroDAO.cadastrarConveniado(conveniado);
    }

    public boolean cadastrarTelefone() {
        int qtdDeTelefones;
        boolean rs = false;
        qtdDeTelefones = cadastroView.qtdDeTelefones();
        for (int i = 0; i < qtdDeTelefones; i++) {
            Conveniado conveniado = cadastroView.cadastroConveniadoTelefone();
            rs = cadastroDAO.cadastrarTelefoneConveniado(conveniado);
        }

        return rs;
    }

    public boolean cadastrarEndereco() {
        Conveniado conveniado = cadastroView.cadastroConveniadoEndereco();

        return cadastroDAO.cadastrarEnderecoConveniado(conveniado);
    }
}
