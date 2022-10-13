package view;

import model.Conveniado;
import model.Medico;

import java.util.Scanner;

public class CadastroView {
    // Variáveis
    Scanner sc;

    // Método Construtor da Classe
    public CadastroView(Scanner sc) {
        this.sc = sc;
        this.sc = new Scanner(System.in);
    }

    public Conveniado cadastroConveniado(Conveniado conveniado) {
        System.out.println("Digite o CPF (Ex: xxx.xxx.xxx-xx):");
        conveniado.setCpf(sc.nextLine());
        System.out.println("Digite seu NOME COMPLETO:");
        conveniado.setNomeCompleto(sc.nextLine());
        System.out.println("Digite a SENHA:");
        conveniado.setSenha(sc.nextLine());


        return conveniado;
    }

    public Conveniado cadastroConveniadoTelefone(Conveniado conveniado) {
        System.out.println("Digite o número do telefone (Apenas números):");
        conveniado.setNumDeTelefone(sc.nextFloat());

        return conveniado;
    }

    public Conveniado cadastroConveniadoEndereco(Conveniado conveniado) {
        System.out.println("Digite o CEP (Apenas números):");
        conveniado.setCep(sc.nextFloat());
        System.out.println("Digite a RUA:");
        conveniado.setRuaDaCasa(sc.nextLine());
        System.out.println("Digite o NÚMERO DA CASA:");
        conveniado.setNumDaCasa(sc.nextFloat());

        return conveniado;
    }

    // Mostrar que o usuário Conveniado foi autenticado
    public void conveniadoCadastrado() {
        System.out.println("Sucesso no cadastro de um novo conveniado!");
    }

    // Mostrar que o usuário Conveniado não foi autenticado
    public void conveniadoNaoCadastrado() {
        System.out.println("Falha no cadastro!\nTente novamente!");
    }

    public Medico cadastroMedico(Medico medico) {
        System.out.println("Digite o CPF (Ex: xxx.xxx.xxx-xx):");
        medico.setCpf(sc.nextLine());
        System.out.println("Digite seu NOME COMPLETO:");
        medico.setNomeCompleto(sc.nextLine());
        System.out.println("Digite a ÁREA ATUANTE (Ex: Odonto):");
        medico.setAreaAtuante(sc.nextLine());
        System.out.println("Digite a SENHA:");
        medico.setSenha(sc.nextLine());

        return medico;
    }

    public Medico cadastroMedicoTelefone(Medico medico) {
        System.out.println("Digite o número do telefone (Apenas números):");
        medico.setNumDeTelefone(sc.nextFloat());

        return medico;
    }

    public Medico cadastroMedicoEndereco(Medico medico) {
        System.out.println("Digite o CEP (Apenas números):");
        medico.setCep(sc.nextFloat());
        System.out.println("Digite a RUA:");
        medico.setRuaDaCasa(sc.nextLine());
        System.out.println("Digite o NÚMERO DA CASA:");
        medico.setNumDaCasa(sc.nextFloat());

        return medico;
    }

    // Mostrar que o usuário Médico foi cadastrado
    public void medicoCadastrado() {
        System.out.println("Sucesso no cadastro de um novo médico no sistema!");
    }

    // Mostrar que o usuário Médico não foi autenticado
    public void medicoNaoCadastrado() {
        System.out.println("Falha no cadastro!\nTente novamente!");
    }

    public int qtdDeTelefones() {
        System.out.println("Quantos telefones deseja cadastrar (0 para nenhum):");
        return sc.nextInt();
    }
}
