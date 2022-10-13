package controller;

import dao.CadastroDAO;
import model.Conveniado;
import model.Medico;
import view.CadastroView;

public class CadastroController {
    // Variáveis
    private Conveniado conveniado;
    private Medico medico;
    private CadastroView cadastroView;
    private CadastroDAO cadastroDAO;

    public void cadastrarConveniado() {
        cadastroDAO = new CadastroDAO();

        conveniado = cadastroView.cadastroConveniado(new Conveniado());
        cadastroDAO.cadastrarConveniado(conveniado);

        for (int i = 0; i < cadastroView.qtdDeTelefones(); i++) {
            conveniado = cadastroView.cadastroConveniadoTelefone(new Conveniado());
            cadastroDAO.cadastrarTelefoneConveniado(conveniado);
        }

        conveniado = cadastroView.cadastroConveniadoEndereco(new Conveniado());
        cadastroDAO.cadastrarEnderecoConveniado(conveniado);
        // AVISO: AINDA FALTA VALIDAR SE O CADASTRO FOI FEITO COM SUCESSO OU NÃO
        // AVISO: AINDA FALTA VALIDAR SE O CADASTRO FOI FEITO COM SUCESSO OU NÃO
    }

    public void cadastrarMedico() {
        cadastroDAO = new CadastroDAO();

        medico = cadastroView.cadastroMedico(new Medico());
        cadastroDAO.cadastrarMedico(medico);

        for (int i = 0; i < cadastroView.qtdDeTelefones(); i++) {
            medico = cadastroView.cadastroMedicoTelefone(new Medico());
            cadastroDAO.cadastrarTelefoneMedico(medico);
        }

        medico = cadastroView.cadastroMedicoEndereco(new Medico());
        cadastroDAO.cadastrarEnderecoMedico(medico);
        // AVISO: AINDA FALTA VALIDAR SE O CADASTRO FOI FEITO COM SUCESSO OU NÃO
        // AVISO: AINDA FALTA VALIDAR SE O CADASTRO FOI FEITO COM SUCESSO OU NÃO
    }
}
