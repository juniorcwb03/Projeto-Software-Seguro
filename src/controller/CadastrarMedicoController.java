package controller;

import dao.CadastroDAO;
import model.Medico;
import view.CadastroView;

public class CadastrarMedicoController {
    // Variáveis
    private final CadastroView cadastroView = new CadastroView();
    private final CadastroDAO cadastroDAO = new CadastroDAO();

    public boolean cadastrarMedico(Medico medico) {
        cadastroView.cadastroMedico(medico);
        return cadastroDAO.cadastrarMedico(medico);
    }

    public boolean cadastrarTelefone(Medico medico) {
        int qtdDeTelefones;
        boolean rs = false;
        qtdDeTelefones = cadastroView.qtdDeTelefones();
        for (int i = 0; i < qtdDeTelefones; i++) {
             cadastroView.cadastroMedicoTelefone(medico);
            rs = cadastroDAO.cadastrarTelefoneMedico(medico);
        }

        return rs;
    }

    public boolean cadastrarEndereco(Medico medico) {
        cadastroView.cadastroMedicoEndereco(medico);

        return cadastroDAO.cadastrarEnderecoMedico(medico);
    }

    public Boolean buscarMedico(Medico medico) {
        cadastroView.buscarMedicoEditar(medico);

        return cadastroDAO.buscarMedico(medico);
    }
}
