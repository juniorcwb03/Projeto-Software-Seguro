package controller;

import dao.CadastroDAO;
import model.Conveniado;
import view.CadastroView;

public class CadastrarConveniadoController {
    // Variáveis
    private Conveniado conveniado;
    private CadastroView cadastroView = new CadastroView();
    private CadastroDAO cadastroDAO = new CadastroDAO();

    public void CadastrarConveniado(Conveniado conveniado) {
        cadastroDAO = new CadastroDAO();

        this.conveniado = cadastroView.cadastroConveniado();
        cadastroDAO.cadastrarConveniado(this.conveniado);

        for (int i = 0; i < cadastroView.qtdDeTelefones(); i++) {
            this.conveniado = cadastroView.cadastroConveniadoTelefone();
            cadastroDAO.cadastrarTelefoneConveniado(this.conveniado);
        }

        this.conveniado = cadastroView.cadastroConveniadoEndereco();
        cadastroDAO.cadastrarEnderecoConveniado(this.conveniado);
        // AVISO: AINDA FALTA VALIDAR SE O CADASTRO FOI FEITO COM SUCESSO OU NÃO
        // AVISO: AINDA FALTA VALIDAR SE O CADASTRO FOI FEITO COM SUCESSO OU NÃO
    }
}
