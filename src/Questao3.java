import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Questao3 {
    /** classe que guarda as informações do indice e do texto */
    static class Word {
        String texto;
        String index;

        Word(String index, String texto) {
            this.texto = texto;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        System.out.println(">>>>>>>>Localização de anagramas<<<<<<<");
        System.out.println();

        System.out.print("Insira o texto: ");

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            String texto = entrada.readLine();

            List<Word> palavras = subStrings(texto);

            contaAnagramas(palavras);
        } catch (IOException e) {
            System.err.println("Problema identificado: " + e.getMessage());
        }
    }

    /** localiza todas as palavras possiveis */
    protected static List<Word> subStrings(String texto) {
        List<Word> words = new ArrayList<>();
        for (int i = 0; i < texto.length(); i++) {
            for (int j = i+1; j <= texto.length(); j++) {
                /** adiciona uma palavra ao array, formato: 0,1 -> texto  */
                words.add(new Word(i+","+j, texto.substring(i, j)));
            }
        }
        return words;
    }

    private static void contaAnagramas(List<Word> palavras) {
        /** constroi uma mapa, formato: texto -> [ 0,1 - 1,3 ] */
        HashMap<String, List<String> > map = new HashMap<>();

        for (Word word : palavras) {
            char[] letters = word.texto.toCharArray();  // abb === bba
            Arrays.sort(letters);
            String newWord = new String(letters);

            if (map.containsKey(newWord)) {
                map.get(newWord).add(word.index);
            } else {
                List<String> arr = new ArrayList<>();
                arr.add(word.index);
                map.put(newWord, arr);
            }
        }

        System.out.println("Anagramas encontrados: ");
        int total = 0;
        for (String s : map.keySet()) {
            List<String> values = map.get(s);
            if (values.size() > 1) {
                System.out.print(s);
                System.out.print(" -> ");
                System.out.println(values);
                total++;
            }
        }
        System.out.println("Total: " + total);
    }
}
