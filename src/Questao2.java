import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Questao2 {
    public static void main(String[] args) {
        System.out.println(">>>>>>>>Verificação de Senha forte<<<<<<<");
        System.out.println();

        System.out.print("Digite sua senha: ");

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            String senha = entrada.readLine();

            verificar(senha);
        } catch (IOException e) {
            System.err.println("Problema identificado: " + e.getMessage());
        }
    }

    public static void verificar(String senha)
    {
        char[] letras = senha.toCharArray();
        if (letras.length < 6) { // se a qtd de letras for menor que 6
            int qtdFalta = 6 - letras.length;
            System.out.println("Adicione mais '" + qtdFalta + "' digitos a sua senha.");
        }

        boolean temDigito = false;
        boolean temMaiuscula = false;
        boolean temMinuscula = false;
        boolean temCaracterEspecial = false;

        String caracteresEspeciais = "!@#$%^&*()-+";

        for (char c : letras) { // percorre as letras uma a uma
            if (Character.isDigit(c)) { // a letra é digito?
                temDigito = true;
            } else if (Character.isUpperCase(c)) {  // a letra é maiuscula?
                temMaiuscula = true;
            } else if (Character.isLowerCase(c)) { // a letra é minuscula?
                temMinuscula = true;
            } else if (caracteresEspeciais.contains(Character.toString(c))) {
                // a letra esta na lista dos especiais?
                temCaracterEspecial = true;
            }
        }

        if (!temDigito) {
            System.out.println("Adicione pelo menos um digito a sua senha.");
        }
        if (!temMaiuscula) {
            System.out.println("Adicione pelo menos uma letra maiuscula a sua senha.");
        }
        if (!temMinuscula) {
            System.out.println("Adicione pelo menos uma letra minuscula a sua senha.");
        }
        if (!temCaracterEspecial) {
            System.out.println("Adicione pelo menos uma caracter especial a sua senha.");
        }
    }
}
