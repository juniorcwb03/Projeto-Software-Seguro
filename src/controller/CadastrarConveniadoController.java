package controller;

import dao.CadastroDAO;
import model.Conveniado;
import view.CadastroView;

public class CadastrarConveniadoController {
    // Variáveis
    private final CadastroView cadastroView = new CadastroView();

    public void cadastrarConveniado(Conveniado conveniado) {
        CadastroDAO cadastroDAO = new CadastroDAO();

        cadastroDAO.cadastrarConveniado(conveniado);

        for (int i = 0; i < cadastroView.qtdDeTelefones(); i++) {
            conveniado = cadastroView.cadastroConveniadoTelefone();
            cadastroDAO.cadastrarTelefoneConveniado(conveniado);
        }

        conveniado = cadastroView.cadastroConveniadoEndereco();
        cadastroDAO.cadastrarEnderecoConveniado(conveniado);
        // AVISO: AINDA FALTA VALIDAR SE O CADASTRO FOI FEITO COM SUCESSO OU NÃO
        // AVISO: AINDA FALTA VALIDAR SE O CADASTRO FOI FEITO COM SUCESSO OU NÃO
    }
}
