package controller;

import dao.CadastroDAO;
import model.Medico;
import view.CadastroView;

public class CadastrarMedicoController {
    // Variáveis
    private final CadastroView cadastroView = new CadastroView();

    public void cadastrarMedico(Medico medico) {
        CadastroDAO cadastroDAO = new CadastroDAO();

        cadastroDAO.cadastrarMedico(medico);

        for (int i = 0; i < cadastroView.qtdDeTelefones(); i++) {
            medico = cadastroView.cadastroMedicoTelefone();
            cadastroDAO.cadastrarTelefoneMedico(medico);
        }

        medico = cadastroView.cadastroMedicoEndereco();
        cadastroDAO.cadastrarEnderecoMedico(medico);

        // AVISO: AINDA FALTA VALIDAR SE O CADASTRO FOI FEITO COM SUCESSO OU NÃO
        // AVISO: AINDA FALTA VALIDAR SE O CADASTRO FOI FEITO COM SUCESSO OU NÃO
    }
}
