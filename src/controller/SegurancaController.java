package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SegurancaController {
    Scanner sc = new Scanner(System.in);

    public int lerInt(String msgDoConsole, String msgDeErro) {
        int num = 0;
        String input;
        boolean valid = false;

        while (!valid) {
            System.out.println(msgDoConsole);
            input = sc.nextLine();

            try {
                num = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException | InputMismatchException exception) {
                System.out.println(msgDeErro);
            }
        }

        return num;
    }

    public float lerFloat(String msgDoConsole, String msgDeErro) {
        float num = 0;
        String input;
        boolean valid = false;

        while(!valid) {
            System.out.println(msgDoConsole);
            input = sc.nextLine();

            try {
                num = Float.parseFloat(input);
                valid = true;
            } catch (NumberFormatException | InputMismatchException exception) {
                System.out.println(msgDeErro);
            }
        }

        return num;
    }

    public String lerString(String msgDoConsole, String msgDeErro) {
        String input;

        System.out.println(msgDoConsole);
        input = sc.nextLine();

        input = Normalizer.normalize(input, Normalizer.Form.NFKC);
        Pattern pattern = Pattern.compile("[<>]");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(msgDeErro);
            System.out.println(msgDoConsole);
            input = sc.nextLine();
        }

        return input;
    }

    public static String fazerHash(String senha) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(senha.getBytes());

            byte[] resultByteArray = messageDigest.digest();

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : resultByteArray) {
                senha = String.valueOf(stringBuilder.append(String.format("%02x", b)));
            }

            return senha;
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean isCPF(String cpf) {

        cpf = removeCaracteresEspeciais(cpf);

        // considera-se erro cpf's formados por uma sequ??ncia de n??meros iguais
        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11))
            return (false);

        char dig10;
        char dig11;
        int sm;
        int i;
        int r;
        int num;
        int peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1.??. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do cpf em um n??mero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2.??. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    private String removeCaracteresEspeciais(String doc) {
        if (doc.contains(".")) {
            doc = doc.replace(".", "");
        }
        if (doc.contains("-")) {
            doc = doc.replace("-", "");
        }
        if (doc.contains("/")) {
            doc = doc.replace("/", "");
        }
        return doc;
    }
}
