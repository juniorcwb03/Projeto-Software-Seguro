package controller;

import dao.CadastroDAO;
import model.Conveniado;
import model.Medico;
import view.CadastroView;


public class CadastrarMedicoController {
    // Variáveis
    private Medico medico;
    private CadastroView cadastroView;
    private CadastroDAO cadastroDAO;

    public void CadastrarMedico(Conveniado conveniado) {
        cadastroDAO = new CadastroDAO();

        this.medico = cadastroView.cadastroMedico();
        cadastroDAO.cadastrarMedico(this.medico);

        for (int i = 0; i < cadastroView.qtdDeTelefones(); i++) {
            this.medico = cadastroView.cadastroMedicoTelefone();
            cadastroDAO.cadastrarTelefoneMedico(this.medico);
        }

        this.medico = cadastroView.cadastroMedicoEndereco();
        cadastroDAO.cadastrarEnderecoMedico(this.medico);
        // AVISO: AINDA FALTA VALIDAR SE O CADASTRO FOI FEITO COM SUCESSO OU NÃO
        // AVISO: AINDA FALTA VALIDAR SE O CADASTRO FOI FEITO COM SUCESSO OU NÃO
    }
}
