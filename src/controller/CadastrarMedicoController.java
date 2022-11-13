package controller;

import dao.CadastroDAO;
import model.Medico;
import view.CadastroView;

public class CadastrarMedicoController {
    // Variáveis
    private final CadastroView cadastroView = new CadastroView();
    private final CadastroDAO cadastroDAO = new CadastroDAO();

    public boolean cadastrarMedico(Medico medico) {

        return cadastroDAO.cadastrarMedico(medico);
    }

    public boolean cadastrarTelefone() {
        int qtdDeTelefones;
        boolean rs = false;
        qtdDeTelefones = cadastroView.qtdDeTelefones();
        for (int i = 0; i < qtdDeTelefones; i++) {
            Medico medico = cadastroView.cadastroMedicoTelefone();
            rs = cadastroDAO.cadastrarTelefoneMedico(medico);
        }

        return rs;
    }

    public boolean cadastrarEndereco() {
        Medico medico = cadastroView.cadastroMedicoEndereco();

        return cadastroDAO.cadastrarEnderecoMedico(medico);
    }
}
