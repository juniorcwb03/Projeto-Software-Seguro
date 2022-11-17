package controller;

import model.Conveniado;
import model.Medico;
import view.CadastroView;
import view.ProgramView;

public class ProgramaController {
    public ProgramaController() {
        // Variáveis:
        ProgramView programView = new ProgramView();
        CadastroView cadastroView = new CadastroView();
        AutenticacaoController autenticacaoController = new AutenticacaoController();
        CadastrarConveniadoController cadastrarConveniadoController = new CadastrarConveniadoController();

        switch (programView.opcaoDePagina()) {
            case 0 -> {
                switch (programView.opcaoDeCadastro()) {
                    case 0 -> {
                        Conveniado conveniado = new Conveniado();
                        boolean a = cadastrarConveniadoController.cadastrarConveniado(conveniado);
                        boolean b = cadastrarConveniadoController.cadastrarTelefone(conveniado);
                        boolean c = cadastrarConveniadoController.cadastrarEndereco(conveniado);

                        if (!a && !b && !c) {
                            cadastroView.conveniadoNaoCadastrado();
                        } else {
                            cadastroView.conveniadoCadastrado();
                            autenticacaoController.autenticarConveniado();
                        }
                    }
                    case 1 -> {
                        CadastrarMedicoController cadastrarMedicoController = new CadastrarMedicoController();
                        Medico medico = new Medico();
                        boolean a = cadastrarMedicoController.cadastrarMedico(medico);
                        boolean b = cadastrarMedicoController.cadastrarTelefone(medico);
                        boolean c = cadastrarMedicoController.cadastrarEndereco(medico);

                        if (!a && !b && !c) {
                            cadastroView.medicoNaoCadastrado();
                        } else {
                            cadastroView.medicoCadastrado();
                            autenticacaoController.autenticarMedico();
                        }
                    }
                    default -> cadastroView.opcaoInvalida();
                }
            }
            case 1 -> {
                switch(programView.opcaoDeAutenticacao()) {
                    case 0 -> autenticacaoController.autenticarConveniado();
                    case 1 -> autenticacaoController.autenticarMedico();
                    default -> cadastroView.opcaoInvalida();
                }
            }
            case 2 -> {
                Conveniado conveniado = new Conveniado();
                if(Boolean.TRUE.equals(cadastrarConveniadoController.buscarConveniado(conveniado))) {
                    boolean a = cadastrarConveniadoController.cadastrarConveniado(conveniado);
                    boolean b = cadastrarConveniadoController.cadastrarTelefone(conveniado);
                    boolean c = cadastrarConveniadoController.cadastrarEndereco(conveniado);

                    if (!a && !b && !c) {
                        cadastroView.conveniadoNaoEditado();
                    } else {
                        cadastroView.editarCadastradoCoveniado();
                    }
                }else{
                    cadastroView.conveniadoNaoEditado();
                }
            }
            case 3 -> {
                CadastrarMedicoController cadastrarMedicoController = new CadastrarMedicoController();
                Medico medico = new Medico();
                if(Boolean.TRUE.equals(cadastrarMedicoController.buscarMedico(medico))) {
                    boolean a = cadastrarMedicoController.cadastrarMedico(medico);
                    boolean b = cadastrarMedicoController.cadastrarTelefone(medico);
                    boolean c = cadastrarMedicoController.cadastrarEndereco(medico);

                    if (!a && !b && !c) {
                        cadastroView.editarNaoCadastradoMedico();
                    } else {
                        cadastroView.editarCadastradoMedico();
                    }
                }else{
                    cadastroView.editarNaoCadastradoMedico();
                }
            }
            default -> cadastroView.opcaoInvalida();
        }
    }
}
