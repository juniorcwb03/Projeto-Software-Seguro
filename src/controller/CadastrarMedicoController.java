package controller;

import dao.CadastroDAO;
import model.Conveniado;
import model.Medico;
import view.CadastroView;

public class CadastrarMedicoController {
    // Variáveis
    private final CadastroView cadastroView = new CadastroView();
    private final CadastroDAO cadastroDAO = new CadastroDAO();

    public boolean cadastrarMedico(Medico medico) {

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

    public boolean editarMedico(Medico medico) {

        return cadastroDAO.editarMedico(medico);
    }

    public boolean editarTelefone(Medico medico) {
        int qtdDeTelefones;
        boolean rs = false;
        qtdDeTelefones = cadastroView.qtdDeTelefones();
        for (int i = 0; i < qtdDeTelefones; i++) {
            cadastroView.editarMedicoTelefone(medico);
            rs = cadastroDAO.editarTelefoneMedico(medico);
        }

        return rs;
    }

    public boolean editarEndereco(Medico medico) {
        cadastroView.editarMedicoEndereco(medico);

        return cadastroDAO.editarEnderecoMedico(medico);
    }

    public Boolean buscarMedico(Medico medico) {
        cadastroView.buscarMedicoEditar(medico);

        return cadastroDAO.buscarMedico(medico);
    }
}
